import java.util.Scanner;

public class Savings_Plan {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int budget,remaining =0,MontherMoney=0,month=0,flag=1;
		for(int i=0;i<12;i++) {
			remaining +=300;//每个月都会获得300
			budget=input.nextInt();//输入每月的花销
			remaining -=budget;//每月的剩余的钱
			if(remaining <0) { //剩余的钱小于0
				month=i+1;
				flag =0;
				break;
			}
			MontherMoney = (remaining/100)*100+MontherMoney; //给妈妈存的钱数
			remaining =remaining % 100;//自己留下来的钱数
		}
		if(flag==1) {//如果剩余的钱最后大于0
			remaining=(int) (MontherMoney*0.2+remaining+MontherMoney);//自己获得最后的钱
			System.out.println(remaining);
		}else {
			System.out.print(-month);
		}
	}

}
