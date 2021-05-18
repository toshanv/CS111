public class div {
	public static void main(String[] args) {
		int x = IO.readInt();
		int y = IO.readInt();

		if (((x % y == 0) || (y % x == 0)) && ((x % 2 == 0) && (y % 2 == 0)) && (x < y)) {
			System.out.println("All is true");
			return;
		}

		if ((x % y == 0) || (y % x == 0)) {
			System.out.println("div");
		}

		if ((x % 2 == 0) && (y % 2 == 0)) {
			System.out.println("even");
		}

		if (x < y) {
			System.out.println("y bigger");
		}
	}
}
