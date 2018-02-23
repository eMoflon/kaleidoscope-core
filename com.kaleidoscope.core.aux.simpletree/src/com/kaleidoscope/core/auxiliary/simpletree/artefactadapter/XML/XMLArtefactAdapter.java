/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpletree.artefactadapter.XML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

import Simpletree.Node;

/**
 * @author Srijani
 *
 */
public class XMLArtefactAdapter implements ArtefactAdapter<Node, Path> {

	private final static Logger logger = Logger.getLogger(XMLArtefactAdapter.class);

	public static final String DEFAULT_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n <?eclipse version=\"3.0\"?>\r\n";
	
	// Simple tree model in memory
	private Optional<Node> model;
	
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
			saxParser.parse(path.toAbsolutePath().toString(), handler);
			Node root = handler.getRoot();
			if (null != root)
				setModel(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unparse() {
		logger.debug("Unparsing XML to " + path);

		XMLGenerator generateXML = new XMLGenerator();

		try {
			final File file = path.toFile();
			Node toUnparse = model.orElseThrow(() -> new IllegalStateException("There is no model to unparse!  Please set a model first."));
			Files.write(generateXML.generate(toUnparse, header), file, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setModel(Node m) {
		model = Optional.of(m);
	}

	@Override
	public void setArtefact(Path a) {
		path = a;
	}

	@Override
	public Optional<Node> getModel() {
		return model;
	}

	@Override
	public Optional<Path> getArtefact() {
		return Optional.of(path);
	}
}
