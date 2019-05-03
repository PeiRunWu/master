package packag_java;
/**
 * �жϴ�����û������Ƿ�Ϊ�Ƿ��ַ��� 
 * �û������Ϊ25���ַ����ȣ������ո��
 * @author �����ҵ�����
 *
 */
public class StringName {
	public static boolean isCorrectUserName(String userName) {
		boolean isCorrectUser = true;
		if (userName == null)
			return false;
		if (userName.length() > 25)
			return false;
		// �Ƿ��ַ���
		char[] unValidChar = { ' ', '\'', '"', '?', '<', '>', ',' };
		for (char ch : unValidChar) {
			if (userName.contains(Character.toString(ch))) {
				isCorrectUser = false;
				break;
			}
		}
		return isCorrectUser;
	}
}
