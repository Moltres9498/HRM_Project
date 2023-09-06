package JavaPrograms.StringBasedPrograms;

public class SegregateAlphabetsAndSplChars {

	public static void main(String[] args) {
		String str="1b2%a3(t";
		String alp="";
		String cha="";
		String num="";
		
		//		StringBuffer alpha = new StringBuffer(),   
		//				num = new StringBuffer(), 
		//				special = new StringBuffer();  
		//		for (int i=0; i<str.length(); i++)  
		//		{  
		//			if (Character.isDigit(str.charAt(i)))  
		//				num.append(str.charAt(i));  
		//			else if(Character.isAlphabetic(str.charAt(i)))  
		//				alpha.append(str.charAt(i));  
		//			else  
		//				special.append(str.charAt(i));  
		//		}  
		//		System.out.println(alpha);  
		//		System.out.println(num);  
		//		System.out.println(special);  

		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>='0' && str.charAt(i)<='9') {
				num=num+str.charAt(i);
			}else if(str.charAt(i)>='A' && str.charAt(i)<='Z' || str.charAt(i)>='a' && str.charAt(i)<='z') {
				alp=alp+str.charAt(i);
			}else {
				cha=cha+str.charAt(i);
			}
		}
		System.out.println(alp);
		System.out.println(num);
		System.out.println(cha);
	}
}