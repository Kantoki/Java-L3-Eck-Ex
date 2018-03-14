package ee57package;

import java.util.Scanner;

public class EE57Main {
	
	private static EE57IntQuestion[] questions;
	private static int[] userAnswers;
	private static int nbQuestions = 0;

	public static void main(String[] args) {
		generateQuiz();
		adminQuiz();
		testQuiz();
	}
	
	/**
	 * Génère un quiz avec des valeurs comprises entre 0 et 99 pour les paramètres des additions
	 * @return une liste de calculs comprenant des additions et soustractions
	 */
	public static EE57IntQuestion[] generateQuiz() {
		System.out.println("Entrez le nombre de questions dans le quiz");
		Scanner sc = new Scanner(System.in);
		nbQuestions = sc.nextInt();
		
		
		questions = new EE57IntQuestion[nbQuestions];
		userAnswers = new int[nbQuestions];
		
		for (int i = 0; i < nbQuestions; i++) {
			if (Math.random() < 0.5) {
				questions[i] = new EE57AdditionQuestion();
			}
			else {
				questions[i] = new EE57SubtractionQuestion();
			}
		}
		
		return questions;
		
	}
	
	/**
	 * Pose à l'utilisateur les 10 calculs à calculer et stocke ses réponses
	 */
	public static void adminQuiz() {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < userAnswers.length; i++) {
			System.out.println("Question " + (i+1) + ", " + questions[i].getQuestion());
			userAnswers[i] = sc.nextInt();
		}
		
		sc.close();
	}
	
	/**
	 * Teste les réponses de l'utilisateur au quiz, lui affiche ses bonnes et mauvaises réponses et son score final
	 */
	public static void testQuiz() {
		int userScore = 0;
		
		for (int i = 0; i < userAnswers.length; i++) {
			System.out.println("\nQuestion " + (i+1) + ", " + questions[i].getQuestion() + "\t");
			System.out.println("Vous avez dit : " + userAnswers[i] + "\t");
			
			if (userAnswers[i] == questions[i].getCorrectAnswer()) {
				System.out.println("Bonne réponse !");
				userScore += 10;
			}
			else {
				System.out.println("Mauvaise réponse ! La bonne réponse était : " + questions[i].getCorrectAnswer());
			}
			
		}
		
		System.out.println("\nVotre score est de " + userScore + " points !!");
	}
}
