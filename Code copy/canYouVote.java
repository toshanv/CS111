public class canYouVote {
	public static void main(String[] args) {
		System.out.println("Enter age: ");
		int age = IO.readInt();

		if (age >= 18) {
			IO.outputStringAnswer("You can vote!");
		} else {
			IO.outputStringAnswer("You cannot vote!");
		}
	}
}
