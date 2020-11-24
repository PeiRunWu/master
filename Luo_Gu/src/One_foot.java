import java.util.Scanner;

public class One_foot {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int index=1;
		int n =input.nextInt();
		while (n > 1) {
			n =n/2;
			index++;
		}
		System.out.println(index);

	}

}
