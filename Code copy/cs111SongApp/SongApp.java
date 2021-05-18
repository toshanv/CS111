/*
 *
 * This class implements a library of songs
 *
 * @author CS111 - Rutgers University
 *
 */
public class SongApp {
	private Song[] items;		// keep Songs in an unsorted array
	private int numberOfItems;	// number of Songs in the array

	/*
	 * Default constructor creates array with capacity for 5 Songs
	 */
	SongApp() {
		items = new Song[5];
		this.numberOfItems = 0;
	}

	/*
	 * One argument constructor creates array with user defines capacity
	 *
	 * @param capacity defines the capacity of the Song library
	 */
	SongApp(int capacity) {
		items = new Song[capacity];
		this.numberOfItems = 0;
	}

	/*
	 * Add a Song into the library (unsorted array)
	 *
	 * If the library is full (there is not enough space to add another Song)
	 *   - create a new array with double the size of the current array.
	 *   - copy all current Songs into new array
	 *   - add new Song
	 *
	 * @param m The Song to be added to the libary
	 */
	public void addSong(Song m) {
		boolean filled = true;

		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i] == null) {
				filled = false;
				this.items[i] = m;
				this.numberOfItems++;
				break;
			}
		}

		if (filled) {
			this.numberOfItems++;
			Song[] temp = new Song[this.items.length * 2];

			for (int i = 0; i < this.items.length; i++) {
				temp[i] = this.items[i];
			}

			temp[this.items.length] = m;
			this.items = temp;
		}

		System.out.println(this.numberOfItems);
	}

	/*
	 * Removes a Song from the library. Returns true if Song is removed, false
	 * otherwise.
	 * The array should not become sparse after a remove, that is, all Songs
	 * should be in consecutive indexes in the array.
	 *
	 * @param m The Song to be removed
	 *
	 */
	public boolean removeSong(Song m) {
		boolean present = false;

		for (int i = 0; i < this.numberOfItems; i++) {
			if (this.items[i].equals(m)) {
				present = true;
				this.items[i] = null;
				this.numberOfItems--;
				break;
			}
		}

		if (present) {
			Song[] temp = new Song[this.items.length];
			int tempIndex = 0;

			for (int i = 0; i < this.items.length; i++) {
				if (this.items[i] != null) {
					temp[tempIndex] = this.items[i];
					tempIndex++;
				}
			}

			this.items = temp;
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Returns the library of songs
	 *
	 * @return The array of Songs
	 */
	public Song[] getSongs() {
		return this.items;
	}

	/*
	 * Returns the current number of Songs in the library
	 *
	 * @return The number of items in the array
	 */
	public int getNumberOfItems() {
		return this.numberOfItems;
	}

	/*
	 * Update the rating of Song @m to @rating
	 *
	 * @param @m The Song to have its ratings updated
	 * @param @rating The new rating of @m
	 * @return tue if update is successfull, false otherwise
	 *
	 */
	public boolean updateRating(Song m, int rating) {
		for (int i = 0; i < this.numberOfItems; i++) {
			if (this.items[i].getName() == m.getName()) {
				this.items[i].setRating(rating);
				return true;
			}
		}

		return false;
	}

	/*
	 * Prints all Songs
	 */
	public void print() {
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i] != null) {
				System.out.println(this.items[i].toString());
			}
		}
	}

	/*
	 * Return all the Songs by @songwriter. The array size should be the
	 * number of Songs by @songwriter.
	 *
	 * @param songwriter The songwriter's name
	 * @param An array of all the Songs by @songwriter
	 *
	 */
	public Song[] getSongsBySongwriter(String songwriter) {
		Song[] a = new Song[0];

		for (int i = 0; i < this.numberOfItems; i++) {
			Song el = this.items[i];

			for (int j = 0; j < el.getNumberOfWriters(); j++) {
				if (el.getWriterAtIndex(j).equals(songwriter)) {
					a = addSongToArray(a, el);
				}
			}
		}

		return a;
	}

	/*
	 * Return all the Songs released in @year. The array size should be the
	 * number of Songs made in @year.
	 *
	 * @param year The year the Songs were made
	 * @return An array of all the Songs made in @year
	 *
	 */
	public Song[] getSongsByYear(int year) {
		Song[] a = new Song[0];

		for (int i = 0; i < this.numberOfItems; i++) {
			if (this.items[i].getYear() == year) {
				a = addSongToArray(a, this.items[i]);
			}
		}

		return a;
	}

	/*
	 * Return all the Songs with ratings greater then @rating
	 *
	 * @param rating
	 * @return An array of all Songs with rating greater than @rating
	 *
	 */
	public Song[] getSongsWithRatingsGreaterThan(int rating) {
		Song[] a = new Song[0];

		for (int i = 0; i < this.numberOfItems; i++) {
			if (this.items[i].getRating() > rating) {
				a = addSongToArray(a, this.items[i]);
			}
		}

		return a;
	}

	/*
	 * Search for Song name @name using binary search algorithm.
	 * Assumes items is sorted
	 */
	public Song searchSongByName(String name) {
		int lower = 0;
		int higher = this.numberOfItems - 1;

		while (lower <= higher) {
			int middle = (lower + higher) / 2;
			int compareVal = this.items[middle].getName().compareTo(name);

			if (compareVal == 0) {
				return this.items[middle];
			} else if (compareVal > 0) {
				higher = middle - 1;
			} else {
				lower = middle + 1;
			}
		}

		return null;
	}

	/*
	 * Sorts Songs by year using insertion sort
	 */
	public void sortByYear() {
		int sorted = 1;

		for (sorted = 1; sorted < this.numberOfItems; sorted++) {
			Song temp = this.items[sorted];
			int location = sorted - 1;

			while (location >= 0 && this.items[location].getYear() > temp.getYear()) {
				this.items[location + 1] = this.items[location];
				location -= 1;
			}

			this.items[location + 1] = temp;
		}
	}

	/*
	 * Sorts array of Songs by name using selection sort
	 */
	public void sortByName() {
		for (int last = this.numberOfItems - 1; last > 0; last--) {
			int max = 0;

			for (int j = 1; j <= last; j++) {
				if (this.items[j].compareTo(this.items[max]) > 0) {
					max = j;
				}
			}

			Song temp = this.items[max];
			this.items[max] = this.items[last];
			this.items[last] = temp;
		}
	}

	/*
	 * Search for Song name using recursive linear search
	 * @param name The name of the song to search
	 * @param Songs The array containing all songs
	 * @param l The left index
	 * @param r The right index
	 * @return The song with name @name or null if song is not found
	 */
	public static Song searchSongByName(String name, Song[] Songs, int l, int r) {
		if (l == r) {
			return null;
		}

		if (Songs[l].getName().compareTo(name) == 0) {
			return Songs[l];
		}

		l = l + 1;

		return searchSongByName(name, Songs, l, r);
	}

	private Song[] addSongToArray(Song[] array, Song a) {
		int length = array.length;

		if ((array.length == 0) || (array[0] == null)) {
			length = 0;
		}

		Song[] newArray = new Song[length + 1];

		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}

		newArray[array.length] = a;
		return newArray;
	}
}
