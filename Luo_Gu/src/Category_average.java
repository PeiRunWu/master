import java.util.Scanner;

public class Category_average {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		double n =input.nextDouble();
		double k =input.nextDouble();
		double index=0,sum=0,event=0,Subscript=0;
		for(int i=1;i<=n;i++) {
			if(i % k==0) {
			    sum =i+sum;
				index++;
			}else {
				event= i+event;
				Subscript++;
			}
		}
		System.out.printf("%.1f",sum/index);
		System.out.println();
		System.out.printf("%.1f",event/Subscript);

	}

}
