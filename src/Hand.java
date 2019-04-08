public class Hand {

	public Hand() {
		hand = new Card[9];
	}

	public int getTotal() {
		int count = 0;
		int score = 0;
		while (count < 9 && hand[count] != null) {
			score += hand[count].getValue();
			count++;
		}
		return score;
	}

	public boolean hasAce() {
		int count = 0;
		boolean ace = false;
		while (count < 9 && hand[count] != null) {
			if (hand[count].getValue() == 11) {
				ace = true;
				hand[count].changeValue(1);
			}
			count++;
		}
		return ace;
	}
	
	public void insert(Card card) {
		int count = 0;
		while (count < 9 && hand[count] != null) {
			count++;
		}
		hand[count] = card;
	}

	public String toString() {
		int count = 0;
		String string = "";
		while (count < 9 && hand[count] != null) {
			string += hand[count].toString() + ", ";
			count++;
		}
		return string;
	}
	
	public Card play(int cardLocation) {
		int replace = cardLocation;
		while (hand[replace+1] != null) {
			replace++;
		}

		Card card = hand[cardLocation];
		hand[cardLocation] = hand[replace];
		hand[replace] = null;

		return card;
	}

	private Card[] hand;
}
