package exoCo1;

public class TestDateAlAncienne {

	public static void main(String[] args) {
		
		Date uneDateKOmois;
		try {
			uneDateKOmois = new Date (24, 5, 2021);
			System.out.println(uneDateKOmois);
		} catch (DateException e) {
			System.out.println(e.getMessage());
			}

	}
}