package JavaPrograms.StringBasedPrograms;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the word");
		String s =sc.nextLine();
		String rev="";
		for(int i=s.length()-1;i>=0;i--)
		{
			rev=rev+s.charAt(i);
		}
		if(rev.equals(s))
		{
			System.out.println("Its palindrome");
		}
		else
		{
			System.out.println("its not palindrome");
		}
	}
}