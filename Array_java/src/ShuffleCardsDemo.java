
public class ShuffleCardsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// /13��ȡ�û�ɫ ��%13��ȡ�û�ɫ
		final int N = 52;//��������
		int[] card = new int[N];
		//�ƵĻ�ɫ��
		String[] cardColors= {"����","����","����","÷��"};
		String[] cardValus= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(int i=0;i<card.length;i++) {
			card[i]=i;
		}
		System.out.print("ϴ��ǰ:"+"\n");
		for(int i=0;i<card.length;i++) {
			System.out.print(" "+cardColors[card[i]/13]+cardValus[card[i]%13]+" ");//��ӡ��ɫ+����
			if((i+1)%13==0)
				System.out.print("\n");
			else
				System.out.print("\t");
		}
		//ϴ�ƣ��������0-51֮�������
		for(int i=0;i<card.length;i++) {
			int newIndex=(int)(Math.random()*N);//���52����
			//���ƽ��д���
			int temp=card[i];
			card[i]=card[newIndex];
			card[newIndex]=temp;
		}
		System.out.print("ϴ�ƺ�:"+"\n");
		for(int i=0;i<card.length;i++) {
			System.out.print(" "+cardColors[card[i]/13]+cardValus[card[i]%13]+" ");
			if((i+1)%13==0)
				System.out.print("\n");
			else
				System.out.print("\t");
		}
		
	}

}
