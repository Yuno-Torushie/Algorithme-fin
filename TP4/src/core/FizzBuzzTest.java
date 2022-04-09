package core;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

	@Test
	public void testAvecValeurUn() {
		//acteur
		//action
		String res = FizzBuzz.fizzbuzz(1);
		//assertation
		Assert.assertEquals("Probleme avec ne nombre 1","1", res);
	}
	
	@Test
	public void testAvecValeurDeux() {
		//acteur
		//action
		String res = FizzBuzz.fizzbuzz(2);
		//assertation
		Assert.assertEquals("Probleme avec ne nombre 2","2", res);
	}
	
	@Test
	public void testAvecValeurTrois() {
		//acteur
		//action
		String res = FizzBuzz.fizzbuzz(3);
		//assertation
		Assert.assertEquals("Probleme avec ne nombre 3","Fizz", res);
		
		res = FizzBuzz.fizzbuzz(6);
		//assertation
		Assert.assertEquals("Probleme avec ne nombre 6","Fizz", res);
		
		res = FizzBuzz.fizzbuzz(9);
		//assertation
		Assert.assertEquals("Probleme avec ne nombre ","Fizz", res);
	}

}
