public class Compress {
	public static String compress(String original) {
		String encodedString = "";

		for (int i = 0, count = 1; i < original.length(); i++) {
			if ((i + 1 < original.length()) && (original.charAt(i) == original.charAt(i + 1))) {
				count++;
			} else {
				if (count == 1) {
					encodedString = encodedString.concat(original.substring(i, i + 1));
				} else {
					encodedString = encodedString.concat(Integer.toString(count)).concat(Character.toString(original.charAt(i)));
					count = 1;
				}
			}
		}

		return encodedString;
	}

	public static void main(String[] args) {
		String original = IO.readString();

		System.out.println(compress(original));
	}
}
