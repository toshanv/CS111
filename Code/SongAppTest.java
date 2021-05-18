/*
 *
 * This class implements a library of songs
 *
 * @author CS111 - Rutgers University
 *
 */
public class SongAppTest {
	private Song[] items;		// keep Songs in an unsorted array
	private int numberOfItems;	// number of Songs in the array

	/*
	 * Default constructor creates array with capacity for 5 Songs
	 */
	SongApp() {
		// ADD YOUR CODE HERE
		this.items = new Song[5];
		this.numberOfItems = 0;
	}

	/*
	 * One argument constructor creates array with user defines capacity
	 *
	 * @param capacity defines the capacity of the Song library
	 */
	SongApp(int capacity) {
		this.items = new Song[capacity];
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
		boolean isFull = true;

		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i] == null) {
				isFull = false;
				this.items[i] = m;
				this.numberOfItems++;
				break;
			}
		}

		if (isFull) {
			this.numberOfItems++;
			Song[] newItems = new Song[this.items.length * 2];

			for (int i = 0; i < this.items.length; i++) {
				newItems[i] = this.items[i];
			}

			newItems[this.items.length] = m;
			this.items = newItems;
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
		boolean itemExists = false;

		for (int i = 0; i < this.numberOfItems; i++) {
			if (this.items[i].equals(m)) {
				itemExists = true;
				this.items[i] = null;
				this.numberOfItems--;
				break;
			}
		}

		if (itemExists) {
			Song[] newArr = new Song[this.items.length];
			int index = 0;

			for (int i = 0; i < this.items.length; i++) {
				if (this.items[i] != null) {
					newArr[index++] = this.items[i];
				}
			}

			this.items = newArr;
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
		Song[] s = new Song[0];

		for (int i = 0; i < this.numberOfItems; i++) {
			Song el = this.items[i];

			for (int j = 0; j < el.getNumberOfWriters(); j++) {
				if (el.getWriterAtIndex(j).equals(songwriter)) {
					s = addSongToArray(s, el);
				}
			}
		}

		return s;
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
		Song[] s = new Song[0];

		for (int i = 0; i < this.numberOfItems; i++) {
			if (this.items[i].getYear() == year) {
				s = addSongToArray(s, this.items[i]);
			}
		}

		return s;
	}

	/*
	 * Return all the Songs with ratings greater then @rating
	 *
	 * @param rating
	 * @return An array of all Songs with rating greater than @rating
	 *
	 */
	public Song[] getSongsWithRatingsGreaterThan(int rating) {
		Song[] s = new Song[0];

		for (int i = 0; i < this.numberOfItems; i++) {
			if (this.items[i].getRating() > rating) {
				s = addSongToArray(s, this.items[i]);
			}
		}

		return s;
	}

	/*
	 * Search for Song name @name using binary search algorithm.
	 * Assumes items is sorted
	 */
	public Song searchSongByName(String name) {
		int low = 0;
		int high = this.numberOfItems - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int compareVal = this.items[mid].getName().compareTo(name);

			if (compareVal == 0) {
				return this.items[mid];
			} else if (compareVal > 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return null;
	}

	/*
	 * Sorts Songs by year using insertion sort
	 */
	public void sortByYear() {
		int itemSorted = 1;

		for (itemSorted = 1; itemSorted < this.numberOfItems; itemSorted++) {
			Song temp = this.items[itemSorted];
			int location = itemSorted - 1;

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
		for (int lastPlace = this.numberOfItems - 1; lastPlace > 0; lastPlace--) {
			int maxLoc = 0;

			for (int j = 1; j <= lastPlace; j++) {
				if (this.items[j].compareTo(this.items[maxLoc]) > 0) {
					maxLoc = j;
				}
			}

			Song temp = this.items[maxLoc];
			this.items[maxLoc] = this.items[lastPlace];
			this.items[lastPlace] = temp;
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

	private Song[] addSongToArray(Song[] arr, Song s) {
		int length = arr.length;

		if ((arr.length == 0) || (arr[0] == null)) {
			length = 0;
		}

		Song[] newArr = new Song[length + 1];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}

		newArr[arr.length] = s;
		return newArr;
	}
}
