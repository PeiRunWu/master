package packag_java;

/**
 * �ж��û������email�Ƿ�Ϊ�Ƿ��ַ���
 * 
 * @ֻ�ܰ���һ��
 * @.�����ڵ�һ�������һ�� email�������@��.
 * @author �����ҵ�����
 *
 */
public class StringEmail {
	public static boolean vaildateEmail(String email) {
		boolean vaildate = true;
		if (email == null)
			return false;
		String reg = "[A-Za-z0-9_]{1,}[@][0-9a-z]{2,3}[.][a-z]{2,3}";
		  if(email.matches(reg)){
			  vaildate=true;
         }else{

        	 vaildate=false;
         }
		return vaildate;
	}

}
