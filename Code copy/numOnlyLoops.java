public class numOnlyLoops {
	public static boolean test(String s) {
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) < '0') || (s.charAt(i) > '9')) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "abc123";

		System.out.println(test(s));
	}
}
