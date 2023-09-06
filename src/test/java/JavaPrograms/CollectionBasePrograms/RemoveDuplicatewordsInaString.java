package JavaPrograms.CollectionBasePrograms;

import java.util.LinkedHashSet;

public class RemoveDuplicatewordsInaString {

	public static void main(String[] args) {
		String str="I am a am a sdet engineer";
		String[] s=str.split(" ");
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		for(String w:s)
		{
			set.add(w);
		}
		for(String w:set)
		{
			System.out.print(w+" ");
		}	
	}
}