package PatternPrograms;

import org.testng.annotations.Test;

public class Pattern11 {
	@Test
	public void pattern() {
	//public static void main(String[] args) {
	for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(" "+i+" ");
			}
			System.out.println(" ");
		}
	}
}