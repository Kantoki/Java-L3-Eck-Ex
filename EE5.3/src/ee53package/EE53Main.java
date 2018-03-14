package ee53package;

public class EE53Main {
	
	/**
	 * @param pod a PairOfDice
	 * @param value : the value to obtain between 2 and 12
	 * @return count : the number of roll to do in order to obtain the param value
	 */
	public static int nbRollForValue(EE51PairOfDice pod, int value) {
		int count = 0;
		
		if (value < 2 || value > 12) {
			throw new IllegalArgumentException("La somme des deux dés est comprise entre 2 et 12");
		}
		
		while (pod.getTotal() != value) {
			pod.roll();
			count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		EE51PairOfDice pod = new EE51PairOfDice();
		EE52StatCalc calc = new EE52StatCalc();
		int nbExperiments = 10000;
		
		for (int i = 2; i <= 12; i++) {
			
			for (int j = 0; j <= nbExperiments; j++) {
				calc.enter(nbRollForValue(pod, i));
				pod.roll();
			}
			
			System.out.println("Voici les statistiques de vos calculs pour la valeur :" + i + "\n");
			System.out.println("La moyenne du nombre de lancers : " + calc.getMean());
			System.out.println("Le maximum de vos lancers : " + calc.getMax());
			System.out.println("Standard Deviation : " + calc.getStandardDeviation() + "\n");
		}
	}

}
