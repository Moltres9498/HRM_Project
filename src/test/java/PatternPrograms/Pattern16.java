package PatternPrograms;

import org.testng.annotations.Test;

public class Pattern16 {
	@Test
	public void main() {
		for(char i='A';i<='E';i++)
		{
			for(char j='A';j<='E';j++)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}