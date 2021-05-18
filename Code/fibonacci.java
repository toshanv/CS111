public class fibonacci {
	public static int fib(int n) {
		if ((n == 1) || (n == 2)) {
			return 1;
		}

		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		System.out.print("Please enter a number: ");
		int n = IO.readInt();
		System.out.println(fib(n));
	}
}
