package defalut;

public class Person {
	
	private int age = 0;
	private boolean majeur = false;

	public void setAge ( int age) {
		majeur = (age >= 18);
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public boolean isMajeur() {
		return majeur;
	}
	
}

