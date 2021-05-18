public class midterm2Review {
	public static int reverse(int n) {
		int t = 0;

		while (n != 0) {
			t = t * 10;
			t += n % 10;
			n = n / 10;
		}

		return t;
	}

	public static int thirdE(String s) {
		return s.indexOf("e", s.indexOf("e", s.indexOf("e") + 1) + 1);
	}

	public static int numberOfLetter(String s, char n) {
		String sub = "";

		if (s.indexOf(n) == -1) {
			return 0;
		}

		sub = s.substring(s.indexOf(n) + 1);
		return 1 + numberOfLetter(sub, n);
	}

	public static void main(String[] args) {
		// String s = IO.readString();
		// char n = IO.readChar();

		int n = IO.readInt();
		System.out.println(reverse(n));
	}
}
