public class reverseString {
	public static String reverse(String s) {
		if (s.length() <= 0) {
			return s;
		}

		String rightSide = s.substring(1);

		return reverse(rightSide) + s.charAt(0);
	}

	public static void main(String[] args) {
		System.out.println(reverse("racecar"));
	}
}
