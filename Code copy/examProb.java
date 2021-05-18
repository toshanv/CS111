public class examProb {
	public static void main(String[] args) {
		int a = IO.readInt();
		int b = IO.readInt();
		int z = 0;

		if ((a - b) / 2 <= (b - z)) {
			for (int i = a; i > b; i = i - 2) {
				z++;
			}
		} else {
			for (int j = z; j < b; j++) {
				z++;
			}
		}

		System.out.println(z);
	}
}
