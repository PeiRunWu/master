import java.util.Scanner;

public class ISBN_Number {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		int k = 1, sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '-') {
				sum += (s.charAt(i) - '0') * k;// s.charAt(i)-'0' 去取字符的uincode值
				k++;
			}
			if (k == 10) { // 如果k加到第
				break;
			}
		}

		int temp = sum % 11;
		
		if (temp == 10) {
			if (s.charAt(s.length() - 1) == 'X') {
				System.out.println("Right");
			} else {
				System.out.println((s.substring(0, s.length() - 1) + 'X'));
			}
		} else if (temp == s.charAt(s.length() - 1) - '0') {
			System.out.println("Right");
		} else {
			System.out.println((s.substring(0, s.length() - 1) + temp));
		}

	}

}
