package exo2;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;

public class SimpleSaxParser extends DefaultHandler {

	private static String urlToParse;
	private boolean debug = true ;
	
	static public void main(String[] args) {
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
			SimpleSaxParser parser = new SimpleSaxParser() ;
			xmlReader.setContentHandler(parser);

			// 5. Affectation du ErrorHandler avant parsing
			xmlReader.setErrorHandler(new MyErrorHandler(System.err));

			// 6. On parse le document (en donnant son URL) en utilisant le XMLReader
			xmlReader.parse("./src/exo2/wg.xml");
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.exit(0);
	}

	// Affichage d'un message de debug
	public void log(String msg) {
		if (this.debug)
			System.out.print(msg);
	}

	public void startDocument() throws SAXException {
		this.log("Start Document: " + urlToParse + "\n");
	}

	// debut de l'element
	public void startElement(String namespaceURI, String localName, // local name
			String qName, // qualified name
			Attributes atts) throws SAXException {

		// recuperation du nom de l'element
		String eltName = qName;
		this.log("dbt element: " + eltName + "\n");
		for (int i = 0; i < atts.getLength(); i++) {
			// recuperation du nom de l'attribut et de sa valeur
			String attName = atts.getQName(i);
			if ("".equals(attName))
				attName = atts.getQName(i);
			this.log("\tattribut[" + i + "]: " + attName + "="
					+ atts.getValue(i) + "\n");
		}
	}

	// Pour les noeuds textes
	public void characters(char[] ch, int start, int length) {
		String text = new String(ch, start, length);
		this.log("texte: --" + text + "--\n");
	}

	// d'apres vous
	public void endElement(java.lang.String uri, java.lang.String localName,
			java.lang.String qName) throws SAXException {
		String eltName = qName;
		this.log("fin element: " + eltName + "\n");
	}

	// fin du document
	public void endDocument() throws SAXException {
		this.log("End Document\n");
	}

	// ////////////////////////////////////////////////
	/* classe interne pour reporter les erreurs */
	// ////////////////////////////////////////////////

	private static class MyErrorHandler implements ErrorHandler {
		/** Error handler output goes here */
		private PrintStream out;

		MyErrorHandler(PrintStream out) {
			this.out = out;
		}

		private String getParseExceptionInfo(SAXParseException spe) {
			String systemId = spe.getSystemId();
			if (systemId == null) {
				systemId = "null";
			}
			String info = "URI=" + systemId + " Line=" + spe.getLineNumber()
					+ ": " + spe.getMessage();
			return info;
		}

		public void warning(SAXParseException spe) throws SAXException {
			out.println("Warning: " + getParseExceptionInfo(spe));
		}

		public void error(SAXParseException spe) throws SAXException {
			String message = "Error: " + getParseExceptionInfo(spe);
			throw new SAXException(message);
		}

		public void fatalError(SAXParseException spe) throws SAXException {
			String message = "Fatal Error: " + getParseExceptionInfo(spe);
			throw new SAXException(message);
		}
	}
}
