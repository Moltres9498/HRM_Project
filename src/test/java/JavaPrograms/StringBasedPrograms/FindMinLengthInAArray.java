package JavaPrograms.StringBasedPrograms;

public class FindMinLengthInAArray {

	public static void main(String[] args) {
		String[] s= {"ab","abc","bd","abcd","abcde"};
		String min_length=s[0];
		for(String w:s)
		{
			if(w.length()<=min_length.length())
			{
				System.out.println(w);
			}
		}
	}
}