package exo1bis;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySimpleSaxHandler extends DefaultHandler {

	private int nbTag = 0 ;
	
    public MySimpleSaxHandler() {
            super();
    }

    public void startElement(String nameSpaceURI, String localName, 
    						 String rawName, Attributes attributs) throws SAXException {
    	this.nbTag ++;
    }

	public int getNbTag() {
		return nbTag;
	}

}
