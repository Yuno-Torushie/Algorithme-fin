package lsp;

public class LspTest {

	private static Rectangle getNewRectangle() {
		// it can be an object returned by some factory ... 
		return new Square();
	}
	public static void main (String args[])
	{
		Rectangle aRectangle = LspTest.getNewRectangle();

		aRectangle.setWidth(5);
		aRectangle.setHeight(10);
		// user knows that r it's a rectangle. 
		// It assumes that he's able to set the width & height as for the base class

		System.out.println(aRectangle.getArea());
		// now he's surprised to see that the area is 100 instead of 50.
	}
}
