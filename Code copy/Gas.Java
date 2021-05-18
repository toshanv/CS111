public class Gas {
	public static void main(String[] args) {
		double total;

		System.out.print("Enter cost of gallon of gas: ");
		double cost = IO.readDouble();

		if (cost < 0) {
			IO.reportBadInput();
			cost = IO.readDouble();
		}

		System.out.print("Enter number of gallons: ");
		Double gallons = IO.readDouble();

		if (gallons < 0) {
			IO.reportBadInput();
			gallons = IO.readDouble();
		}

		System.out.print("Is customer paying with a credit card? ");
		boolean credit = IO.readBoolean();

		if (credit == true) {
			total = cost * gallons * 1.1;
		} else {
			total = cost * gallons;
		}

		IO.outputDoubleAnswer(total);
	}
}
