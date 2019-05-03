import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SortingFocusTraversalPolicy;

public class Harem_selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// 定义要添加的后妃
		String[] newNameArray = { "褒姒", "陈圆圆", "苏小小", "甄嬛", "钟无艳" };
		// 定义要添加后妃的数组长度
		int newNameCount = newNameArray.length;
		// 定义后妃的名字
		String[] nnNameArray = { "西施", "貂蝉", "王昭君", "杨玉环", "赵飞燕", "", "", "", "", "" };
		// 定义后妃的级别
		String[] levelName = { "贵人", "嫔妃", "贵妃", "皇贵妃", "皇后" };
		// 对应后妃的级别
		int[] level = new int[10];
		// 对应每个后妃的好感度
		int[] loves = new int[10];
		// 对应后妃的初始数
		int nnCount = 5;
		// 游戏初始时间
		int gametime = 1;
		// 默认好感度
		for (int i = 0; i < nnCount; i++) {
			loves[i] = 100;
		}
		JOptionPane.showMessageDialog(null, "陛下，你来了", "欢迎来到选妃游戏", 1, new ImageIcon("images/title.jpg"));
		while (gametime <= 10) {
			String strMenu = "1.皇帝下旨选妃\n";
			strMenu += "2.翻牌宠幸\n";
			strMenu += "3.打入冷宫\n";
			strMenu += "4.朕的爱妃呢\n";
			strMenu += "请陛下选择:\n";
			Object objResult = JOptionPane.showInputDialog(null, strMenu, "游戏进行到第" + gametime + "天", 0,
					new ImageIcon("images/宝座.jpg"), new String[] { "1", "2", "3", "4" }, 1);
			switch (objResult.toString()) {
			case "1":// 1.皇帝下旨选妃
				objResult = JOptionPane.showInputDialog(null, "请选择秀女", "选妃", 0, new ImageIcon("images/timg.jpg"),
						newNameArray, null);
				if (objResult == null) {
					continue;
				}
				JOptionPane.showMessageDialog(null, objResult.toString(), "选中的嫔妃", 0,
						new ImageIcon("images/" + objResult.toString() + ".jpg"));
				nnNameArray[nnCount] = objResult.toString();
				loves[nnCount] = 100;// 选出的人好感度为100
				for (int i = 0; i < nnCount; i++) {
					loves[i] -= 10;
				}
				nnCount++;// 选妃人数加1
				break;
			case "2":// 2.翻牌宠幸
				objResult = JOptionPane.showInputDialog(null, "请陛下选择", "翻牌", 0, new ImageIcon("images/选妃翻牌.jpg"),
						nnNameArray, null);
				if (objResult == null) {
					continue;
				}
				int searchIndex = Integer.MAX_VALUE;
				String Name = objResult.toString();
				// 查询宠幸妃子的下标
				for (int i = 0; i < nnCount; i++) {
					if (Name.compareTo(nnNameArray[i]) == 0) {// 输入的名字等于数组里面的名字
						searchIndex = i;
						break;
					}
				}
				if (searchIndex == Integer.MAX_VALUE) {
					System.out.print("没有找到该娘娘");
					break;
				}
				// 宠幸妃子，妃子的级别加1，如果后妃的级别等于级别数组的长度，好感度加10
				if (level[searchIndex] + 1 == levelName.length) {      
					loves[searchIndex] += 10;
				} else {
					level[searchIndex] += 1;
					loves[searchIndex] += 10;// 好感度加20
				}
				// 没有宠幸到的妃子，好感度-10
				for (int i = 0; i < nnCount; i++) {
					if (i == searchIndex)
						continue;
					loves[i] -= 10;
				}
				JOptionPane.showMessageDialog(null,
						"宠幸" + nnNameArray[searchIndex] + ",好感度+10,升级为" + levelName[level[searchIndex]], "翻牌的结果", 0,
						new ImageIcon("images/" + nnNameArray[searchIndex] + ".jpg"));
				break;
			case "3":// 3.打入冷宫
				objResult = JOptionPane.showInputDialog(null, "请陛下选择", "打入冷宫", 0, new ImageIcon("images/打入冷宫.jpg"),
						nnNameArray, null);
				if (objResult == null) {
					continue;
				}
				String name = objResult.toString();
				int deletchIndex = Integer.MAX_VALUE;
				// 查询打入冷宫妃子的下标
				for (int i = 0; i < nnCount; i++) {
					if (name.compareTo(nnNameArray[i]) == 0) {
						deletchIndex = i;
						break;
					}
				}
				if (deletchIndex == Integer.MAX_VALUE) {
					System.out.print("没有找到后妃");
					break;
				}
				// 将打入冷宫的妃子删除
				for (int i = deletchIndex; i < nnCount; i++) {
					nnNameArray[i] = nnNameArray[i + 1];
				}
				nnCount--;
				// 打入冷宫后，妃子好感度+10
				for (int i = 0; i < nnCount; i++) {
					loves[i] += 10;
				}
				// 打入冷宫妃子的图片
				JOptionPane.showMessageDialog(null, objResult.toString()+"被打入冷宫", "选中的妃子", 0,
						new ImageIcon("images/" + objResult.toString() + ".jpg"));
				break;
			case "4":// 4.朕的爱妃呢
				objResult = JOptionPane.showInputDialog(null, "请陛下选择", "查找后妃", 0, new ImageIcon("images/朕的爱妃呢.jpg"),
						nnNameArray, null);
				String names = objResult.toString();
				for (int i = 0; i < nnCount; i++) {
					if (names.compareTo(nnNameArray[i]) == 0) {
						JOptionPane.showMessageDialog(null, "臣妾在呢", null, 0,
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
				JOptionPane.showMessageDialog(null, "后宫有三位以上妃子好感度低于60，发生暴乱!", "突发事件，发生暴乱", 0,
						new ImageIcon("images/皇上被害.jpg"));
				break;
			}
			String value = "没羞没臊的生活又过了一天，后宫的情况如下:\n";
			for (int i = 0; i < nnCount; i++) {
				value += String.format("%s %s %d\n", nnNameArray[i], levelName[level[i]], loves[i]);
			}
			// 每日结算
			JOptionPane.showMessageDialog(null, value, "每日结算", 0, new ImageIcon("images/嬉戏.jpg"));
			gametime++;
		}
	}

}
