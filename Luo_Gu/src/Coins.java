import java.util.Scanner;

public class Coins {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int day =input.nextInt(),coin=0,h=0;
		for(int i =1;;i++) {
			coin=i*i+coin;
			h=i+h;
			if(h>day) {
				coin-=(h-day)*i;
				h=day;
			}
			if(h==day) {
				break;
			}
		}
		System.out.println(coin);
	}

}
