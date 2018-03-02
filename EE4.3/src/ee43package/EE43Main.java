package ee43package;

public class EE43Main {
	
	/**
	 * countRollDice compte le nombre de lancers de deux dés nécessaire pour obtenir leur somme égale à value
	 * @param value
	 * 				la valeur à obtenir suite à la somme des deux dés
	 * @return
	 * 				le nombre de lancers de deux dés nécessaire pour obtenir leur somme égale à value
	 */
	public static int countRollDice(int value) {
		if (value < 2 || value > 12) {
			throw new IllegalArgumentException("La somme des deux dés est comprise entre 2 et 12");
		}
		
		int dice1 = 0;
		int dice2 = 0;
		int counterRoll = 0;
		
		while (dice1 + dice2 != value) {
			dice1 = rollDiceIndividual();
			dice2 = rollDiceIndividual();
			counterRoll++;
		}
		
		return counterRoll;
	}
	
	/**
	 * rollDiceIndividual simule le lancer d'un dé
	 * @return 
	 * 			une valeur aléatoire entre 1 et 6
	 */
	public static int rollDiceIndividual() {
		return (int) (Math.random() *6) + 1;
	}
	
	public static void main(String[] args) {
		System.out.println("Il vous a fallu " + countRollDice(2) + " lancers de dés avant d'obtenir un 'Snake Eyes'");
	}

}
