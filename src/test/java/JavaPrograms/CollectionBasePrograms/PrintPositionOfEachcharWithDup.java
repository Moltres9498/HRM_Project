package JavaPrograms.CollectionBasePrograms;

public class PrintPositionOfEachcharWithDup {

	public static void main(String[] args) {
		String s="Kannada";
		for(int i=0;i<s.length();i++)
		{
			System.out.println(s.charAt(i)+" is present in "+(i+1)+" position");
		}
	}
}