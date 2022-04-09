package core;

public class FizzBuzz {
	
	public static String fizzbuzz(int n) {
		String res = String.valueOf(n);
		
		if(15==n)
			res = "FizzBuzz";
		else if(n%3==0)
			res = "Fizz";
		else if(n%5==0)
			res = "Fizz";
		
		return null;
	}

}
