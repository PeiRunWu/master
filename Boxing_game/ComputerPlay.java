/**
 * ����
 */
public class ComputerPlay{
		/**��ȭʱ�����Ϣ**/
	public static final int MESSAGE_TYPE_FIST=1;
    /**Ӯʱ�����Ϣ**/
	public static final int MESSAGE_TYPE_WIN=2;
	/**��ʱ�����Ϣ**/
	public static final int MESSAGE_TYPE_LOSE=3;

	//���ԣ����ƣ�����,��ȭ,���Ի�̨��
	private String name;
	private int score;
	private int fist;
    /**��ɫ��ȭ��ʱ��˵�ĸ���̨��**/
	private String[] fistWords={"����һ��ȭ","����������Ѳɽ","���������Ŀ�������׬Ǯ","����һȭ","��������"};
	//**Ӯʱ��˵�Ļ�**/
	private String[] winWords={"������ʲô~~","�ҳ飬��һ������̬��","�飬��һ����������","����ֻ��һ������Ӯ��","hahahaha"};
	/**���ʱ��˵�Ļ�**/
	private String[] loseWords={"ͨ���ɹ���·������ʩ��","�ȵ���ˮ��ȥ����֪��˭����Ӿ��","û���뵽���Ҿ�Ȼ����","�����ң���ס��","������ʲô"};

	public void sendMessage(int messType){
		//�������0-4֮��
		int Index=((int)(Math.random()*1000))%5;
		/**Ҫ��ӡ����Ϣ**/
		String message=null;
		switch(messType){
			case MESSAGE_TYPE_FIST:
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
			//�������1-3���������
			fist=((int)(Math.random()*30000))%3+1;
			return fist;
		}
	}