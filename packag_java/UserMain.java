package packag_java;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�������û���: ");
		String userName = input.next();
		System.out.println("���������룺");
		String password = input.next();
		System.out.print(StringUtil.vaildatePassword(password));
		System.out.println("������email��");
		String email = input.next();
		if (StringEmail.vaildateEmail(email) == true && StringName.isCorrectUserName(userName) == true) {
           System.out.println("��ʽ��ȷ���ɹ�����!!");
		}else {
			  System.out.println("��ʽ����!");
		}
	}

}
