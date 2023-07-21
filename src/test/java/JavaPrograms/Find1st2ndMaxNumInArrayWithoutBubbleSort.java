package JavaPrograms;

public class Find1st2ndMaxNumInArrayWithoutBubbleSort {

	public static void main(String[] args) {
		int [] a= {9,7,6,2,4,1};
		int fmin=a[0];
		int Smin=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>=fmin)
			{
				if(a[i] !=fmin)
				{
					Smin=fmin;
				}
				fmin=a[i];
			}
			else if(Smin==fmin || Smin<=a[i])
			{
				Smin=a[i];
			}
		}
		System.out.println(fmin+" "+Smin);
	}
}