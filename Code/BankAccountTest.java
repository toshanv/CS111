public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount firstAccount = new BankAccount("123456", "Jack", "Hill Center");
		System.out.println("firstAccount's Account number is " + firstAccount.getAccountNumber());

		BankAccount secondAccount = new BankAccount("234567", "annie", "SERC", 50.0);
		System.out.println(secondAccount.transferMoney(secondAccount, firstAccount, 10));
	}
}
