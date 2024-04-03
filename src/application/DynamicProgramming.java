package application;

import java.util.*;

public class DynamicProgramming {
	public static String[][] b, b1 = null;
	public static String s = "";
	public static String printNum = "";
	public static String printALU = "";
	public static String[] leds;

//=============================main==================================================
	public static void main(String[] args) {
		Random Generator = new Random();
		int count = 10;

		String[] sorses = new String[count];
		for (int i = 0; i < count; i++) {
			sorses[i] = i + 1 + "";
		}

		// System.out.println(sorses);
		leds = new String[count];
		for (int iCount = 0; iCount < count;) {
			int randomNumber = Generator.nextInt(count + 1);
			Boolean b1 = randomNumber != 0;
			Boolean b2 = Arrays.asList(leds).contains(randomNumber);
			if (b2 == false && b1 == true) {
				leds[iCount] = randomNumber + "";
//			leds[iCount] = iCount + 1 + "";
				iCount++;
				// }
			}
		}
		for (int i = 0; i < leds.length; i++) {
			//System.out.print(sorses[i] + " ");

		}
		System.out.println();
		for (int i = 0; i < leds.length; i++) {
			//System.out.print(leds[i] + " ");

		}
		// System.out.println();

	//	 ensertsnaw(sorses, leds);
		System.out.println(tableofcountsnew(sorses, leds));

		// ensert("abcadc", "mkblad");
		// System.out.println("\nnumofLeds" + numofLedsnew(sorses, leds));
//
		// System.out.println("The longest commom subsequence =" +
		// CommomSubsequencesnewaray(sorses, leds));
		// for (int i = 0; i < numofLedsnew(sorses, leds); i++) {
		// CommomSubsequencesnewaray(sorses, leds);

		// }
/////				CommomSubsequence("abcbdab", "bdcabab"));
//		System.out.println(tableofcountsnew(sorses, leds));
//		System.out.println(tableofAULsnew(sorses, leds));
////		// tableofAUL("abcbdab", "bdcaba");
		// System.out.println("\n\nThe longest commom subsequence =" +
		// CommomSubsequencesnew(sorses, leds));

	}

//=============================ensert==================================================

	public static void ensertsnaw(String[] s1, String[] s2) {

		b = new String[s1.length + 1][s2.length + 1];
		LCSString(s1, s2, b);
		print_LCSString(b, s1, s1.length, s2.length);

	}

//=============================numofLed==================================================
	public static int numofLedsnew(String[] s1, String[] s2) {

		b = new String[s1.length + 1][s2.length + 1];

		return LCSString(s1, s2, b);
	}

//=============================CommomSubsequence==================================================
	public static String CommomSubsequencesnew(String[] s1, String[] s2) {

		b = new String[s1.length + 1][s2.length + 1];

		LCSString(s1, s2, b);

		return CommomSubsequences(b, s1, s1.length, s1.length);
	}

	public static String[] CommomSubsequencesnewaray(String[] s1, String[] s2) {
		b = new String[s1.length + 1][s2.length + 1];
		LCSString(s1, s2, b);
		String[] d = CommomSubsequencesarray(b, s1, s1.length, s1.length).split(",");
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);// ;
		}
		return d;
	}

//=============================tableofcount==================================================
	public static String tableofcountsnew(String[] s1, String[] s2) {

		b = new String[s1.length + 1][s2.length + 1];
		for (int[] row : LCSArrrs(s1, s2, b)) {
			// converting each row as string
			// and then printing in a separate line
			printNum += toStringn(row) + "\n\n";
		}
		return printNum;
	}

	
	
	 public static String toStringn(int[] a) {
	        if (a == null)
	            return "null";
	        int iMax = a.length - 1;
	        if (iMax == -1)
	            return "[]";

	        StringBuilder b = new StringBuilder();
	        b.append("");
	        for (int i = 0; ; i++) {
	            b.append(a[i]);
	            if (i == iMax)
	                return b.append("").toString();
	            b.append("     ");
	        }
	    }

//=============================tableofAUL==================================================
	public static String tableofAULsnew(String[] s1, String[] s2) {
		printALU = "";
		b = new String[s1.length + 1][s2.length + 1];
		LCSArrrs(s1, s2, b);
		for (String[] row : b) {
			printALU += Arrays.toString(row) + "\n";
		}
		return printALU;
	}

//=============================LCS==================================================

	public static int LCSString(String[] x, String[] y, String[][] b) {
		int[][] c = new int[x.length + 1][y.length + 1];
		int count = 0;
		c[0][0] = 0;

		if (x.length == 0 || y.length == 0)
			return 0;

		for (int i = 1; i <= x.length; i++) { // Initial values
			c[i][0] = 0;
			b[i][0] =  "";
		}

		for (int j = 1; j <= y.length; j++) { // Initial values
			c[0][j] = 0;
			b[0][j] = "";
		}

		for (int i = 1; i <= x.length; i++) {
			for (int j = 1; j <= y.length; j++) {
				if (x[i - 1].equals(y[j - 1])) { // If equal valuesch1[i].equals(ch2[i])]
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = "A";
				} else { // if x[i] != y[j]

					if (c[i - 1][j] < c[i][j - 1]) {
						// System.out.println(x[i - 1]);

						c[i][j] = c[i][j - 1];
						b[i][j] = "L";
					} else {
						c[i][j] = c[i - 1][j];
						b[i][j] = "U";
					}
				}
				count = c[i][j];
			}
		}

		return count;
	}

//=============================LCSArrr==================================================
	public static int[][] LCSArrr(char[] x, char[] y, String[][] b) {
		int[][] c = new int[x.length + 1][y.length + 1];
		int count = 0;
		// c[0][0] = 0;

		if (x.length == 0 || y.length == 0)
			return null;

		for (int i = 1; i <= x.length; i++) { // Initial values
			c[i][0] = 0;
			b[i][0] = " ";
		}

		for (int j = 1; j <= y.length; j++) { // Initial values
			c[0][j] = 0;
			b[0][j] = " ";
		}

		for (int i = 1; i <= x.length; i++) {
			for (int j = 1; j <= y.length; j++) {
				if (x[i - 1] == y[j - 1]) { // If equal values
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = "A";
				} else { // if x[i] != y[j]

					if (c[i - 1][j] < c[i][j - 1]) {
						c[i][j] = c[i][j - 1];
						b[i][j] = "L";
					} else {
						c[i][j] = c[i - 1][j];
						b[i][j] = "U";
					}
				}
				count = c[i][j];
			}
		}

		return c;
	}

	public static int[][] LCSArrrs(String[] x, String[] y, String[][] b) {
		int[][] c = new int[x.length + 1][y.length + 1];
		int count = 0;
		// c[0][0] = 0;

		if (x.length == 0 || y.length == 0)
			return null;

		for (int i = 1; i <= x.length; i++) { // Initial values
			c[i][0] = 0;
			b[i][0] = " ";
		}

		for (int j = 1; j <= y.length; j++) { // Initial values
			c[0][j] = 0;
			b[0][j] = " ";
		}

		for (int i = 1; i <= x.length; i++) {
			for (int j = 1; j <= y.length; j++) {
				if (x[i - 1].equals(y[j - 1])) { // If equal values
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = "A";
				} else { // if x[i] != y[j]

					if (c[i - 1][j] < c[i][j - 1]) {
						c[i][j] = c[i][j - 1];
						b[i][j] = "L";
					} else {
						c[i][j] = c[i - 1][j];
						b[i][j] = "U";
					}
				}
				count = c[i][j];
			}
		}

		return c;
	}

//=============================print_LCS==================================================
	// arr is the array of arrows
	// x is the vector of the character on any one of the two strings
	// i & j are the final index
	public static void print_LCSString(String[][] arr, String[] x, int i, int j) {
		if (i == 0 || j == 0) { // If length is zero
			// arr[0][0] = " ";
			return;
		}

		if (arr[i][j] == "A") {
			print_LCSString(arr, x, i - 1, j - 1);
			System.out.print(x[i - 1] + "  ");
		} else if (arr[i][j] == "L")
			print_LCSString(arr, x, i, j - 1);
		else
			print_LCSString(arr, x, i - 1, j);

	}

//=============================CommomSubsequence==================================================
	public static String CommomSubsequencesarray(String[][] arr, String[] x, int i, int j) {
		s = "";
		if (i == 0 || j == 0) { // If length is zero
			return "";
		}

		if (arr[i][j] == "A") {
			CommomSubsequencesarray(arr, x, i - 1, j - 1);
			s += (x[i - 1] + ",");
			// System.out.println(s1[i]);

		} else if (arr[i][j] == "L") {
			CommomSubsequencesarray(arr, x, i, j - 1);
			// System.out.println(s);
		} else {
			CommomSubsequencesarray(arr, x, i - 1, j);
			// System.out.print(s+"lllllllll");
		}
		return s;

	}

	public static String CommomSubsequences(String[][] arr, String[] x, int i, int j) {
		s = "";
		if (i == 0 || j == 0) { // If length is zero
			return "";
		}

		if (arr[i][j] == "A") {
			CommomSubsequences(arr, x, i - 1, j - 1);
			s += (x[i - 1] + " ");
		} else if (arr[i][j] == "L") {
			CommomSubsequences(arr, x, i, j - 1);
			// System.out.println(s);
		} else {
			CommomSubsequences(arr, x, i - 1, j);
		}
		return s;

	}

}