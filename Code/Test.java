import java.util.Arrays;

public class Test {
	public static String foo(String s) {
		String tmp = "";

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (s.indexOf(c) < 0) {
				tmp +=  c;
			}
		}

		return tmp;
	}

	public static void main(String[] args) {
		// System.out.println(foo("abc"));
		int arr[][] = new int[5][3];
		System.out.println(Arrays.deepToString(arr));
	}
}
