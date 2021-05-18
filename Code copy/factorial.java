public class factorial {
	public static int fac(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * fac(n - 1);
		}
	}

	public static void main(String[] args) {
		System.out.print("Please enter a number: ");
		int n = IO.readInt();
		System.out.println(fac(n));
	}
}
