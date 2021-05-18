public class DonateToPaws {
	public static double donationFee(double donationAmount) {
		double fee = 0;

		if (donationAmount <= 150) {
			fee = 3;
		} else if (donationAmount < 1500) {
			if ((donationAmount * 0.04) < 8) {
				fee = 8;
			} else {
				fee = (donationAmount * .04);
			}
		} else if (donationAmount < 15000) {
			if ((donationAmount * 0.01) < 20) {
				fee = 20;
			} else {
				fee = (donationAmount * .01);
			}
		} else {
			fee += (15000 * 0.01);
			donationAmount = donationAmount - 15000;

			if ((donationAmount > 0) && (donationAmount <= 4000)) {
				fee += (donationAmount * 0.02);
			} else if (donationAmount > 4000) {
				fee += (4000 * 0.02);
				donationAmount -= 4000;
				fee += (donationAmount * 0.03);
			}
		}

		return fee;
	}

	public static void main(String[] args) {
		System.out.print("Enter donation amount: ");
		double donationAmount = IO.readDouble();

		double fee = donationFee(donationAmount);

		IO.outputDoubleAnswer(fee);
	}
}
