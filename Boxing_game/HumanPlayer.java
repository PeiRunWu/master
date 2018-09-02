/**
 * ����
 */
public class HumanPlayer{
	/**��ȭʱ�����Ϣ**/
	public static final int MESSAGE_TYPE_FISt=1;
    /**Ӯʱ�����Ϣ**/
	public static final int MESSAGE_TYPE_WIN=2;
	/**��ʱ�����Ϣ**/
	public static final int MESSAGE_TYPE_LOSE=3;

	//���ԣ����ƣ�����,��ȭ,���Ի�̨��
	private String name;
	private int score;
	private int fist;
    /**��ɫ��ȭ��ʱ��˵�ĸ���̨��**/
	private String[] fistWords={"���йⲨ~biubiubiu~~","����ı���Ϊʲô��ô��~~","��ɱ¶pp~~","����һȭ","hahha,������"};
	//**Ӯʱ��˵�Ļ�**/
	private String[] winWords={"����˭~~","��ȭ�е���˼","ȫ������~~","�����ĸ�λ��������","hahahaha"};
	/**���ʱ��˵�Ļ�**/
	private String[] loseWords={"���","�Ҿ�Ȼ����","���˽����Ҷ���","ǧ���������","�������¸��ң�Ҳ��Ը�Ҹ�����"};

	public void sendMessage(int messType){
		//�������0-4֮��
		int Index=((int)(Math.random()*1000))%5;
		/**Ҫ��ӡ����Ϣ**/
		String message=null;
		switch(messType){
			case MESSAGE_TYPE_FISt:
			 message=fistWords[Index];
			break;
			case MESSAGE_TYPE_LOSE:
			message=loseWords[Index];
			break;
			case MESSAGE_TYPE_WIN:
			message=winWords[Index];
			break;
		}
		System.out.print(message+"\n");
	}
		public String getname(){
			return name;
		}
		public void setname(String name){
			this.name=name;
		}
		public int getscore(){
			return score;
		}
		public void setscore(int score){
			this.score=score;
		}
		public int getfist(){
			return fist;
		}
		public void setfist(int fist){
			this.fist=fist;
		}
	}
