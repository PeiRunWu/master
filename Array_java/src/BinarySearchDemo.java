import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// ��������
		int[] array ={ 2, 5, 7, 8, 10, 12 };
		System.out.print("������Ҫɾ��������");
		int searchNumer = input.nextInt();
		int delectIndex = -1;// Ҫɾ�����±�
		int count = array.length;
		boolean isFind = false;// �ж��Ƿ���ҵ�
		int low = 0;// �½��±�
		int high = array.length - 1;// �Ͻ��±�
		while (high >= low) {
			int mid = (high + low) / 2;// �м��±�
			if (searchNumer > array[mid])// ������ҵ��������м��
				low = mid + 1;
			else if (searchNumer < array[mid])// ������ҵ���С���м��
				high = mid - 1;
			else {// ������
				isFind = true;
				delectIndex = mid;
				break;
			}
		}
		if (!isFind||delectIndex==-1) {
			System.out.println("û���ҵ�Ҫ�ҵ����±�");
			System.exit(0);
		}
		for (int i = delectIndex; i < array.length-1; i++) {
			array[i] = array[i + 1];
		}
		System.out.print("ɾ�������:" + "\n");
		count--;
		for (int i = 0; i < count; i++)
			System.out.print(array[i]);

		System.out.print("\n"+"****************"+"\n");
		
		Arrays.sort(array);//����
		System.out.print("������Ҫ�������:");
		int searcharray = input.nextInt();
		int insertIndex =array.length-1;// ���������±�
		for(int i=0;i<array.length;i++) {
			if(searcharray<array[i]) {//����������С�������i���������±�Ϊi
				insertIndex=i;
				break;
			}
		}
		for(int i=array.length-1;i>insertIndex;i--) {//��ǰ�������ֵ������
			array[i]=array[i-1];
		}
		array[insertIndex]=searcharray;//���������ֵ���±��ֵ
		System.out.print("���������:" + "\n");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]+" ");
	}
}
