import java.util.Scanner;

public class Stationery {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		double pencil =1.9;
		double a =input.nextDouble();
		double b =input.nextDouble();
		if(b>10) {
			return;
		}
		double sum =a *10+b;
		int num =(int)(sum/(pencil*10));
        System.out.println(num);
	}

}
