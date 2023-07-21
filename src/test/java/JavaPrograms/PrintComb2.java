package JavaPrograms;

public class PrintComb2 {

	public static void main(String[] args) {
		int[] a= {4,2,5,1,3};
		int[]b= {3,1,6,4};

		int len=a.length;
		if(a.length<b.length)
		{
			len=b.length;
		}
		for(int i=0; i<len;i++)
		{
			try 
			{
				System.out.print(a[i]+b[i]+" ");	
			}
			catch (Exception e) {
				if(a.length<b.length)
				{
					System.out.println(b[i]);
				}
				else
				{
					System.out.println(a[i]);
				}
			}
		}
	}
}