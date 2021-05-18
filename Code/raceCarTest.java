public class RacecarTest {
	public static void main(String[] args) {
		Racecar r = new Racecar(2);
		System.out.println(r.isOutOfFuel());
		System.out.println(r.accelerate());
		System.out.println(r.refuel(3.10));
		System.out.println(r.getCurrentSpeed());
		System.out.println(r.accelerate());
		System.out.println(r.getCurrentSpeed());
		System.out.println(r.accelerate());
		System.out.println(r.getCurrentSpeed());
		System.out.println(r.accelerate());
		System.out.println(r.getCurrentSpeed());
		System.out.println(r.isOutOfFuel());
		System.out.println(r.refuel(3.20));
	}
}
