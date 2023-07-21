package JavaPrograms.MapBasedPrograms;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class CountNoofVowelsWithDuplicatesUsingMap {

	public static void main(String[] args) {
		String str="India";
		String s=str.toLowerCase();
		LinkedHashMap<Character, Object> map=new LinkedHashMap<Character, Object>();
		for(int i=0;i<s.length();i++)
		{
			map.put(s.charAt(i),i);
		}
		int count=0;
		for(Entry<Character, Object> ch:map.entrySet())
		{
			if(ch.getKey()=='a' || ch.getKey()=='e' || ch.getKey()=='i' || ch.getKey()=='o' || ch.getKey()=='u')
			{
				count++;
				System.out.print(ch+" ");
			}
		}
		System.out.print("-->"+count);
	}
}