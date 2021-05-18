public class BuyingApples {
	public static void main(String[] args) {
		double total;

		System.out.print("Enter cost per LB: ");
		double cost = IO.readDouble();

		System.out.print("Enter number of pounds: ");
		Double apples = IO.readDouble();

		total = cost * apples;

		if ((cost < 0) || (apples < 0)) {
			IO.reportBadInput();
		} else {
			IO.outputDoubleAnswer(total);
		}
	}
}
