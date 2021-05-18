public class bizarre {
	public static String bizarre(String s) {
		String result = "";

		String[] words = s.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() % 2 == 1) {
				result += words[i];
			} else {
				for (int j = words[i].length() - 1; j >= 0; j--) {
					result += words[i].charAt(j);
				}
			}

			if (i != words.length - 1) {
				result += " ";
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "the old home";

		System.out.println(bizarre(s));
	}
}
