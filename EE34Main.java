import java.util.Scanner;

/* Author : Victor CHEN */

public class EE34Main {

	public static void main(String[] args) {

		String str;
		String[] words;

		System.out.println("Enter a String to split");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();

		str = str.replace("\"", "");
		str = str.replace(".", "");
		str = str.replace(",", "");

		for (int i = 0; i < str.length(); i++) {
			char chr = str.charAt(i);
			char lastChar = str.charAt(str.length() - 1);

			if (i != 0 && i != str.length() - 1) {
				if (chr == '\'') {
					if (Character.isLetter(str.charAt(i - 1)) == false
							|| Character.isLetter(str.charAt(i + 1)) == false) { // check the apostrophe
						str = str.replace(chr, ' ');
					}
				}
			}

			if (lastChar == '\'') {
				str = str.replace(lastChar, ' ');
			}

		}

		str = str.replaceAll("\\s+", " "); // delete multiple spaces in a row
		words = str.split("\\s"); // split the String to multiple words

		for (String w : words) {
			System.out.println(w);
		}

	}
}
