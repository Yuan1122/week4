import java.util.*;
import java.io.*;

class Cards{
	private ArrayList<Card> cards = new ArrayList<Card>();
	int totalCard;

	public Cards(int number){
		String[] suits = new String[] {"Club","Heart","Diamond","Spade"};//suit array
		this.totalCard = number *52;
		for(int i = 0; i < this.totalCard; i++){//Construction of cards
			String suit = suits[i / (13 * number)];//suit
			int value = 1 + i % 13;//cardNumber
			Card newCard = new Card(suit,value);
			cards.add(newCard);
		}
		Shuffle(this.totalCard);
	}

	private void Shuffle(int val){
		Random ran = new Random();
		for(int i = 0; i < cards.size(); i++){
			int x = ran.nextInt(val);//random 0 to val integer
			Collections.swap(cards, i, x);//change i and x
		}
	}

	public Card Licensing(){
		Card temp = cards.get(0);
		cards.remove(0);
		this.totalCard = this.totalCard - 1;
		return temp;
	}

	public void Show(){
		for(Card i: cards){//Print all Cards
			i.Show();
		}
	}
}