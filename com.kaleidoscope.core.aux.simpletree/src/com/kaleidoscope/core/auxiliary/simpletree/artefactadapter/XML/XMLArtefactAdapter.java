/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpletree.artefactadapter.XML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

import Simpletree.Folder;
import Simpletree.Node;
import Simpletree.SimpletreeFactory;
import Simpletree.TreeElement;
import Simpletree.impl.FileImpl;
import Simpletree.impl.FolderImpl;

/**
 * @author Srijani
 *
 */
public class XMLArtefactAdapter implements ArtefactAdapter<TreeElement, Path> {

	private final static Logger logger = Logger.getLogger(XMLArtefactAdapter.class);

	public static final String DEFAULT_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<?eclipse version=\"3.0\"?>\r\n";

	// Simple tree model in memory
	private Optional<TreeElement> model;

	// Location of corresponding artefact
	private Path path;

	// Header for (un)parsed XML file
	private String header;

	// list for plugin-files with full path
	private List<String> pluginList = new ArrayList<String>();
	private HashMap<String, Simpletree.File> pluginMap = new HashMap<String, Simpletree.File>();
	private String tempString = "";

	public XMLArtefactAdapter(Path path, String header) {
		this.path = path;
		this.model = Optional.empty();
		this.header = header;
	}

	public XMLArtefactAdapter(String header) {
		this.model = Optional.empty();
		this.header = header;
	}

	public XMLArtefactAdapter(Path path) {
		this(path, DEFAULT_HEADER);

	}

	@Override
	public void parse() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser;
			saxParser = factory.newSAXParser();
			XMLHandler handler = new XMLHandler();
			String stringPath = path.toAbsolutePath().toString();
			System.out.println(stringPath);

			// check if file or folder
			boolean file = checkFileOrFolder(path);
			if (!file) { // if folder
				File folder = new File(stringPath);
				readXMLFileFromFolder(saxParser, folder);
			} else {
				readXMLFile(stringPath, saxParser, handler);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Check if a path represents a file or folder
	 * 
	 * @param path
	 */
	private boolean checkFileOrFolder(Path path) {
		// check if the path exists
		if (java.nio.file.Files.exists(path)) {
			// check if folder or file
			// if folder
			if (java.nio.file.Files.isDirectory(path)) {
				return false;
			}
			// if file
			if (java.nio.file.Files.isRegularFile(path)) {
				return true;
			}
		}
		return true;
	}

	/**
	 * Method for reading XML files from a folder
	 * 
	 * @param saxParser
	 * @param handler
	 */
	private void readXMLFileFromFolder(SAXParser saxParser, File folder) {

		List<String> filePaths = new ArrayList<String>();
		iterateDirectoryContents(folder, filePaths);
		List<Folder> folderStructure = new ArrayList<Folder>();

		// create model for all the files in the list
		for (int k = 0; k < filePaths.size(); k++) {
			String filePath = filePaths.get(k);
			// System.out.println("checking folder");

			String[] folderNameArray = filePath.split("\\\\");
			// create folder structure for the first file
			if (folderStructure.size() == 0) { // for the first plugin.xml
				// System.out.println("Inserting first plugin xml data");
				for (int i = 0; i < folderNameArray.length; i++) {

					if (i == folderNameArray.length - 1) {
						// use SAX parser for XML file
						parseXMLFile(saxParser, filePaths, folderStructure, k);
					} else {
						String folderName = folderNameArray[i];

						if (checkLegalDriveOrFolderName(folderName)) {
							Simpletree.Folder simpleTreeFolder = SimpletreeFactory.eINSTANCE.createFolder();
							simpleTreeFolder.setName(folderNameArray[i]);
							folderStructure.add(simpleTreeFolder);
							if (i != 0) { // the folder is not the root folder
								Folder parentFolder = folderStructure.get(folderStructure.size() - 2);
								simpleTreeFolder.setParentFolder(parentFolder);
							}
						}
					}
				}
			} else {
				for (int j = 0; j < folderNameArray.length; j++) {
					// System.out.println(folderNameArray[j]);
					if (folderStructure.size() > 0 && j < folderStructure.size()) {

						// name not same
						if (!folderStructure.get(j).getName().equals(folderNameArray[j])) {
							Simpletree.Folder simpleTreeFolder = SimpletreeFactory.eINSTANCE.createFolder();
							simpleTreeFolder.setName(folderNameArray[j]);
							Folder parentFolder = folderStructure.get(j).getParentFolder();
							simpleTreeFolder.setParentFolder(parentFolder);
							folderStructure.set(j, simpleTreeFolder);
						} else {
							// name same, but parent different
							if (j > 0) {
								Folder parentFolder1 = folderStructure.get(j - 1);
								String parentFolder2 = folderNameArray[j - 1];
								if (!parentFolder1.getName().equals(parentFolder2)) {
									Simpletree.Folder simpleTreeFolder = SimpletreeFactory.eINSTANCE.createFolder();
									simpleTreeFolder.setName(folderNameArray[j]);
									Folder parentFolder = folderStructure.get(j).getParentFolder();
									simpleTreeFolder.setParentFolder(parentFolder);
									folderStructure.set(j, simpleTreeFolder);
								}
							}

						}

					} else {
						if (folderStructure.size() > 0) {
							if (j == folderNameArray.length - 1) {
								// generating xml file
								// System.out.println("Reading file: " + folderNameArray[j]);
								// use SAX parser for XML file
								parseXMLFile(saxParser, filePaths, folderStructure, k);
							}
						}
					}
				}
			}
		}

		setModel(folderStructure.get(0));
	}

	/**
	 * use SAX parser to create model for XML file
	 * 
	 * @param filePaths
	 * @param saxParser
	 * @param folderStructure
	 */
	private void parseXMLFile(SAXParser saxParser, List<String> filePaths, List<Folder> folderStructure, int index) {
		try {
			XMLHandler handler = new XMLHandler();
			File fileEntry = new File(filePaths.get(index));
			saxParser.parse(fileEntry, handler);
			Node rootNode = handler.getRoot();
			Simpletree.File rootFile = SimpletreeFactory.eINSTANCE.createFile();
			rootFile.setName(fileEntry.getName());
			rootFile.setFolder(folderStructure.get(folderStructure.size() - 1));
			rootFile.setRootNode(rootNode);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param dir
	 * @param filePaths2
	 */
	public List<String> iterateDirectoryContents(File dir, List<String> filePaths) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					iterateDirectoryContents(file, filePaths);
				} else {
					if (getFileExtension(file.getName()).equalsIgnoreCase("xml")) {
						filePaths.add(file.getCanonicalPath());
						System.out.println("file:" + file.getCanonicalPath());
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePaths;
	}

	/**
	 * Method for reading an XML file
	 * 
	 * @param stringPath
	 * @param saxParser
	 * @param handler
	 */
	private void readXMLFile(String stringPath, SAXParser saxParser, XMLHandler handler) {
		System.out.println("Reading file: " + stringPath);
		try {
			saxParser.parse(stringPath, handler);
			Node rootNode = handler.getRoot();
			Simpletree.File rootFile = SimpletreeFactory.eINSTANCE.createFile();
			rootFile.setName(path.toAbsolutePath().toString());
			rootFile.setRootNode(rootNode);
			setModel(rootFile);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * check for forbidden characters [\/:*?"<>|] & folder name can not be "."
	 * 
	 * @param folderName
	 * @return
	 */
	private boolean checkLegalDriveOrFolderName(String folderName) {
		// : is ignored in this folder name, because in windows C: gives drive name and
		// this regex is used for legal driveName or folder name
		final String regex = "^[^\\/\\\\*?\"<>|]{1,}$";
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(folderName);
		while (matcher.find() && !folderName.equalsIgnoreCase(".") && !folderName.equalsIgnoreCase(":")) {
			return true;
		}
		return false;
	}

	@Override
	public void unparse() {
		logger.debug("Unparsing XML to " + path);

		XMLGenerator generateXML = new XMLGenerator();

		try {
			System.out.println(getModel().get() instanceof FolderImpl);

			if (getModel().get() instanceof FolderImpl) { // instance of FolderImpl

				Folder rootFolder = (Folder) getModel().get();
				System.out.println("Root : " + rootFolder);

				// get all xml files from model
				getAllXmlFilesFromModel(rootFolder);

				// iterate pluginMap to generate folders
				for (Map.Entry<String, Simpletree.File> entry : pluginMap.entrySet()) {
					String path = entry.getKey();
					String pathForFolder = path.substring(0, path.lastIndexOf("\\"));
					generateFolderForPath(pathForFolder);
					String fileName = path.substring(path.lastIndexOf("\\")+1);
					Simpletree.File file = entry.getValue();
					
					File xmlFile = new File(path);
					Files.write(generateXML.generate((Node) (file).getRootNode(), header),
							xmlFile, Charsets.UTF_8);
				}

			} else if (getModel().get() instanceof FileImpl) { // instance of FileImpl
				if (path != null && !path.toString().equalsIgnoreCase("")) {
					// check if the path is file or folder
					boolean file = checkFileOrFolder(path);
					if (!file) {
						throw new IllegalArgumentException(
								"Model has root node file, but path given to generate from the model is folder");
					} else {
						final File xmlFile = path.toFile();
						TreeElement toUnparse = model.orElseThrow(() -> new IllegalStateException(
								"There is no model to unparse!  Please set a model first."));
						Files.write(generateXML.generate((Node) ((Simpletree.File) toUnparse).getRootNode(), header),
								xmlFile, Charsets.UTF_8);
					}
				} else {
					throw new IllegalArgumentException("Path variable is not set to save the unparsed XML file");
				}
			} else { // incorrect instance
				throw new IllegalArgumentException(
						"The model to unparsed must be a Simpletree.File or SimpleTree.Folder");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Iterates through model and returns a list of all the xml files
	 * 
	 * @param rootFolder
	 */
	private List<TreeElement> getAllXmlFilesFromModel(Folder parentFolder) {
		if (parentFolder.getSubFolder().size() > 0) {
			for (Folder subFolder : parentFolder.getSubFolder()) {
				getAllXmlFilesFromModel(subFolder);
				if (subFolder.getFile().size() > 0) {
					for (Simpletree.File file : subFolder.getFile()) {
						System.out.println(file.getName());
						if (file.getFolder() != null) {
							String filePath = getFullyQualifiedNameForFolder(file.getFolder())
									+ file.getFolder().getName() + "\\" + file.getName();
							// pluginList.add(filePath);
							pluginMap.put(filePath, file);
							tempString = "";
						} else
							throw new IllegalArgumentException("File must have some parent folder");
					}
				}
			}
		}

		return null;
	}

	/**
	 * 
	 * @param folder
	 * @param tempString
	 * @return
	 */
	private String getFullyQualifiedNameForFolder(Folder folder) {
		if (folder.getParentFolder() != null) {
			Folder parentFolder = folder.getParentFolder();
			tempString = parentFolder.getName() + "\\" + tempString;
			System.out.println(tempString);
			getFullyQualifiedNameForFolder(parentFolder);

		}
		return tempString;
	}

	/**
	 * This method takes the folder path string, checks if those folders exist, if
	 * not, generates them
	 * 
	 * @param folderPath
	 */
	private void generateFolderForPath(String folderPath) {
		if (java.nio.file.Files.exists(Paths.get(folderPath))) {
			System.out.println("This path exists..");
		} else {
			// create that path
			Path createFolder = Paths.get(folderPath);
			try {
				java.nio.file.Files.createDirectories(createFolder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setModel(TreeElement m) {
		model = Optional.of(m);
	}

	@Override
	public void setArtefact(Path a) {
		path = a;
	}

	@Override
	public Optional<TreeElement> getModel() {
		return model;
	}

	@Override
	public Optional<Path> getArtefact() {
		return Optional.of(path);
	}

	/**
	 * Method to get extension for a file
	 * 
	 * @param String
	 * @return
	 */
	private String getFileExtension(String file) {
		try {
			return file.substring(file.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}

}
