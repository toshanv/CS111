public class strMatrix {
	public static void main(String[] args) {
		String[][] matrix =  new String[8][8];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = i + ", " + j;
			}
		}
	}
}
