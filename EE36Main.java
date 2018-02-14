/* Author : Victor CHEN */

public class EE36Main {

	public static void main(String[] args) {

		int plusGrandDiviseur = 0;
		int nbDiviseur = 0;
		int[] numbers = new int[10001];

		for (int i = 1; i <= 10000; i++) {
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					nbDiviseur++;
				}
			}

			numbers[i] = nbDiviseur;

			if (nbDiviseur > plusGrandDiviseur) {
				plusGrandDiviseur = nbDiviseur;
			}

			nbDiviseur = 0;

		}

		System.out.println("Among integers between 1 and 10000,");
		System.out.println("The maximum number of divisors was " + plusGrandDiviseur);
		System.out.println("Numbers with that many divisors include : ");
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == plusGrandDiviseur) {
				System.out.println(i);
			}
		}

	}

}
