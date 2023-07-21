package JavaPrograms.StringBasedPrograms;

public class ReverseEachWordInString {
	public static void main(String[] args) {  

		String str="I am a sdet engineer";
		String[] words=str.split(" ");
		String reversestr = "";
		for(String w:words)
		{
			String reversewrd = "";
			for(int i=w.length()-1;i>=0;i--)
			{
				reversewrd=reversewrd+w.charAt(i);
			}
			reversestr=reversestr+reversewrd+" ";
		}
		System.out.println("reversed words are =>"+ reversestr);
	}  
}