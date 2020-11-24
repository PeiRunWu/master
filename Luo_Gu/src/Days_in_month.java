import java.util.Scanner;

public class Days_in_month {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();
		int month = input.nextInt();
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			if (month == 2) {
				System.out.println(29);
			}
		} else {
			if (month == 2) {
				System.out.println(28);
			}
		}
		if (month != 2) {
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				System.out.println(31);
			} else {
				System.out.println(30);
			}
		}
	}

}
