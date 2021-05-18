public class SongTest {
	public static void main(String[] args) {
		Song song1 = new Song("ABC");
		song1.setYear(150);
		song1.setRating(3);
		song1.addWriter("John");
		song1.addWriter("Bob");
		song1.addWriter("sanJeeV");

		Song song2 = new Song("ABC");
		song2.setYear(150);
		song2.setRating(3);
		song2.addWriter("Bob");
		song2.addWriter("John");
		song2.addWriter("sanjeeV");

		System.out.println(song1.equals(song2));
	}
}
