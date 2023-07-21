package JavaPrograms;

public class FibonacciSeries {

	public static void main(String[] args) {
		int n = 10;
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		System.out.println("Fibonacci Series from 0 to 10:");
		for (int i = 0; i <= n; i++) {
			System.out.print(fib[i] + " ");
		}
	}
}