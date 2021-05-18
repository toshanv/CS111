public class MaxOfTwo {
	public static double maxOfTwo(double x, double y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

	public static void main(String[] args) {
		System.out.println("Please enter first number: ");
		double num1 = IO.readDouble();

		System.out.println("Please enter second number: ");
		double num2 = IO.readDouble();

		double result = maxOfTwo(num1, num2);
		IO.outputDoubleAnswer(result);
	}
}
