package JavaPrograms;

import org.testng.annotations.Test;

public class DesscendingOrderUsingBubbleSort {
	@Test
	
	public void ToSortArrayInaAscendingOrderUsingBubbleSort() {
		int a[]= {1,2,9,7,6};
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]<a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
			System.out.print(a[i]+" ");
		}
	}
}