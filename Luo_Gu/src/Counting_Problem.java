import java.util.Scanner;

public class Counting_Problem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();// 输入区间
		int x = input.nextInt();// 查询的数
		int s = 0, c, b;
		for (int i = 1; i <= n; i++)// 一到n进行循环；
		{
			b = i;
			while (b != 0)// 如果b不等于0，继续循环；
			{
				c = b % 10; //得到的数字是否等于X
				b = b / 10; 
				if (c == x)
					s++;
			}
		}

		System.out.println(s);
	}

}
