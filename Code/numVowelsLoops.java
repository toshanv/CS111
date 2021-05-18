public class numVowelsLoops {
	public static void main(String[] args) {
		String s = "abcde";
		int numVowels = 0;

		for (int i = 0; i < s.length(); i++) {
			if ("AEIOUaeiou".indexOf(s.charAt(i)) >= 0) {
				numVowels++;
			}
		}

		System.out.println(numVowels);
	}
}
