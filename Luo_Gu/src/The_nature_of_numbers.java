import java.util.Scanner;

public class The_nature_of_numbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		boolean a = false, b = false;
		if (0 <= num && num <= 1000) {
			if (num % 2 == 0) {
				a = true;
			}
			if (num > 4 && num <= 12) {
				b = true;
			}

			if (a == true && b == true) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			if (a == true || b == true) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			if (a == true && b == false || a == false && b == true) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			if (a == false && b == false) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

}
