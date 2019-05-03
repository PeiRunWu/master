package packag_java;

import javax.swing.JOptionPane;

public class ProductBiz {

	public static void main(String[] args) {
		int[] counts=new int[3];
		double total=0;//最终要支付的金额
		Product[] products=new Product[3];
		for(int i=0;i<counts.length;i++) {
			if(products[i]==null)
				products[i]=new Product();
			Product product=new Product();
			String name =JOptionPane.showInputDialog("请输入商品名称: ");
			products[i].setName(name);
			String strPrice =JOptionPane.showInputDialog("请输入商品的单价: ");
			//需要将字符串类型转换成double类型，在进行复制
			products[i].setPrice(Double.parseDouble(strPrice));
			String strCounts=JOptionPane.showInputDialog("请输入购买的数量: ");
			counts[i]=Integer.parseInt(strCounts);
			
			//累加总金额
			total+=products[i].getPrice()*counts[i];
		}
		    System.out.println("购物结算：");
		    for(int i=0;i<counts.length;i++) {
		    	System.out.println(products[i].getName()+"\t"+products[i].getPrice());
		    }
            System.out.println("商品的总金额为： "+total);
	}

}
