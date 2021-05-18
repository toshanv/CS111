public class SongDriver {
	public static void main(String[] args) {
		SongApp app = new SongApp();

		printSeparator();
		System.out.println("Created a Song app with the default constructor.");
		System.out.println("Would you like to load in the 7 songs? (Y for yes or n for no)");

		if (IO.readBoolean()) {
			loadSongs(app, getSongs1());
		}

		System.out.println("Would you like to load in the last of the songs? (Y for yes or n for no)");

		if (IO.readBoolean()) {
			loadSongs(app, getSongs2());
		}

		printSeparator();

		printSeparator();
		printSeparator();

		System.out.println("You have loaded a total of: " + app.getNumberOfItems() + " songs.");
		System.out.println("Now entering user interactivity mode.");

		printSeparator();
		printSeparator();

		userActivityMode(app);
	}

	public static void userActivityMode(SongApp app) {
		String operation = "";

		while (!operation.equals("exit")) {
			printSeparator();

			System.out.println("Possible Commands:");
			System.out.println("\tprint:\t\tprint all of the songs.");
			System.out.println("\tsongwriter:\tget all songs by a songwriter.");
			System.out.println("\tyear:\t\tget all songs by a year.");
			System.out.println("\trating:\t\tget all songs about a certain rating.");
			System.out.println("\tremove:\t\tremoves a song at a certain index.");
			System.out.println("\tupdate:\t\tupdate the rating of a song.");
			System.out.println("\tsortByYear:\tsorts all songs by year.");
			System.out.println("\tsortByName:\tsorts all songs by name.");
			System.out.println("\tsearchBS:\tsearchs for a song by its name using binary search.");
			System.out.println("\tsearchRecursive:\tsearchs for a song by its name using recursive linear search.");
			System.out.println("\texit:\t\tstop the program.");
			System.out.println("");
			System.out.println("What would you like to do? (use the commands above. For example, type print to print all songs): ");
			System.out.println("You may type exit or press Control C to stop this program.");

			operation = IO.readString();

			switch (operation) {
				case "exit":
					System.out.println("Goodbye");
					return;

				case "sortByYear":
					app.sortByYear();
					break;

				case "sortByName":
					app.sortByName();
					break;

				case "searchBS":
					appSearchBS(app);
					break;

				case "searchRecursive":
					appSearchRecursive(app);
					break;

				case "print":
					appPrint(app);
					break;

				case "songwriter":
					appSongwriter(app);
					break;

				case "remove":
					appRemove(app);
					break;

				case "update":
					appUpdate(app);
					break;

				case "year":
					appYear(app);
					break;

				case "rating":
					appRating(app);
					break;

				default:
					System.out.println("Unknown command: " + operation);
					break;
			}

			System.out.println("Please press enter to continue.");
			IO.readString();// we ignore whatever is entered, we just was confirmation before continuing.

			printSeparator();
		}
	}

	public static void appPrint(SongApp app) {
		System.out.println("Printing all of the songs stored in the app.");
		app.print();
	}

	public static void appSearchBS(SongApp app) {
		System.out.println("Which Song name would you like to search by?");
		String name = IO.readString();
		Song s = app.searchSongByName(name);

		if (s == null) {
			System.out.println("No song with name: " + name);
		} else {
			System.out.println(s.toString());
		}
	}

	public static void appSearchRecursive(SongApp app) {
		System.out.println("Which Song name would you like to search by?");
		String name = IO.readString();
		Song s = SongApp.searchSongByName(name, app.getSongs(), 0, app.getSongs().length);

		if (s == null) {
			System.out.println("No song with name: " + name);
		} else {
			System.out.println(s.toString());
		}
	}

	public static void appSongwriter(SongApp app) {
		System.out.println("Which Songwriter would you like to search by?");
		String writer = IO.readString();

		Song[] byWriter = app.getSongsBySongwriter(writer);

		System.out.println("Found " + byWriter.length + " songs by writer " + writer + ":");

		for (Song m : byWriter) {
			if (m == null) {
				continue;
			}

			System.out.println(m.toString());
		}
	}

	public static void appYear(SongApp app) {
		System.out.println("Which Year would you like to search by?");
		int year = IO.readInt();

		Song[] byYear = app.getSongsByYear(year);

		System.out.println("Found " + byYear.length + " songs in year " + year + ":");

		for (Song m : byYear) {
			if (m == null) {
				continue;
			}

			System.out.println(m.toString());
		}
	}

	public static void appRating(SongApp app) {
		System.out.println("What is the minimum rating would you like to search by?");
		int rating = IO.readInt();

		Song[] byRating = app.getSongsWithRatingsGreaterThan(rating);

		System.out.println("Found " + byRating.length + " songs with a rating at least " + rating + ":");

		for (Song m : byRating) {
			if (m == null) {
				continue;
			}

			System.out.println(m.toString());
		}
	}

	public static void appUpdate(SongApp app) {
		System.out.println("Here are all of the songs with their numbers:");
		Song[] songs = app.getSongs();

		for (int i = 0; i < app.getNumberOfItems(); i++) {
			System.out.println("[" + i + "]: " + songs[i].toString());
		}

		System.out.println("Please enter the number of the song you'd like to update");
		int i = IO.readInt();

		if ((i < 0) || (i > app.getNumberOfItems())) {
			System.out.println("i out of bounds.");
			return;
		}

		System.out.println("Updating song " + i + ": " + songs[i].toString());

		System.out.println("Enter the new rating for the song [1 through 5]");
		int newRating = IO.readInt();

		app.updateRating(songs[i], newRating);
	}

	public static void appRemove(SongApp app) {
		System.out.println("Here are all of the songs with their numbers:");
		Song[] songs = app.getSongs();

		for (int i = 0; i < app.getNumberOfItems(); i++) {
			System.out.println("[" + i + "]: " + songs[i].toString());
		}

		System.out.println("Please enter the number of the song you'd like to remove");
		int i = IO.readInt();

		if ((i < 0) || (i > app.getNumberOfItems())) {
			System.out.println("i out of bounds.");
			return;
		}

		System.out.println("Removing song " + i + ": " + songs[i].toString());

		app.removeSong(songs[i]);
	}

	public static void printSeparator() {
		System.out.println("====================================================");
	}

	public static void loadSongs(SongApp app, Song[] songs) {
		for (int i = 0; i < songs.length; i++) {
			System.out.println("Loading Song #" + (i + 1) + ": " + songs[i].toString());
			app.addSong(songs[i]);
		}
	}

	public static Song[] getSongs1() {
		String[] names = {"The girl from ipanema", "Hello",              "Dreams",
						  "Stairway to Heaven",    "Losing my Religion", "Havana", "Zombie"};
		int[] numberOfWriters = {2, 1, 2, 2, 4, 10, 1};
		String[] writers = {"Antonio Carlos Jobin", "Vinicius de Moraes", "Adele",
							"Dolores O'Riordan",    "Noel Hogan",         "Jimmy Page",      "Robert Plant",
							"Bill Berry",           "Michael Stipe",      "Mike Mills",      "Peter Buck",
							"Adam Feeney",          "Alexandra Tamposi",  "Andrew Wotman",   "Brendan Perry",
							"Brian Lee",            "Brittany Hazzard",   "Jeffrey Williams","Camila Cabello",
							"Louis Bell",           "Pharrell Williams",  "Dolores O'Riordan"};
		int[] years = {1960, 2015, 1971, 1991, 1994, 2017, 1994};
		int[] ratings = {5, 5, 5, 5, 5, 3, 5};

		int wIndex = 0;

		Song[] songs = new Song[names.length];

		for (int i = 0; i < names.length; i++) {
			songs[i] = new Song(names[i]);
			songs[i].setYear(years[i]);
			songs[i].setRating(ratings[i]);

			// add writers
			for (int k = 0; k < numberOfWriters[i]; k++) {
				songs[i].addWriter(writers[wIndex]);
				wIndex += 1;
			}
		}

		return songs;
	}

	public static Song[] getSongs2() {
		String[] names = {"Linger", "I'm Yours", "A Visita", "Chicken Fried", "Don't Stop (Color On the Walls)", "All About That Bass"};
		int[] numberOfWriters = {2, 1, 1, 2, 1, 2};
		String[] writers = {"Dolores O'Riordan", "Noel Hogan", "Jason Mraz", "Silva", "Zac Brown Band", "Wyatt Durrette", "Mark Foster", "Meghan Trainor", "Kevin Kadish"};
		int[] years = {1993, 2008, 2012, 2008, 2011, 2014};
		int[] ratings = {5, 3, 4, 3, 4, 3};

		int wIndex = 0;

		Song[] songs = new Song[names.length];

		for (int i = 0; i < names.length; i++) {
			songs[i] = new Song(names[i]);
			songs[i].setYear(years[i]);
			songs[i].setRating(ratings[i]);

			// add writers
			for (int k = 0; k < numberOfWriters[i]; k++) {
				songs[i].addWriter(writers[wIndex]);
				wIndex += 1;
			}
		}

		return songs;
	}
}
