public class numOnlyRecursion {
	public static boolean noDigits(String s) {
		if (s.length() == 0) {
			return true;
		}

		if ((s.charAt(0) < '0') || (s.charAt(0) > '9')) {
			return false;
		}

		return noDigits(s.substring(1));
	}

	public static void main(String[] args) {
		String s = "123abc";

		System.out.println(noDigits(s));
	}
}
