/**
 * ��Ϸ����
 */
import java.util.Scanner;
public class GameRoom{
	//����:�Ƿ��ƣ����ߣ�������Ϸ��ң�����ţ��������֣���������
	private HumanPlayer humanPlayer=null;
	private ComputerPlay computerPlay=null;
	/**����Id**/
	private long roomId;
	/**��������**/
	private String roomName;
	/**��������**/
	private String roomPass;

	public GameRoom(String roomName,String roomPass){
	if(!("admin".equals(roomName)&&"123".equals(roomPass))){
		System.out.print("�������������Ϸǿ���˳�");
		return;
	}
	   this.setroomName(roomName);
       initGame();
       startGame();
       going();
       endGame();
	}
	public void initGame(){
		//��ʼ�����
		humanPlayer=new HumanPlayer();
		computerPlay=new ComputerPlay();
		//��ʼ����Ϸ��������
		for(int i=0;i<20;i++){
			System.out.print("*");
		}
		try{
			Thread.sleep(50);
		}catch(InterruptedException e){
			
		}
	}
	public void startGame(){
		showMenu();
		choiceRole();
	}
	public void endGame(){
		System.out.print(humanPlayer.getname()+" "+computerPlay.getname()+"\n");
		System.out.print(humanPlayer.getscore()+" "+computerPlay.getscore());
        System.out.println("\n��Ϸ��������ӭ����");
	}


	public void showMenu(){
		System.out.println("\n��ӭ���롶"+roomName+"�� ��Ϸ����");
		System.out.print("��ȭ����: 1-������2-ʯͷ��3-��");
	}
	public void choiceRole(){
		System.out.println("\n�Է���ɫ:1-��䣬2-���ݣ�3-���ϣ�4-����");
		System.out.print("��ѡ��");
		int choice=new Scanner(System.in).nextInt();
		String[] nameArray={"���","����","����","����"};
		computerPlay.setname(nameArray[choice-1]);
		humanPlayer.setname("Ұԭ��֮��");
		System.out.println(computerPlay.getname()+"VS"+humanPlayer.getname());
	}
	public int judge(int fist1,int fist2){
		if(fist2==fist1)
			return 0;
		if(fist1==1&&fist2==3||fist2==1&&fist1==2|fist1==3&&fist2==2){
			//�˵÷ּ�1.���Ե÷ּ�1
             humanPlayer.setscore(humanPlayer.getscore()+1);
             computerPlay.setscore(computerPlay.getscore()-1);
             return -1;
		}else{
			humanPlayer.setscore(humanPlayer.getscore()-1);
             computerPlay.setscore(computerPlay.getscore()+1);
             return 1;
		}
	}
    public void going(){
    	while(true){
    	 //˫����ȭ
        System.out.print(humanPlayer.getname()+"���ȭ");
        Scanner input=new Scanner(System.in);
        humanPlayer.setfist(input.nextInt());
        int fist1=humanPlayer.getfist();
        computerPlay.getfist();
        int fist2=computerPlay.getfist();
        //�ж�
        int result=judge(fist1,fist2);
        if(result==-1){
        	System.out.println("[��ˮ��ʦ]:"+humanPlayer.getname()+"ʤ��");
        	humanPlayer.sendMessage(HumanPlayer.MESSAGE_TYPE_WIN);
            computerPlay.sendMessage(ComputerPlay.MESSAGE_TYPE_LOSE);
        }else if(result==0){
        	System.out.println("[��ˮ��ʦ]: ��Ϸƽ��");
        	humanPlayer.sendMessage(HumanPlayer.MESSAGE_TYPE_FISt);
            computerPlay.sendMessage(ComputerPlay.MESSAGE_TYPE_FIST);
        }else{
        	System.out.println("[��ˮ��ʦ]:"+computerPlay.getname()+"ʤ��");
        	computerPlay.sendMessage(ComputerPlay.MESSAGE_TYPE_WIN);
        	humanPlayer.sendMessage(HumanPlayer.MESSAGE_TYPE_LOSE);
        }
        System.out.print("�Ƿ������Ϸ(y/n)");
        String answer=new Scanner(System.in).next();
        if(!"y".equalsIgnoreCase(answer)){
        	break;
        }
      }
    }

	public long getroomId(){
		return roomId;
	}
	public void setroomId(long roomId){
		this.roomId=roomId;
	}
	public String getroomName(){
		return roomName;
	}
	public void setroomName(String roomName){
		this.roomName=roomName;
	}
	public String getroomPass(){
		return roomPass;
	}
	public void setroomPass(String roomPass){
		this.roomPass=roomPass;
	}
}