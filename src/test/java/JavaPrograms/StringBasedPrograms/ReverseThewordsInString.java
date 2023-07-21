package JavaPrograms.StringBasedPrograms;

public class ReverseThewordsInString {

	public static void main(String[] args) {
		String str="I am a sdet engineer";
		String Revstr="";
		for(int i=str.length()-1;i>=0;i--) {
			Revstr=Revstr+str.charAt(i);
		}
		System.out.println("Reversed String with words is =>"+Revstr);
	}
}