import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.io.*;

class hw41{
	public static void main(String[] args){
		System.out.println("決戰21點\n");
		System.out.println("1)開始遊戲. 2)離開遊戲. : ");
		Scanner sca = new Scanner(System.in);			
		int cash=1000;
		int money=0,count=0;
		int opt1 = sca.nextInt();
		System.out.println("\t挑戰者持有金額 : "+cash+"\n");

		while(opt1 != 2){
			if(opt1 == 2)
				break;
			Cards C = new Cards(1);
			Players player = new Players("挑戰者");
			Players maker = new Players("莊家");
			while(cash>0){
			System.out.println("下注金額 : ");
			Scanner mon = new Scanner(System.in);
			money=mon.nextInt();
				if(money>cash){
					System.out.println("超過持有金額!\n\n");
					continue;
				}
				else if(money<=0){
					System.out.println("請輸入大於0的金額!\n\n");
					continue;
				}
				else
					break;
			}
			for(int i=0;i<2;i++){
				player.Hit(C.Licensing());
				maker.Hit(C.Licensing());
			}
			player.Show();
			player.ShowPoint();

			while(true){
				System.out.println("1)取牌. 2)放棄取牌. : ");
				int opt2 = sca.nextInt();

				if(opt2 ==2)
					break;

				player.Hit(C.Licensing());						
				player.Show();
				player.ShowPoint();

				//player point judge
				if(player.Point() == 21){
					System.out.println("Blackjack!");
					break;
				}
				if(player.Point() >21){
					System.out.println("Busted!");
					break;
				}
			}

			//maker Licensing to self
			System.out.println("====================");
			maker.Show();
			maker.ShowPoint();
			while(true){
				if(maker.Point() >= 17)
					break;
				else{
					maker.Hit(C.Licensing());
					maker.Show();
					maker.ShowPoint();
				}	
			}


			//compare player and maker points
			System.out.println("====================");
			System.out.println(player.nameRecall() + ":" + player.Point());
			System.out.println(maker.nameRecall() + ":" + maker.Point() + "\n");
			if(player.Point() > 21){
				System.out.println(player.nameRecall() + " 輸!");
				cash-=money;
				if(count>=3)
				{
					System.out.println("\n好手氣到此為止!\n");
				}
				count=0;
				}
			else if (maker.Point() >21){
				System.out.println(player.nameRecall() + " 贏!");
				cash+=money;
				if(count>=3)
				{
					System.out.println("\n手氣越來越旺了!\n");
				}
				count++;
			}
			else if(maker.Point() == player.Point()){
				System.out.println("平分秋色!");
			}
			else if(maker.Point() > player.Point()){
				System.out.println(player.nameRecall() + " 輸!");
				cash-=money;
				if(count>=3)
				{
					System.out.println("\n好手氣到此為止!\n");
				}
				count=0;
			}
			else{
				System.out.println(player.nameRecall() + " 贏!");
				cash+=money;
				if(count>=3)
				{
					System.out.println("\n手氣越來越旺了!\n");
				}
				count++;
			}
			System.out.println("\t挑戰者持有金額 : "+cash+"\n");
			if(cash>0)
			{			
			if(count>=2)
			{
				System.out.println("連勝"+count+"場\n\n");
				if(count==10)
				{
					System.out.println("新一屆賭神誕生了\n\n");
				}
			}
			System.out.println("決戰21點\n");
			System.out.println("1)繼續遊戲. 2)離開遊戲. : ");
			opt1 = sca.nextInt();
			}
			else if(cash<=0)
			{			
				System.out.println("\n\n請離開賭場!\n\n");			
				opt1 = 2;
			}
			player.removeAll();
			maker.removeAll();
		}
	}
}