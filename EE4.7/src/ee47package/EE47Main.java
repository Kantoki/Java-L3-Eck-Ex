package ee47package;

import java.util.Scanner;

public class EE47Main {
	
	private static int[] firstNumber = new int[10];
	private static int[] secondNumber = new int[10];
	private static int[] userAnswer = new int[10];
	
	/**
	 * Génère un quiz avec des valeurs comprises entre 0 et 99 pour les paramètres des additions
	 */
	public static void generateQuiz() {
		for (int i = 0; i < firstNumber.length; i++) {
			firstNumber[i] = (int)(Math.random() * 100); // génère un nombre aléatoire entre 0 à 100
			secondNumber[i] = (int)(Math.random() * 100); // génère un nombre aléatoire entre 0 à 100
		}
	}
	
	/**
	 * Pose à l'utilisateur les 10 additions à calculer et stocke ses réponses
	 */
	public static void adminQuiz() {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < userAnswer.length; i++) {
			System.out.println("Question " + (i+1) + ", Combien font : " + firstNumber[i] + " + " + secondNumber[i] + " ?");
			userAnswer[i] = sc.nextInt();
		}
		
		sc.close();
	}
	
	/**
	 * Teste les réponses de l'utilisateur au quiz, lui affiche ses bonnes et mauvaises réponses et son score final
	 */
	public static void testQuiz() {
		int userScore = 0;
		
		for (int i = 0; i < userAnswer.length; i++) {
			System.out.println("Question " + (i+1) + ", " + firstNumber[i] + " + " + secondNumber[i] + " = ? \t");
			System.out.println("Vous avez dit : " + userAnswer[i] + "\t");
			
			if (userAnswer[i] == firstNumber[i] + secondNumber[i]) {
				System.out.println("Bonne réponse !");
				userScore += 10;
			}
			else {
				System.out.println("Mauvaise réponse ! La bonne réponse était : " + (firstNumber[i] + secondNumber[i]));
			}
			
		}
		
		System.out.println("Votre score est de " + userScore + " points !!");
	}
	
	
	public static void main(String[] args) {
		generateQuiz();
		adminQuiz();
		testQuiz();
	}
	
	

}
