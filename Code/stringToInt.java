public class stringToInt {
	public static void main(String[] args) {
		String s = "1234";
		char currChar;
		int total = 0;

		for (int i = 0; i < s.length(); i++) {
			currChar = s.charAt(i);
			total *= 10;
			total += (currChar - '0');
		}

		System.out.println(total);
	}
}
