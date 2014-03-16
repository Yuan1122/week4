import java.util.*;
import java.io.*;

class Players{
	private ArrayList<Card> hand;
	private String playername;
	private int handPoint;

	public Players(String name){
		hand = new ArrayList<Card>();
		this.playername = name;
	}

	public String nameRecall(){
		return this.playername;
	}

	public void Hit(Card temp){//叫牌
		hand.add(temp);
	}

	public void Show(){//印出手牌
		System.out.println("\n持有牌 : ");
		for(Card i : hand){
			i.Show();
		}
	}

	public void ShowPoint(){
		Point();
		System.out.println("點數 : " + handPoint + "\n");
	}

	public int Point(){//手牌點數
		int ace = 0, sum = 0,sumRecall;
		//compute ace count ,and others points
		for(Card j : hand){
			if(j.cardRecall() == 1){
				ace ++;
			}
			else if(j.cardRecall() > 10){
				sum += 10;
			}
			else{
				sum += j.cardRecall();
			}
		}
		//compute others point + ace count is over ,blackjack,within
		sumRecall = ComparePoint(sum, ace);
		if(sumRecall == -1){
			this.handPoint = sum + ace*11;
			return (sum + ace*11);
		}
		else{
			this.handPoint = sumRecall;
			return sumRecall;
		}
	}

	private int ComparePoint(int value,int aceCount){//點數比較
		if((value==10 && aceCount==1)|| value+aceCount == 21){//just
			return 21;
		}
		else if(value+aceCount > 21){//over
			return value+aceCount;
		}
		else{//within
			if(value+(aceCount*11) < 21 && aceCount!=0)
				return -1;
			else
				return value+aceCount;
		}
	}

	public void removeAll(){
		hand.clear();
	}
}