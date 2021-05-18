public class BankAccount {
	public String name;
	private String accountNumber;
	private double balance;
	private String address;

	// Constructor
	public BankAccount(String acctnum, String name, String addr) {
		accountNumber = acctnum;
		this.name = name;
		address = addr;
		balance = 0.0;
	}

	// Constructor 2
	public BankAccount(String acctnum, String name, String addr, double initialDeposit) {
		accountNumber = acctnum;
		this.name = name;
		address = addr;
		balance = initialDeposit;
	}

	// Getter
	public String getAccountNumber() {
		return this.accountNumber;
	}

	//Depositing money
	public boolean depositMoney(double amount) {
		if (amount > 0) {
			this.balance += amount;
			return true;
		} else {
			return false;
		}
	}

	//transfering money
	public boolean transferMoney(BankAccount from, BankAccount to, double amount) {
		if ((amount > 0) && (from.balance >= amount)) {
			to.balance += amount;
			from.balance -= amount;
			return true;
		}

		return false;
	}
}
