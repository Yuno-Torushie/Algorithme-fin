package exo1;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class Exo1 extends DefaultHandler{

	private int nbTag = 0 ;
	private int NbAttrs = 0;
	

    public void startElement(String nameSpaceURI, String localName, 
			 String rawName, Attributes attributs) throws SAXException {
    	this.nbTag ++;
    	this.NbAttrs += attributs.getLength();
    }

    public int getNbTag() {
    	return nbTag;
    }
    
    public int getNbAttrs() {
    	return NbAttrs;
    }

	
    
	public static void use_parser_sax(String filein) {
	
		try {
			//
			// 1. Creation d'un JAXP SAXParserFactory et configuration
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// si on veut valider le document par rapport a sa declaration de type
			// factory.setValidating(true);

			// 2. Creation d'un JAXP SAXParser
			SAXParser saxParser = factory.newSAXParser();

			// 3. Obtention du XMLReader
			XMLReader xmlReader = saxParser.getXMLReader();

			// 4. Affectation du ContentHandler pour le XMLReader.
			//    Remarque: on utilise la classe courante
			Exo1 parser = new Exo1();
			xmlReader.setContentHandler(parser);

			// 6. On parse le document (en donnant son URL) en utilisant le XMLReader
			xmlReader.parse(filein);
			
			System.out.println("Fichier : " + filein + " : " + parser.getNbTag() + " balises ");
			System.out.println("Fichier : " + filein + " : " + parser.getNbAttrs() + " Attributs ");

		} catch (Throwable t) {
			t.printStackTrace();
		}
		
	}
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		use_parser_sax("./src/exo1/data/td3_flux.xml");
		use_parser_sax("./src/exo1/data/td3_docbook.xml");
		use_parser_sax("./src/exo1/data/td3_royal.xml");
	}

}
