package JavaPrograms.MapBasedPrograms;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class PrintPositionOfEachcharWithoutDupUsingMaps {

	public static void main(String[] args) {
		String str="Kannada";
		String s=str.toLowerCase();
		LinkedHashMap<Character, Object> map=new LinkedHashMap<Character, Object>();
		for(int i=0;i<s.length();i++)
		{
			map.put(s.charAt(i),i);
		}
		for(Entry<Character, Object> m:map.entrySet())
		{
			for(int i=0;i<s.length();i++)
			{
				if(m.getKey()==s.charAt(i))
				{
					System.out.println(s.charAt(i)+" is present in "+(i+1)+" position");
					break;
				}
			}
		}
	}
}