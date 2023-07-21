package JavaPrograms.StringBasedPrograms;

public class CountNoOfVowelsInString {

	public static void main(String[] args) {
		String str="India";
		String s=str.toLowerCase();
		int vcount=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
				vcount++;
		}
		System.out.println("Number of vowels in word are-->"+vcount);
	}
}