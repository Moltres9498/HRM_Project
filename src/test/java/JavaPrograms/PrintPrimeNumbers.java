package JavaPrograms;

public class PrintPrimeNumbers {

	public static void main(String[] args) {
		//		int num = 20;
		//		int count;
		//		for (int i=1; i<=num; i++)
		//			{
		//			count = 0;
		//			for (int j=2; j<=i/2; j++) 
		//			{
		//				if (i%j==0)
		//			{
		//					count++;
		//			}
		//			}
		//			if (count == 0) 
		//			{
		//				System.out.println(i);
		//			}
		//		}
		int num=100;
		int count=0;
		if(num>1)
		{
			for(int i=1;i<=num;i++)
			{
				if(num%i==0)
				{
					count++;
				}
			}
			if(count==2)
			{
				System.out.println("PrimeNumber");
			}
			else
			{
				System.out.println("Not Prime Number");
			}
		}
	}
}