import java.util.Scanner;

public class Digital_right_triangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt(),count=0;
		for (int i = 1; i <=length; i++) {
			for(int j=i;j<=length;j++) {
				count++;
				if(count<10) {
					System.out.print(0);
				}
				System.out.print(count);
			}
			System.out.println();
		}
	}

}
