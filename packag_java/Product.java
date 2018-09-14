package packag_java;

/**
 * ��Ʒʵ����
 * 
 * @author �����ҵ�����
 *
 */
public class Product {
	private double price;
	private String name;
	/** ��Ʒ������ **/
	private String description;
	/** ��Ʒ�ķ��� **/
	private String[] services;

	public Product() {
	}

	public Product(String name, String description, String[] services) {
		setName(name);
		setDescription(description);
		setServices(services);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price <= 0) {
			price = 1;
		} else {
			this.price = price;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getServices() {
		return services;
	}

	public void setServices(String[] services) {
		this.services = services;
	}

}
