public class Zoo {
	public static void main(String[] args) {
		System.out.print("Enter number of Zoos: ");
		int numZoos = IO.readInt();

		int numGiraffes = 0, totalGiraffes = 0;
		int numLions = 0, totalLions = 0;
		int numSnakes = 0, totalSnakes = 0;

		for (int i = 1; i <= numZoos; i++) {
			System.out.print("Enter number of giraffes for zoo " + i + ": ");
			numGiraffes = IO.readInt();
			totalGiraffes += numGiraffes;

			System.out.print("Enter number of lions for zoo " + i + ": ");
			numLions = IO.readInt();
			totalLions += numLions;

			System.out.print("Enter number of snakes for zoo " + i + ": ");
			numSnakes = IO.readInt();
			totalSnakes += numSnakes;
		}

		IO.outputIntAnswer(totalGiraffes);
		IO.outputIntAnswer(totalLions);
		IO.outputIntAnswer(totalSnakes);
	}
}
