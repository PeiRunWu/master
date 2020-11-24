import java.util.Scanner;

public class Counting_Days {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int n =input.nextInt();
		int  num[] =new int[n+1],s=1,m=0;
		for(int i=0;i<n;i++) {
			num[i]=input.nextInt(); //输入数据到数组当中
		}
		for(int i=0;i<n;i++) {
			if(num[i]<num[i+1]) {
				s++;
				if(s>m) {
					m=s;   //进行赋值，连续高温的天数进行保存下来
				}
			}else {
				s=1;
			}
		}
		System.out.println(m);
		
		

	}

}
