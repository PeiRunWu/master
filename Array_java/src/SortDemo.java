import java.util.Arrays;

public class SortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ѡ������
		final int N=10;
        int[] array=new int[N];
        //��ӡ����ǰ����
        System.out.print("����ǰ:\n");
        for(int i=0;i<array.length;i++) {
        	array[i]=(int)(Math.random()*N);
        	System.out.print(" "+array[i]+" ");
        }
        System.out.print("\n");
        //����ѡ������
        for(int i=0;i<array.length;i++) {
        	int min=array[i];//������СֵΪ��I��ֵ
        	int minIndex=i;//��Сֵ���±�
        	for(int j=i+1;j<array.length;j++) {
        		if(min>array[j]) {//��Сֵ������һ����ʱ����һ����Ϊ��Сֵ
        			min=array[j];
        			minIndex=j;
        		}
        	}
        	int temp=array[i];
        	array[i]=array[minIndex];
        	array[minIndex]=temp;
        }
        System.out.print("�����:\n");
        for(int i=0;i<array.length;i++) {
        	System.out.print(" "+array[i]+" ");
        }
        System.out.print("\n");
        //sort����
        Arrays.sort(array);
        System.out.print("�����:\n");
        for(int i=0;i<array.length;i++) {
        	System.out.print(" "+array[i]+" ");
        }
	}

}
