package JavaPrograms.CollectionBasePrograms;

public class PrintPositionOfEachwordWithDup {

	public static void main(String[] args) {
		String str="I am a sdet engineer";
		String[] s=str.split(" ");
		for(int i=0;i<s.length;i++)
		{
			System.out.println(s[i]+"---is present in---"+(i+1)+"---position");
		}
	}
}