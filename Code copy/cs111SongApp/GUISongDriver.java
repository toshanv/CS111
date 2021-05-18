/**
 * This class uses Java Swing to work as a GUI for the SongDriver by Ana Centeno and Joseph Boyle.
 * <p>11/29/2018</p>
 *
 * @author Ana Centeno
 * @author Jay Manchiraju
 * @author Joseph Boyle
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GUISongDriver extends JPanel implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	static SongApp app = new SongApp();
	static String yearSortString = "Sort by year";
	static String nameSortString = "Sort by name";
	static String binarySearchString = "Binary search by name";
	static String recursiveSearchString = "Recursive linear search by name";
	static String printString = "Display all songs";
	static String songWriterString = "Search by songwriter";
	static String yearString = "Search by year";
	static String ratingString = "Search by rating";
	static String removeString = "Remove a song";
	static String updateString = "Update a song's rating";

	public GUISongDriver() {
		super(new BorderLayout());

		// Create the radio buttons.
		JRadioButton printButton = new JRadioButton(printString);
		printButton.setMnemonic(KeyEvent.VK_A);
		printButton.setActionCommand(printString);
		printButton.setSelected(true);

		JRadioButton yearSortButton = new JRadioButton(yearSortString);
		yearSortButton.setMnemonic(KeyEvent.VK_B);
		yearSortButton.setActionCommand(yearSortString);
		yearSortButton.setSelected(true);

		JRadioButton nameSortButton = new JRadioButton(nameSortString);
		nameSortButton.setMnemonic(KeyEvent.VK_C);
		nameSortButton.setActionCommand(nameSortString);
		nameSortButton.setSelected(true);

		JRadioButton binarySearchButton = new JRadioButton(binarySearchString);
		binarySearchButton.setMnemonic(KeyEvent.VK_D);
		binarySearchButton.setActionCommand(binarySearchString);
		binarySearchButton.setSelected(true);

		JRadioButton recursiveSearchButton = new JRadioButton(recursiveSearchString);
		recursiveSearchButton.setMnemonic(KeyEvent.VK_E);
		recursiveSearchButton.setActionCommand(recursiveSearchString);
		recursiveSearchButton.setSelected(true);

		JRadioButton songWriterButton = new JRadioButton(songWriterString);
		songWriterButton.setMnemonic(KeyEvent.VK_E);
		songWriterButton.setActionCommand(songWriterString);
		songWriterButton.setSelected(true);

		JRadioButton yearButton = new JRadioButton(yearString);
		yearButton.setMnemonic(KeyEvent.VK_E);
		yearButton.setActionCommand(yearString);
		yearButton.setSelected(true);

		JRadioButton ratingButton = new JRadioButton(ratingString);
		ratingButton.setMnemonic(KeyEvent.VK_E);
		ratingButton.setActionCommand(ratingString);
		ratingButton.setSelected(true);

		JRadioButton removeButton = new JRadioButton(removeString);
		removeButton.setMnemonic(KeyEvent.VK_E);
		removeButton.setActionCommand(removeString);
		removeButton.setSelected(true);

		JRadioButton updateButton = new JRadioButton(updateString);
		updateButton.setMnemonic(KeyEvent.VK_E);
		updateButton.setActionCommand(updateString);
		updateButton.setSelected(true);

		JLabel topText = new JLabel("        MAIN MENU        ");

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(printButton);
		group.add(yearSortButton);
		group.add(nameSortButton);
		group.add(binarySearchButton);
		group.add(recursiveSearchButton);
		group.add(songWriterButton);
		group.add(yearButton);
		group.add(ratingButton);
		group.add(removeButton);
		group.add(updateButton);

		printButton.addActionListener(this);
		yearSortButton.addActionListener(this);
		nameSortButton.addActionListener(this);
		binarySearchButton.addActionListener(this);
		recursiveSearchButton.addActionListener(this);
		songWriterButton.addActionListener(this);
		yearButton.addActionListener(this);
		ratingButton.addActionListener(this);
		removeButton.addActionListener(this);
		updateButton.addActionListener(this);

		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(topText);

		radioPanel.add(printButton);
		radioPanel.add(yearSortButton);
		radioPanel.add(nameSortButton);
		radioPanel.add(binarySearchButton);
		radioPanel.add(recursiveSearchButton);
		radioPanel.add(songWriterButton);
		radioPanel.add(yearButton);
		radioPanel.add(ratingButton);
		radioPanel.add(removeButton);
		radioPanel.add(updateButton);

		add(radioPanel, BorderLayout.LINE_START);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == printString) {
			appPrint(app, "Song list");
		}

		if (e.getActionCommand() == yearSortString) {
			app.sortByYear();
			appPrint(app, "Sorted by year");
		}

		if (e.getActionCommand() == nameSortString) {
			app.sortByName();
			appPrint(app, "Sorted by name");
		}

		if (e.getActionCommand() == binarySearchString) {
			appSearchBS(app);
		}

		if (e.getActionCommand() == recursiveSearchString) {
			appSearchRecursive(app);
		}

		if (e.getActionCommand() == songWriterString) {
			appSongwriter(app);
		}

		if (e.getActionCommand() == yearString) {
			appYear(app);
		}

		if (e.getActionCommand() == ratingString) {
			appRating(app);
		}

		if (e.getActionCommand() == removeString) {
			appRemove(app);
		}

		if (e.getActionCommand() == updateString) {
			appUpdate(app);
		}
	}

	public static void appSearchRecursive(SongApp app) {
		String name = JOptionPane.showInputDialog(null, "Which Song name would you like to search by?");

		if ((name == null) || name.equals("")) {
			return;
		}

		Song s = SongApp.searchSongByName(name, app.getSongs(), 0, app.getSongs().length);

		if (s == null) {
			JOptionPane.showMessageDialog(null, "No song with name: " + name, "Song not found", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Song: " + s.toString(), "Song found", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void appSearchBS(SongApp app) {
		String name = JOptionPane.showInputDialog(null, "Which Song name would you like to search by?");

		if ((name == null) || name.equals("")) {
			return;
		}

		Song s = app.searchSongByName(name);

		if (s == null) {
			JOptionPane.showMessageDialog(null, "No song with name: " + name, "Song not found", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Song: " + s.toString(), "Song found", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void appSongwriter(SongApp app) {
		String writer = JOptionPane.showInputDialog(null, "Which Songwriter would you like to search by?");

		if ((writer == null) || writer.equals("")) {
			return;
		}

		Song[] byWriter = app.getSongsBySongwriter(writer);

		if (byWriter.length == 0) {
			JOptionPane.showMessageDialog(null, "No Songs found", "Found " + byWriter.length + " songs by writer " + writer + ":", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, byWriter, "Found " + byWriter.length + " songs by writer " + writer + ":", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void appYear(SongApp app) {
		try {
			String yearInputString = JOptionPane.showInputDialog(null, "Which year would you like to search by?");

			if ((yearInputString == null) || yearInputString.equals("")) {
				return;
			}

			int year = Integer.parseInt(yearInputString);

			Song[] byYear = app.getSongsByYear(year);

			if (byYear.length == 0) {
				JOptionPane.showMessageDialog(null, "No Songs found", "Found " + byYear.length + " songs in year " + year + ":", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, byYear, "Found " + byYear.length + " songs in year " + year + ":", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void appRating(SongApp app) {
		try {
			String rateInputString = JOptionPane.showInputDialog(null, "What is the minimum rating would you like to search by?");

			if ((rateInputString == null) || rateInputString.equals("")) {
				return;
			}

			int rating = Integer.parseInt(rateInputString);

			Song[] byRating = app.getSongsWithRatingsGreaterThan(rating);

			if (byRating.length == 0) {
				JOptionPane.showMessageDialog(null, "No Songs found", "Found " + byRating.length + " songs: ", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, byRating, "Found " + byRating.length + " songs: ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void appRemove(SongApp app) {
		try {
			GUISongDriver.appPrintNumbers(app, "Song numbers:");

			String deleteInputString = (JOptionPane.showInputDialog(null, "Please enter the number of the song you'd like to remove"));

			if ((deleteInputString == null) || deleteInputString.equals("")) {
				return;
			}

			int deletion = Integer.parseInt(deleteInputString);
			boolean b = app.removeSong(app.getSongs()[deletion]);

			if (b) {
				JOptionPane.showMessageDialog(null, "Deleted Song: " + deletion + " from the list", "Deletion successful", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void appPrint(SongApp app, String title) {
		JOptionPane.showMessageDialog(null, app.getSongs(), title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void appPrintNumbers(SongApp app, String title) {
		String[] arr = new String[app.getNumberOfItems()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.toString(i) + ": " + app.getSongs()[i];
		}

		JOptionPane.showMessageDialog(null, arr, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void appUpdate(SongApp app) {
		try {
			GUISongDriver.appPrintNumbers(app, "Song numbers:");

			String updateInputString = (JOptionPane.showInputDialog(null, "Please enter the number of the song you'd like to update"));

			if ((updateInputString == null) || updateInputString.equals("")) {
				return;
			}

			int updateIndex = Integer.parseInt(updateInputString);

			if ((updateIndex >= app.getNumberOfItems()) || (updateIndex < 0)) {
				JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			updateInputString = JOptionPane.showInputDialog(null, "Enter the new rating for Song (1 to 5): " + updateIndex);

			if ((updateInputString == null) || updateInputString.equals("")) {
				return;
			}

			if ((Integer.parseInt(updateInputString) > 5) || (Integer.parseInt(updateInputString) < 1)) {
				JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			int updateInt = Integer.parseInt(updateInputString);
			app.updateRating(app.getSongs()[updateIndex], updateInt);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void loadSongs(SongApp app, Song[] songs) {
		for (int i = 0; i < songs.length; i++) {
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

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("SongApp Driver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JComponent newContentPane = new GUISongDriver();
		newContentPane.setOpaque(true);	// content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		JOptionPane.showMessageDialog(null, "Created a Song app with the default constructor.", "SongApp Driver", JOptionPane.INFORMATION_MESSAGE);

		int initialLoad1 = JOptionPane.YES_NO_OPTION;
		int initialLoadResult1 = JOptionPane.showConfirmDialog(null, "Would you like to load in the 7 songs?", "SongApp Driver", initialLoad1);

		if (initialLoadResult1 == 0) {
			loadSongs(app, getSongs1());
		}

		int initialLoad2 = JOptionPane.YES_NO_OPTION;
		int initialLoadResult2 = JOptionPane.showConfirmDialog(null, "Would you like to load in the last of the songs?", "SongApp Driver", initialLoad2);

		if (initialLoadResult2 == 0) {
			loadSongs(app, getSongs2());
		}

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
