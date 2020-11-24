import java.util.Scanner;

public class More_Cute {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();// 输入鱼的数目
		int num[] = new int[n+1];
		int b[]= new int[n+1],k;	
		for(int i=0;i<n;i++) {
			num[i]=input.nextInt();
			for(int j=0;j<i;j++) {
		      if(num[i]>num[j]) {
		    	b[i]++;
		      }
			}
		}
		for(int i=0;i<b.length-1;i++) {
			System.out.print(b[i]+" ");
		}

	}

}
