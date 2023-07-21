package JavaPrograms;

public class PrintCombinationNum {

	public static void main(String[] args) {
		int[] a= {9,7,8,5,2,4,3,6};
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]+a[j]==11)
				{
					System.out.println(a[i]+" "+a[j]);
				}
			}
		}
	}
}