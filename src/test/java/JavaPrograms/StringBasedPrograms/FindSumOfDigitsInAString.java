package JavaPrograms.StringBasedPrograms;

public class FindSumOfDigitsInAString {

	public static void main(String[] args) {
		String s="a1b2d3";
		int sum=0;
		for(int i=0;i<s.length();i++)
		{
			if(Character.isDigit(s.charAt(i))) 
			{
				sum=sum+Character.getNumericValue(s.charAt(i));
			}
		}
		System.out.println("Sum of digits in a string is-->"+sum);
	}
}