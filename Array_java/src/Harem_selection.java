import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SortingFocusTraversalPolicy;

public class Harem_selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// ����Ҫ��ӵĺ���
		String[] newNameArray = { "���", "��ԲԲ", "��СС", "���", "������" };
		// ����Ҫ��Ӻ��������鳤��
		int newNameCount = newNameArray.length;
		// �������������
		String[] nnNameArray = { "��ʩ", "����", "���Ѿ�", "����", "�Է���", "", "", "", "", "" };
		// ��������ļ���
		String[] levelName = { "����", "����", "����", "�ʹ���", "�ʺ�" };
		// ��Ӧ�����ļ���
		int[] level = new int[10];
		// ��Ӧÿ�������ĺøж�
		int[] loves = new int[10];
		// ��Ӧ�����ĳ�ʼ��
		int nnCount = 5;
		// ��Ϸ��ʼʱ��
		int gametime = 1;
		// Ĭ�Ϻøж�
		for (int i = 0; i < nnCount; i++) {
			loves[i] = 100;
		}
		JOptionPane.showMessageDialog(null, "���£�������", "��ӭ����ѡ����Ϸ", 1, new ImageIcon("images/title.jpg"));
		while (gametime <= 10) {
			String strMenu = "1.�ʵ���ּѡ��\n";
			strMenu += "2.���Ƴ���\n";
			strMenu += "3.�����乬\n";
			strMenu += "4.�޵İ�����\n";
			strMenu += "�����ѡ��:\n";
			Object objResult = JOptionPane.showInputDialog(null, strMenu, "��Ϸ���е���" + gametime + "��", 0,
					new ImageIcon("images/����.jpg"), new String[] { "1", "2", "3", "4" }, 1);
			switch (objResult.toString()) {
			case "1":// 1.�ʵ���ּѡ��
				objResult = JOptionPane.showInputDialog(null, "��ѡ����Ů", "ѡ��", 0, new ImageIcon("images/timg.jpg"),
						newNameArray, null);
				if (objResult == null) {
					continue;
				}
				JOptionPane.showMessageDialog(null, objResult.toString(), "ѡ�е�����", 0,
						new ImageIcon("images/" + objResult.toString() + ".jpg"));
				nnNameArray[nnCount] = objResult.toString();
				loves[nnCount] = 100;// ѡ�����˺øж�Ϊ100
				for (int i = 0; i < nnCount; i++) {
					loves[i] -= 10;
				}
				nnCount++;// ѡ��������1
				break;
			case "2":// 2.���Ƴ���
				objResult = JOptionPane.showInputDialog(null, "�����ѡ��", "����", 0, new ImageIcon("images/ѡ������.jpg"),
						nnNameArray, null);
				if (objResult == null) {
					continue;
				}
				int searchIndex = Integer.MAX_VALUE;
				String Name = objResult.toString();
				// ��ѯ�������ӵ��±�
				for (int i = 0; i < nnCount; i++) {
					if (Name.compareTo(nnNameArray[i]) == 0) {// ��������ֵ����������������
						searchIndex = i;
						break;
					}
				}
				if (searchIndex == Integer.MAX_VALUE) {
					System.out.print("û���ҵ�������");
					break;
				}
				// �������ӣ����ӵļ����1����������ļ�����ڼ�������ĳ��ȣ��øжȼ�10
				if (level[searchIndex] + 1 == levelName.length) {      
					loves[searchIndex] += 10;
				} else {
					level[searchIndex] += 1;
					loves[searchIndex] += 10;// �øжȼ�20
				}
				// û�г��ҵ������ӣ��øж�-10
				for (int i = 0; i < nnCount; i++) {
					if (i == searchIndex)
						continue;
					loves[i] -= 10;
				}
				JOptionPane.showMessageDialog(null,
						"����" + nnNameArray[searchIndex] + ",�øж�+10,����Ϊ" + levelName[level[searchIndex]], "���ƵĽ��", 0,
						new ImageIcon("images/" + nnNameArray[searchIndex] + ".jpg"));
				break;
			case "3":// 3.�����乬
				objResult = JOptionPane.showInputDialog(null, "�����ѡ��", "�����乬", 0, new ImageIcon("images/�����乬.jpg"),
						nnNameArray, null);
				if (objResult == null) {
					continue;
				}
				String name = objResult.toString();
				int deletchIndex = Integer.MAX_VALUE;
				// ��ѯ�����乬���ӵ��±�
				for (int i = 0; i < nnCount; i++) {
					if (name.compareTo(nnNameArray[i]) == 0) {
						deletchIndex = i;
						break;
					}
				}
				if (deletchIndex == Integer.MAX_VALUE) {
					System.out.print("û���ҵ�����");
					break;
				}
				// �������乬������ɾ��
				for (int i = deletchIndex; i < nnCount; i++) {
					nnNameArray[i] = nnNameArray[i + 1];
				}
				nnCount--;
				// �����乬�����Ӻøж�+10
				for (int i = 0; i < nnCount; i++) {
					loves[i] += 10;
				}
				// �����乬���ӵ�ͼƬ
				JOptionPane.showMessageDialog(null, objResult.toString()+"�������乬", "ѡ�е�����", 0,
						new ImageIcon("images/" + objResult.toString() + ".jpg"));
				break;
			case "4":// 4.�޵İ�����
				objResult = JOptionPane.showInputDialog(null, "�����ѡ��", "���Һ���", 0, new ImageIcon("images/�޵İ�����.jpg"),
						nnNameArray, null);
				String names = objResult.toString();
				for (int i = 0; i < nnCount; i++) {
					if (names.compareTo(nnNameArray[i]) == 0) {
						JOptionPane.showMessageDialog(null, "�������", null, 0,
								new ImageIcon("images/" + objResult.toString() + ".jpg"));
						break;
					}	
				}
				break;
			default:
				break;
			}
			int count = 0;
			for (int i = 0; i < nnCount; i++) {
				if (loves[i] < 60)
					count++;
			}
			if (count >= 3) {
				JOptionPane.showMessageDialog(null, "������λ�������Ӻøжȵ���60����������!", "ͻ���¼�����������", 0,
						new ImageIcon("images/���ϱ���.jpg"));
				break;
			}
			String value = "û��û���������ֹ���һ�죬�󹬵��������:\n";
			for (int i = 0; i < nnCount; i++) {
				value += String.format("%s %s %d\n", nnNameArray[i], levelName[level[i]], loves[i]);
			}
			// ÿ�ս���
			JOptionPane.showMessageDialog(null, value, "ÿ�ս���", 0, new ImageIcon("images/��Ϸ.jpg"));
			gametime++;
		}
	}

}
