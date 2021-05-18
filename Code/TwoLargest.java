public class TwoLargest {
	public static void main(String[] args) {
		System.out.print("Enter the terminating value: ");
		double end = IO.readDouble();

		double inputnum = end - 1.0;
		double max1;
		double max2;
		double max = 0;

		System.out.println("Enter numbers");

		max1 = IO.readDouble();

		while (max1 == end) {
			IO.reportBadInput();
			max1 = IO.readDouble();
		}

		max2 = IO.readDouble();

		while (max2 == end) {
			IO.reportBadInput();
			max2 = IO.readDouble();
		}

		if (max1 > max2) {
			max1 = max1;
		} else {
			max = max1;
			max1 = max2;
			max2 = max;
		}

		while (true) {
			inputnum = IO.readDouble();
			System.out.println("your input is >> " + inputnum);

			if (inputnum == end) {
				break;
			}

			if (inputnum > max1) {
				max2 = max1;
				max1 = inputnum;
				System.out.println("Enter another input");
			} else {
				if (inputnum > max2) {
					max2 = inputnum;
					System.out.println("Enter another input");
				}
			}
		}

		IO.outputDoubleAnswer(max1);
		IO.outputDoubleAnswer(max2);
	}
}
