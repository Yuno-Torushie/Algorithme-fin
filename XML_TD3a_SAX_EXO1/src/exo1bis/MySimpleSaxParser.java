package exo1bis;


import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class MySimpleSaxParser {
	
	public String filename ;
	private XMLReader xmlReader ;
	private MySimpleSaxHandler saxHandler ;
	
	public MySimpleSaxParser(String filename) throws ParserConfigurationException, SAXException, IOException {
		super();

		this.filename = filename ;
		
		// 1. Creation d'un JAXP SAXParserFactory et configuration
		SAXParserFactory factory = SAXParserFactory.newInstance();

		// si on veut valider le document par rapport a sa declaration de type
		factory.setValidating(false);
		
		// 2. Creation d'un JAXP SAXParser
		SAXParser saxParser = factory.newSAXParser();
		
		// 3. Obtention du XMLReader
		this.xmlReader = saxParser.getXMLReader();

		// 4. Affectation du ContentHandler pour le XMLReader
		this.saxHandler = new MySimpleSaxHandler();
		this.xmlReader.setContentHandler(this.saxHandler);

		// 6. On parse le document (en donnant son URL) en utilisant le XMLReader
		this.xmlReader.parse(this.filename);

	}

	public int getNbTag() {
		return this.saxHandler.getNbTag();
	}

	public void printResults() {
		System.out.println("Fichier : " + this.filename + " : " + this.saxHandler.getNbTag() + " balises ");
	}
	
}
