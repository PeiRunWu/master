import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class FibonacciDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[10];
		int searchIndex=-1;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10000) % 1001;
			System.out.print(array[i]+" ");
		}
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max)
				max = array[i];
		}
		System.out.print("\n"+"请输入要查找的数:");
		int searchNum=new Scanner(System.in).nextInt();
		for(int i=0;i<array.length;i++) {
			if(searchNum==array[i])
				searchIndex=i;
		}  
		if(searchIndex==-1)
			System.out.println("没有找到你要找到的数字");
		else
			System.out.print("找到了数字，下标为："+searchIndex);
	}

}
