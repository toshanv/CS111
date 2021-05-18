public class pascalTriangle {
	public static void print(int k) {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(calculate(i, j) + " ");
			}

			System.out.println("");
		}
	}

	public static int calculate(int x, int y) {
		if ((y == 0) || (y == x)) {
			return 1;
		}

		return calculate(x - 1, y - 1) + calculate(x - 1, y);
	}

	public static void main(String[] args) {
		print(IO.readInt());
	}
}
