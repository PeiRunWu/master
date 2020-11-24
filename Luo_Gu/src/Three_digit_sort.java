import java.util.Scanner;

public class Three_digit_sort {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int[] num=new int[3];
		for(int i=0;i<num.length;i++) {
			num[i]=input.nextInt();
		}
        for(int i =0;i<num.length;i++) {
        	for(int j=0;j<num.length-i-1;j++) {
        		if(num[j+1]<num[j]) {
        			int temp =num[j+1];
        			num[j+1]=num[j];
        			num[j]=temp;
        		}
        	}
        }
		for(int i=0;i<num.length;i++) {
			System.out.print(num[i]+" ");
		}
	}

}
