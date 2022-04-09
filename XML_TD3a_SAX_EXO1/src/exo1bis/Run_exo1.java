package exo1bis;



public class Run_exo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MySimpleSaxParser parser = null;

		try {
			parser = new MySimpleSaxParser("./src/exo1/data/td3_flux.xml");
		} catch (Throwable t) {
		    t.printStackTrace();
	    }
		parser.printResults();
		
		try {
			parser = new MySimpleSaxParser("./src/exo1/data/td3_docbook.xml");
		} catch (Throwable t) {
		    t.printStackTrace();
	    }
		parser.printResults();
		
		try {
			parser = new MySimpleSaxParser("./src/exo1/data/td3_royal.xml");
		} catch (Throwable t) {
		    t.printStackTrace();
	    }
		parser.printResults();
		
		System.out.flush();
		System.exit(0);
	}

}
