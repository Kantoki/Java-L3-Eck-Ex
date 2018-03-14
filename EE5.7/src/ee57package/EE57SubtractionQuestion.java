package ee57package;

public class EE57SubtractionQuestion implements EE57IntQuestion {
	
	private int a, b;  // The numbers in the problem.
	
	public EE57SubtractionQuestion() { // constructor
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
        
        if (a < b) { // check if a < b in order to do not have a negative answer
        		int temp = a;
        		a = b;
        		b = temp;
        }
    }
	
	@Override
	public String getQuestion() {
		return "What is " + a + " - " + b + " ?";
	}

	@Override
	public int getCorrectAnswer() {
		return a - b;
	}

}
