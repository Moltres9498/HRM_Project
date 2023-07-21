package JavaPrograms.MapBasedPrograms;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class PrintPositionOfEachWordWithoutDupUsingMap {

	public static void main(String[] args) {
		String str="I am a am a sdet engineer";
		String[] s=str.split(" ");
		LinkedHashMap<String, Object> map=new LinkedHashMap<String, Object>();
		for(int i=0;i<s.length;i++)
		{
			map.put(s[i],i);
		}
		for(Entry<String, Object> ch:map.entrySet())
		{
			for(int i=0;i<s.length;i++)
			{
				if(ch.getKey()==s[i])
				{
					System.out.println(s[i]+" is present in "+(i+1)+" position");
					break;
				}
			}
		}
	}
}