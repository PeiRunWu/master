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
		System.out.print("\n"+"������Ҫ���ҵ���:");
		int searchNum=new Scanner(System.in).nextInt();
		for(int i=0;i<array.length;i++) {
			if(searchNum==array[i])
				searchIndex=i;
		}  
		if(searchIndex==-1)
			System.out.println("û���ҵ���Ҫ�ҵ�������");
		else
			System.out.print("�ҵ������֣��±�Ϊ��"+searchIndex);
	}

}
