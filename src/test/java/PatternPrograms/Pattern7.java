package PatternPrograms;

import org.testng.annotations.Test;

public class Pattern7 {
	@Test
	public void main() {
		int n=5;
		for(int i=n;i>=1;i--)
		{
			for(int j=n-1;j>=i;j--)
			{
				System.out.print(" ");
			}
			for(int k=i;k>=1;k--)
			{
				System.out.print(" *");
			}
			System.out.println();
		}
	}
}