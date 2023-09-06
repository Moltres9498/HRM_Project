package PatternPrograms;

import org.testng.annotations.Test;

public class Pattern17 {
@Test
	public void main() {
		for(int i=1;i<=5;i++)
		{
			for(int j=4;j>=i;j--)
			{
				System.out.print("");
			}
			for(int k=1;k<=i;k++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}