package JavaPrograms;

public class FindPrimeNoInArray {

	public static void main(String[] args) {
		int a[]= {1,3,2,4,5,7};
		for(int i=0;i<a.length;i++)
		{
			int n=a[i];
			int count=0;
			for(int j=1;j<=n;j++)
			{
				if(n%j==0)
					count++;
			}
			if(count==2)
				System.out.println("This is a prime number-->"+n);
		}
	}
}