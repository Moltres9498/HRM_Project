package PatternPrograms;

import org.testng.annotations.Test;

public class Pattern15 {
	@Test
	public void main() {
		for(char i='A';i<='E';i++)
		{
			for(char j='A';j<='E';j++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}