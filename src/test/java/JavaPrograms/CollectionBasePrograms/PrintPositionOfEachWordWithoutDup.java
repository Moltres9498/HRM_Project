package JavaPrograms.CollectionBasePrograms;

import java.util.LinkedHashSet;

public class PrintPositionOfEachWordWithoutDup {

	public static void main(String[] args) {
		String str="I am a am a sdet engineer";
		String[] s=str.split(" ");
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		for(int i=0;i<s.length;i++)
		{
			set.add(s[i]);
		}
		for(String ch:set)
		{
			for(int i=0;i<s.length;i++)
			{
				if(ch==s[i])
				{
					System.out.println(s[i]+" is present in "+(i+1)+" position");
					break;
				}
			}
		}
	}
}