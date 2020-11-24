import java.util.Scanner;

public class Sequence_sum {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int n=input.nextInt(),sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		System.out.println(sum);
	}

}
