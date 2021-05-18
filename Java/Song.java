public class Song {
	private String name;
	private int year;
	private int numberOfWriters;
	private String[] writers = new String[50];
	private int rating;

	// Constructor
	public Song(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	public void setRating(int rating) {
		if ((rating >= 1) && (rating <= 5)) {
			this.rating = rating;
		}
	}

	public int getRating() {
		return this.rating;
	}

	public void addWriter(String writerName) {
		boolean present = false;

		for (int k = 0; k < this.numberOfWriters; k++) {
			if (this.writers[k].equals(writerName)) {
				present = true;
			}
		}

		if (present == false) {
			this.writers[this.numberOfWriters] = writerName;
			this.numberOfWriters++;
		}
	}

	public String[] getWriters() {
		return this.writers;
	}

	public int getNumberOfWriters() {
		return numberOfWriters;
	}

	public String getWriterAtIndex(int index) {
		return writers[index];
	}

	public String toString() {
		return name + ", " + year + ", " + rating;
	}

	public boolean equals(Object other) {
		boolean present = false;

		if (!(other instanceof Song)) {
			return false;
		}

		Song song2 = (Song)other;

		// checks name
		if (!song2.getName().equalsIgnoreCase(this.name)) {
			return false;
		}

		// checks NumberOfWriters
		if (this.numberOfWriters != song2.getNumberOfWriters()) {
			return false;
		}

		// checks year
		if (this.year != song2.getYear()) {
			return false;
		}

		// checks writers
		for (int i = 0; i < this.numberOfWriters; i++) {
			present = false;

			if (this.writers[i] != null) {
				for (int j = 0; j < song2.getNumberOfWriters(); j++) {
					if (song2.getWriterAtIndex(j) == null) {
						continue;
					}

					if (this.writers[i].equalsIgnoreCase(song2.getWriterAtIndex(j))) {
						present = true;
					}
				}

				if (present == false) {
					return false;
				}
			}
		}

		return true;
	}

	public int compareTo(Song other) {
		return this.name.compareTo(other.getName());
	}
}
