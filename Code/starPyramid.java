public class starPyramid {
	public static void main(String[] args) {
		System.out.println("Please enter the height");
		int height = IO.readInt();

		int numStars = 1;
		int numSpaces = height - 1;

		while (height > 0) {
			for (int i = numSpaces; i > 0; i--) {
				System.out.print(" ");
			}

			for (int j = numStars; j > 0; j--) {
				System.out.print("*");
			}

			System.out.println();

			numStars += 2;
			numSpaces--;i
			height--;
		}
	}
}
