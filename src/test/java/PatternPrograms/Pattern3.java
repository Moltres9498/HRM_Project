package PatternPrograms;

import org.testng.annotations.Test;

public class Pattern3 {
@Test
	public void main() {
		for(int i=1;i<=5;i++)
		{
			for(int j=i;j<=5;j++)
			{
				System.out.print(" * ");
			}
			System.out.println(" ");
		}
	}
}