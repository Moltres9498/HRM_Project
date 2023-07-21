package practice;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Collectionprac {
	
	@Test
	
		public void arraylist() {
		ArrayList<Object> al=new ArrayList<Object>();
		al.add(10);
		al.add("its working");
		al.add(null);
		al.add(10);
		al.add(null);
		al.add(true);
		System.out.println(al);
		}
}
