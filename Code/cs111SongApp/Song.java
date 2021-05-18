/*
 * Song class defines a song.
 *
 * @author CS111 - Rutgers University
 */
public class Song {
	private String name;		// Song's name
	private String writers[];	// An array of writer's names, max is 50
	private int numberOfWriters;// Number of writers for this song
	private int year;			// Release year
	private int rating;			// Range [1-5]: 1 (didn't like it), 5 (love it)

	/*
	 * Constructor initializes the new Song object
	 * @param name is the movie's name
	 */
	public Song(String name) {
		setName(name);
		writers = new String[50];
		numberOfWriters = 0;
		year = 0;
		rating = 0;
	}

	/*
	 * Updates the song's name
	 * @param name is the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Returns the movie name
	 * @return String the name of the movie
	 */
	public String getName() {
		return name;
	}

	/*
	 * Updates the movie's year
	 * @param year is the year of the movie's release
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/*
	 * Return the movie's release year
	 * @return int This is the movie's release year
	 */
	public int getYear() {
		return year;
	}

	/*
	 * Update the movie's rating
	 * @param rating This is the movie's rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/*
	 * Returns the movie's rating
	 * @returns int This is the movie's rating
	 */
	public int getRating() {
		return rating;
	}

	/*
	 * Adds an writer to the Song
	 * @param writerName is the writer being added
	 */
	public void addWriter(String writerName) {
		if (numberOfWriters < 50) {
			writers[numberOfWriters] = writerName;
			numberOfWriters += 1;
		} else {
			System.out.println("Array of writers is full (max is 50 writers)");
		}
	}

	/*
	 * Returns the song's writers list
	 * @returns String[] This is the song's writer list
	 */
	public String[] getWriters() {
		return writers;
	}

	/*
	 * @returns int This song's number of writers
	 */
	public int getNumberOfWriters() {
		return numberOfWriters;
	}

	/*
	 * Returns the writer name at @index on the song's writers list
	 * @param index This is the index in the writer's array
	 * @return String The writer's name
	 */
	public String getWriterAtIndex(int index) {
		if (index > numberOfWriters) {
			System.out.println("Error: no writer at index " + index);
			return null;
		} else {
			return writers[index];
		}
	}

	public boolean equals(Object other) {
		if ((other == null) || !(other instanceof Song)) {
			return false;
		}

		Song otherSong = (Song)other;

		if ((numberOfWriters != otherSong.getNumberOfWriters()) ||
			!otherSong.getName().equals(name) ||
			(otherSong.getYear() != year)) {
			return false;
		}

		// check if all writers of this object are on otherSong
		for (int i = 0; i < numberOfWriters; i++) {
			for (int k = 0; k < otherSong.getNumberOfWriters(); k++) {
				if (writers[i].equals(otherSong.getWriterAtIndex(k))) {
					break;
				} else if (k == otherSong.getNumberOfWriters() - 1) {
					// writers[i] not in otherSong, already looked at all items in otherSong
					return false;
				}
			}
		}

		return true;
	}

	/*
	 * Compares this Song name against @other lexicographically.
	 * @return int positive number if s1 > s2, negative number if s1 < s2, zero if s1 == s2
	 */
	public int compareTo(Song other) {
		return this.name.compareTo(other.getName());
	}

	/*
	 * toString
	 */
	public String toString() {
		String result = name + ", " + year + ", " + rating;
		result += ", [";

		for (int i = 0; i < numberOfWriters; i++) {
			result += writers[i];

			if (i < numberOfWriters - 1) {
				result += ", ";
			}
		}

		result += "]";
		return result;
	}
}
