package PatternPrograms;

import org.testng.annotations.Test;

public class Pattern5 {
@Test
	public void main() {
		int n=5;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<i;j++)
			{
				System.out.print("  ");
			}
			for(int k=i;k<=n;k++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}