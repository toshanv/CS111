public class cipher {
	public static void decode(String original) {
		String newString = "";
		String lowerCase = original.toLowerCase();

		for (int i = 0; i < lowerCase.length(); i++) {
			if (lowerCase.charAt(i) == ' ') {
				newString = newString + " ";
			} else if (lowerCase.charAt(i) == 'a') {
				newString = newString + "z";
			} else if (lowerCase.charAt(i) == '0') {
				newString = newString + "9";
			} else {
				newString = newString + (Character.toString((char)((int)(lowerCase.charAt(i)) - 1)));
			}
		}

		System.out.println(newString);
	}

	public static void main(String[] args) {
		decode(IO.readString());
	}
}
