import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);

		Deck deck = new Deck();
		Hand playerHand = new Hand();
		Hand dealerHand = new Hand();

		playerHand.insert(deck.draw());
		dealerHand.insert(deck.draw());
		playerHand.insert(deck.draw());
		dealerHand.insert(deck.draw());

		String input = "none";
		boolean playerBust = false;
		boolean dealerBust = false;
		do {
			System.out.println("You have "+playerHand.toString()+"totaling "+playerHand.getTotal());
			if (playerHand.getTotal() > 21) {
				playerHand.hasAce();
				if (playerHand.getTotal() > 21) {
					playerBust = true;
				}
			}
			else if (playerHand.getTotal() == 21) {
				input = "stay";
			}
			else if (playerBust == false) {
				do {
				System.out.print("Would you like to (hit) or (stay): ");
				input = console.nextLine();
				} while (!input.equals("hit") && !input.equals("stay"));	

				if (input.equals("hit")) {
					playerHand.insert(deck.draw());
				}
			}


		} while (!input.equals("stay") && !playerBust);

		boolean win = true;

		if (playerBust == true) {
			win = false;
		}
		else if (playerHand.getTotal() == 21) {

		}
		else {
			while (dealerHand.getTotal() < 17) {
				dealerHand.insert(deck.draw());
				if (dealerHand.getTotal() > 21) {
					dealerHand.hasAce();
				}
			}
			System.out.println("The dealer has "+dealerHand.toString()+"totaling "+dealerHand.getTotal());
			if (dealerHand.getTotal() > 21) {
				dealerBust = true;
			}
			else if (dealerHand.getTotal() > playerHand.getTotal()) {
				win = false;
			}
		}
		if (win) {
			System.out.println("You win!");
		}
		else {
			System.out.println("The dealer wins!");
		}
	}
}
