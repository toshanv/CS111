public class triangle {
	public static void printRow(int n) {
		if (n == 0) {
			System.out.println();
			return;
		}

		System.out.print("*");
		printRow(n - 1);
	}

	public static void pyramid(int n) {
		if (n == 0) {
			return;
		}

		pyramid(n - 1);
		printRow(n);
	}

	public static void main(String[] args) {
		System.out.print("Please enter a number: ");
		int n = IO.readInt();
		pyramid(n);
	}
}
