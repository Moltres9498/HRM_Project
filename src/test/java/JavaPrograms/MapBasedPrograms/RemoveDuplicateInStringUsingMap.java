package JavaPrograms.MapBasedPrograms;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class RemoveDuplicateInStringUsingMap {

	public static void main(String[] args) {
		String st="Kannada";
		String s=st.toLowerCase();
		LinkedHashMap<Character, Object> map=new LinkedHashMap<Character, Object>();
		for(int i=0;i<s.length();i++)
		{
			map.put(s.charAt(i),i);
		}
		for(Entry<Character, Object> m:map.entrySet())
		{
			System.out.print(m.getKey()+" ");
		}
	}
}