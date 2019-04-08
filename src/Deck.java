public class Deck {

	public Deck() {
		shuffle();	
	}

	//prints out every card in the deck from top to bottom and prints how many cards are in the deck
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
	
	//Reinitialize the deck then shuffle by choosing a random card in the deck and swap it with the head of the deck 100 times.
	public void shuffle(){

		head = null;

		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		int[] values = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
		String[] faces = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

		for (int s = 0; s < 4; s++) {
			for (int f = 0; f < 13; f++) {
				insert(new Card(suits[s], values[f], faces[f]));
			}
		}

		int card;
		for (int i = 0; i < 100; i++) {
			Card temp = head;
			Card prev = new Card();
			card = (int)(Math.random() * 52);
			for (int j = 0; j < card; j++) {
				prev = temp;
				temp = temp.next;
			}
			prev.next = head;
			Card other = head.next;
			head.next = temp.next;
			temp.next = other;
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
