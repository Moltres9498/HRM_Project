package PatternPrograms;

import org.testng.annotations.Test;

public class Pattern2 {
@Test
public void pattering() {
	//public static void main(String[] args) {
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(" * ");
			}
			System.out.println(" ");
		}
	}
}