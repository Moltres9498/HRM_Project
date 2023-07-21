package JavaPrograms.MapBasedPrograms;

import java.util.LinkedHashSet;

public class PrintOccurenceOfEachWordInStringUsingMap {

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
			int count=0;
			for(int i=0;i<s.length;i++)
			{
				if(ch.equals(s[i]))
				{
					count++;
				}
			}
			System.out.println(ch+" "+count);
		}
	}
}