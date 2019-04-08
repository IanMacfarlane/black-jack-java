public class Card {

	public Card() {
		suit = "None";
		value = 0;
		face = "0";
		next = null;
	}
	
	public Card(String suit, int value, String face){
		this.suit = suit;
		this.value = value;
		this.face = face;
	}

	public String toString(){
		return face + " of " + suit;
	}

	public int getValue() {
		return value;
	}

	public void changeValue(int value) {
		this.value = value;
	}

	private String suit;
	private int value;
	private String face;

	public Card next;
}
