import java.util.*;
import java.io.*;

class Card{
	private String suitName;
	private int cardNumber;
	public Card(String suitNumber,int value){
		this.suitName = suitNumber;
		this.cardNumber = value;
	}
	public String suitRecall(){
		return this.suitName;
	}
	public int cardRecall(){
		return this.cardNumber;
	}
	public void Show(){
		System.out.println(suitRecall() + " " + cardRecall());
	}
}