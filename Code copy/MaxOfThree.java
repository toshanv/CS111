public class MaxOfThree {
	public static void main(String[] args) {
		// READ x, y, z
		double x = IO.readDouble();
		double y = IO.readDouble();
		double z = IO.readDouble();
		// SET max to x
		double max = x;

		// IF (y>maz)
		if (y > max) {
			//    SET max to y
			max = y;
		}

		// IF (z>max)
		if (z > max) {
			//    SET max to z
			max = x;
		}
	}
}
