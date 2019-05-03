package packag_java;

/**
 * ����6-18 λ��ֻ�ܰ������֣���ĸ���������
 * �����֣�����ĸ������ǿ��Ϊ��
 * ������+����ĸ������ĸ+�����ţ�������+�����ţ�����ǿ��Ϊ��
 * ������+������+����ĸ ����ǿ��Ϊ��
 * @param password
 * @return
 */
public class StringUtil {
	public static String vaildatePassword(String password) {
		String power ="";//�����ǿ��
		if(password==null)return power;
		if(password.length()<6||password.length()>18)return power;
		//�ж��ַ����Ϸ�
		String part ="_@#$!";
		for(int i=0;i<password.length();i++) {
			//�ж��Ƿ�Ϊ���ֻ���ĸ
			if(!Character.isLetterOrDigit(password.charAt(i))){
				//���������ĸ�����֣�����Ҳ���ǺϷ���������ţ���֤���ǷǷ��ĸ�ʽ
				if(!part.contains(Character.toString(password.charAt(i)))){
					return power;
				}
			}
		}
		if(isDigit(password)||isLetter(password)) {
			power="�������";
		}else if(isContainsSymble(password)) {
			power="�������";
		}else if(isDigAndLetter(password)) {
			power="�������";
		}
		return power;
	}
	/**
	 * �Ƿ�������ֺ���ĸ
	 * @param value
	 * @return
	 */
	private static boolean isDigAndLetter(String value) {
		for(int i=0;i<value.length();i++) {
			if(!Character.isLetterOrDigit(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * �ж�һ���ַ����ǲ��Ǵ�����
	 * @param value
	 * @return
	 */
	private static boolean isDigit(String value) {
		for(int i=0;i<value.length();i++) {
			if(!Character.isDigit(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * �ж�һ���ַ����ǲ��Ǵ���ĸ
	 */
	private static boolean isLetter(String value) {
		for(int i=0;i<value.length();i++) {
			if(!Character.isLetter(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * �ж�һ���ַ����Ƿ�Ϊ���ַ�
	 */
	private static boolean isContainsSymble(String value) {
		String part ="_@#$!";
		for(int i=0;i<value.length();i++) {
			if(part.contains(Character.toString(value.charAt(i)))) {
				return true;
			}
		}
		return false;
	}
}
