/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpletree.artefactadapter.XML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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

	public XMLArtefactAdapter(Path path, String header) {
		this.path = path;
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

			// check if the patha exists
			if (java.nio.file.Files.exists(path)) {
				// check if folder or file
				// if folder
				if (java.nio.file.Files.isDirectory(path)) {
					File folder = new File(stringPath);
					readXMLFileFromFolder(saxParser, folder);
				}
				// if file
				if (java.nio.file.Files.isRegularFile(path)) {
					readXMLFile(stringPath, saxParser, handler);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method for reading XML files from a folder
	 * 
	 * @param saxParser
	 * @param handler
	 */
	private void readXMLFileFromFolder(SAXParser saxParser, File folder) {
		// create folder structure
		String[] folderNameArray = folder.getAbsolutePath().split("\\\\");
		List<Folder> folderStructure = new ArrayList<Folder>();
		String fileName = folderNameArray[folderNameArray.length - 1];
		for (int i = 0; i < folderNameArray.length; i++) {
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

		for (final File fileEntry : folder.listFiles()) {
			// read only .xml files
			if (getFileExtension(fileEntry.getName()).equalsIgnoreCase("xml")) {
				System.out.println(fileEntry.getName());
				System.out.println("Reading file: " + fileEntry.getName());

				try {
					XMLHandler handler = new XMLHandler();
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
		}
		
		setModel(folderStructure.get(0));

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
			final File file = path.toFile();
			TreeElement toUnparse = model.orElseThrow(
					() -> new IllegalStateException("There is no model to unparse!  Please set a model first."));
			if (toUnparse instanceof Simpletree.File) {
				Files.write(generateXML.generate((Node) ((Simpletree.File) toUnparse).getRootNode(), header), file,
						Charsets.UTF_8);
			} else {
				throw new IllegalArgumentException("The model to unparsed must be a Simpletree.File with a root node.");
			}
		} catch (IOException e) {
			e.printStackTrace();
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
