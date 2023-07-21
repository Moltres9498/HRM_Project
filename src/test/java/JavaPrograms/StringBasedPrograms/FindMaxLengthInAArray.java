package JavaPrograms.StringBasedPrograms;

public class FindMaxLengthInAArray {

	public static void main(String[] args) {
		String[] s= {"ab","abc","bd","abcd","abcde","aabbc"};
		String min_length=s[4];
		for(int i=0;i<s.length;i++)
		{
			if(s[i].length()>=min_length.length())
			{
				System.out.println(s[i]);
			}
		}
	}
}