import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.io.*;

class hw41{
	public static void main(String[] args){
		System.out.println("�M��21�I\n");
		System.out.println("1)�}�l�C��. 2)���}�C��. : ");
		Scanner sca = new Scanner(System.in);			
		int cash=1000;
		int money=0,count=0;
		int opt1 = sca.nextInt();
		System.out.println("\t�D�Ԫ̫������B : "+cash+"\n");

		while(opt1 != 2){
			if(opt1 == 2)
				break;
			Cards C = new Cards(1);
			Players player = new Players("�D�Ԫ�");
			Players maker = new Players("���a");
			while(cash>0){
			System.out.println("�U�`���B : ");
			Scanner mon = new Scanner(System.in);
			money=mon.nextInt();
				if(money>cash){
					System.out.println("�W�L�������B!\n\n");
					continue;
				}
				else if(money<=0){
					System.out.println("�п�J�j��0�����B!\n\n");
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
				System.out.println("1)���P. 2)�����P. : ");
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
				System.out.println(player.nameRecall() + " ��!");
				cash-=money;
				if(count>=3)
				{
					System.out.println("\n�n���즹����!\n");
				}
				count=0;
				}
			else if (maker.Point() >21){
				System.out.println(player.nameRecall() + " Ĺ!");
				cash+=money;
				if(count>=3)
				{
					System.out.println("\n���V�ӶV���F!\n");
				}
				count++;
			}
			else if(maker.Point() == player.Point()){
				System.out.println("�������!");
			}
			else if(maker.Point() > player.Point()){
				System.out.println(player.nameRecall() + " ��!");
				cash-=money;
				if(count>=3)
				{
					System.out.println("\n�n���즹����!\n");
				}
				count=0;
			}
			else{
				System.out.println(player.nameRecall() + " Ĺ!");
				cash+=money;
				if(count>=3)
				{
					System.out.println("\n���V�ӶV���F!\n");
				}
				count++;
			}
			System.out.println("\t�D�Ԫ̫������B : "+cash+"\n");
			if(cash>0)
			{			
			if(count>=2)
			{
				System.out.println("�s��"+count+"��\n\n");
				if(count==10)
				{
					System.out.println("�s�@���䯫�ϥͤF\n\n");
				}
			}
			System.out.println("�M��21�I\n");
			System.out.println("1)�~��C��. 2)���}�C��. : ");
			opt1 = sca.nextInt();
			}
			else if(cash<=0)
			{			
				System.out.println("\n\n�����}���!\n\n");			
				opt1 = 2;
			}
			player.removeAll();
			maker.removeAll();
		}
	}
}