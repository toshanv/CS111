public class numVowelsRecursion {
	public static int count(String s) {
		if (s.length() == 0) {
			return 0;
		}

		if ("AEIOUaeiou".indexOf(s.charAt(0)) < 0) {
			return count(s.substring(1));
		}

		return count(s.substring(1)) + 1;
	}

	public static void main(String[] args) {
		String s = "abcde";

		System.out.println(count(s));
	}
}
