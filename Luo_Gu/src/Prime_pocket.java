import java.util.Scanner;

public class Prime_pocket {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int Prime=input.nextInt();
		boolean flag =false;
		int n=0,sum=0;
		for(int i =2;i<=Prime;i++) {
			for(int j=2;j<i;j++) {
				if(i % j ==0) {
					flag=true;
					break;
				}
				flag=false;
			}
			if(flag==false) {
				sum=sum+i;
				if(sum>Prime)break;
				System.out.println(i);
				n++;
			}

		}
		System.out.println(n);
	}

}
