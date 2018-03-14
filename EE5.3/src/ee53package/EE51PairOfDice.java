package ee53package;

public class EE51PairOfDice {
	
	private int die1;
	private int die2;
	
	public EE51PairOfDice() {
		
	}
	
	/**
	 * Roll a die which has a value between 1 and 6
	 */
	public void roll() {
		this.die1 = (int) ((Math.random() * 6) + 1);
		this.die2 = (int) ((Math.random() * 6) + 1);
	}
	
	/**
	 * @return value of die1
	 */
	public int getDie1() {
		return die1;
	}
	
	/**
	 * @return value of die2
	 */
	public int getDie2() {
		return die2;
	}
	
	/**
	 * setDie1 allows to set the value of die1
	 * @param value between 1 and 6
	 */
	public void setDie1(int value) {
		if (value < 1 || value > 6) {
			throw new IllegalArgumentException("Valeur du dé incorrecte !");
		}
		
		else {
			this.die1 = value;
		}
	}
	
	/**
	 * setDie2 allows to set the value of die2
	 * @param value between 1 and 6
	 */
	public void setDie2(int value) {
		if (value < 1 || value > 6) {
			throw new IllegalArgumentException("Valeur du dé incorrecte !");
		}
		
		else {
			this.die2 = value;
		}
	}
	
	/**
	 * @return sum of die1 and die2
	 */
	public int getTotal() {
		return die1 + die2;
	}

}
