package JavaPrograms.StringBasedPrograms;

public class FindMaxLengthInAArray {

	public static void main(String[] args) {
		String[] s= {"ab","abc","bd","abcd","abcde","aabbc"};
		String max_length=s[4];
		//for(int i=0;i<s.length;i++)
		 for(String w:s)
		{
			if(w.length()>=max_length.length())
			{
				System.out.println(w);
			}
		}
	}
}