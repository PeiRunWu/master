import java.util.Scanner;

public class Abacus_Test {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
	    int n =input.nextInt();//输入整数的个数
	    int num[]=new int[n+1],s=0;
	    int sum[]=new int[n+1];
	    for(int i=0;i<n;i++) {
	    	num[i]=input.nextInt();
	    	sum[i]=1; //用一个数组来判断是否重复
	    }
	    for(int i=0;i<n;i++) {
	    	for(int j=i+1;j<n;j++) {
	    		for(int k=0;k<n;k++) {
	    			if(num[i]+num[j]==num[k]&&sum[k]==1) {
	    				s++;
	    				sum[k]=0;
	    			}
	    		}
	    	}
	    }
	    System.out.println(s);

	}

}
