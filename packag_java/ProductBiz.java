package packag_java;

import javax.swing.JOptionPane;

public class ProductBiz {

	public static void main(String[] args) {
		int[] counts=new int[3];
		double total=0;//����Ҫ֧���Ľ��
		Product[] products=new Product[3];
		for(int i=0;i<counts.length;i++) {
			if(products[i]==null)
				products[i]=new Product();
			Product product=new Product();
			String name =JOptionPane.showInputDialog("��������Ʒ����: ");
			products[i].setName(name);
			String strPrice =JOptionPane.showInputDialog("��������Ʒ�ĵ���: ");
			//��Ҫ���ַ�������ת����double���ͣ��ڽ��и���
			products[i].setPrice(Double.parseDouble(strPrice));
			String strCounts=JOptionPane.showInputDialog("�����빺�������: ");
			counts[i]=Integer.parseInt(strCounts);
			
			//�ۼ��ܽ��
			total+=products[i].getPrice()*counts[i];
		}
		    System.out.println("������㣺");
		    for(int i=0;i<counts.length;i++) {
		    	System.out.println(products[i].getName()+"\t"+products[i].getPrice());
		    }
            System.out.println("��Ʒ���ܽ��Ϊ�� "+total);
	}

}
