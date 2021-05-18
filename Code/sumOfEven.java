public class sumOfEven {
	public static void main(String[] args) {
		System.out.print("Please enter n: ");
		int n = IO.readInt();
		int total = 0;
		int num = 0;

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter number " + i);
			num = IO.readInt();

			if (num % 2 == 0) {
				total += num;
			}
		}

		System.out.println("Even sum: " + total);
	}
}
