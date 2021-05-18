public class StringRec {
	public static String decompress(String compressedText) {
		if (compressedText.length() <= 1) {
			return compressedText;
		}

		if (Character.isLetter(compressedText.charAt(0))) {
			return compressedText.substring(0, 1) + decompress(compressedText.substring(1));
		} else {
			char count = compressedText.charAt(0);
			count--;

			String next = compressedText.substring(1, 2);
			String rem = compressedText.substring(1);
			String newWord = (count <= '1' ? "" : count) + next + rem;
			System.out.println(newWord);
			return decompress(newWord);
		}
	}

	public static void main(String[] args) {
		String compressedText = IO.readString();

		System.out.println(decompress(compressedText));
	}
}
