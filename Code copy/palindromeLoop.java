public class palindromeLoop {
	public static void main(String[] args) {
		String original = "abc";
		String backwards = "";

		for (int i = original.length() - 1; i >= 0; i--) {
			backwards += original.charAt(i);
		}

		if (original.equals(backwards)) {
			System.out.println("The string is a palindrome");
		} else {
			System.out.println("The string is not a palindrome");
		}
	}
}
