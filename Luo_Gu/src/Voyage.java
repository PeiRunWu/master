import java.util.Scanner;

public class Voyage {

	public static void main(String[] args) {
	   Scanner input =new Scanner(System.in);
	   int x =input.nextInt();//从周几算起
	   int n =input.nextInt();//经过几天
	   int s=0;
	   for(int i=0;i<n;i++) {
		   if(x!=6&&x!=7) {
			   s+=250;
		   }
		   if(x==8) {
			   x=1;
		   }
		   x++;
	   }
	   System.out.println(s);

	}

}
