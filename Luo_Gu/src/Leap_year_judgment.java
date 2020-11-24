import java.util.Scanner;

public class Leap_year_judgment {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();
		if ((year > 1582) && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

	}

}
