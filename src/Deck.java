public class Deck {

	public Deck() {
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		int[] values = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
		String[] faces = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

		for (int s = 0; s < 4; s++) {
			for (int f = 0; f < 13; f++) {
				insert(new Card(suits[s], values[f], faces[f]));
			}
		}
	}

	public void printDeck(){
		Card temp = head;
		int counter = 0;
		while (temp != null) {
			System.out.println(temp.toString());
			temp = temp.next;
			counter++;
		}
		System.out.println("There are "+counter+" cards in this deck");
	}
	
	//Choose a random card in the deck and swap it with the head of the deck. 100 times.
	public void shuffle(){
		Card temp = new Card();
		Card prev = new Card();
		int card;
		for (int i = 0; i < 100; i++) {
			temp = head;
			card = (int)(Math.random() * 52);
			for (int j = 0; j < card; j++) {
				prev = temp;
				temp = temp.next;
			}
			prev.next = head;
			prev = head.next;
			head.next = temp.next;
			temp.next = prev;
			head = temp;
		}
	}

	public Card draw(){
		Card temp = head;
		head = head.next;
		return temp;
	}

	private void insert(Card card) {
		Card temp = head;
		head = card;
		head.next = temp;
	}

	private Card head;
}
