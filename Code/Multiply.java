public class Multiply {
	public static void main(String[] args) {
		System.out.print("Enter number: ");
		int x = IO.readInt();

		System.out.print("Enter number: ");
		int y = IO.readInt();

		int product = x * y;

		IO.outputIntAnswer(product);
	}
}
