package practice;

public class Pattry {


	public static void main(String[] args) {

		int n=5;
		int m=100;
		int pn=1;

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=pn+1;k<=m;k++) {
					pn=k;
					int count=0;
					for(int l=1;l<=pn;l++) {
						if(pn%l==0) {
							count++;
						}
					}
					if(count==2) {
						System.out.print(pn+" ");
						break;
					}
				}
			}
			System.out.println();
		}
	}
}