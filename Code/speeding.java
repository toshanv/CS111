public class speeding {
	public static void main(String[] args) {
		System.out.println("Please enter the speed");
		int speed = IO.readInt();
		int fine;

		if (speed <= 60) {
			fine = 0;
		} else if (speed <= 75) {
			fine = 100;
		} else if (speed <= 90) {
			fine = 200;
		} else {
			fine = 500;
		}

		IO.outputStringAnswer("$" + fine + " fine");
	}
}
