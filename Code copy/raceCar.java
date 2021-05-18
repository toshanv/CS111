public class Racecar {
	// Fields go here
	private int gas;
	private int capacity;
	private int speed;

	// In the beginning, the car has a full tank of gas and is going 0 MPH.
	public Racecar(int capacity) {
		this.capacity = capacity;
		this.gas = capacity;
		this.speed = 0;
	}

	// Gets the current speed of the car
	public int getCurrentSpeed() {
		return this.speed;
	}

	// Attempts to accelerate the car.
	// If there isn’t enough fuel, this function should return false
	// If there is enough fuel, you should decrease the amount of fuel by 1 and
	// increase the speed by 10.
	public boolean accelerate() {
		if (gas >= 1) {
			this.speed = this.speed + 10;
			this.gas--;
			return true;
		}

		return false;
	}

	// This function should return true if the car is out of fuel, and false
	// otherwise.
	public boolean isOutOfFuel() {
		if (this.gas == 0) {
			return true;
		}

		return false;
	}

	// This function is meant to refuel the car.
	// Given the costPerGallon, compute and return how much the total bill to
	// refuel the tank is, and then refill the tank to capacity.
	public double refuel(double costPerGallon) {
		int emptySpace = this.capacity - this.gas;
		this.gas = this.capacity;
		return (double)(emptySpace * costPerGallon);
	}
}
