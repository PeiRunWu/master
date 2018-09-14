package packag_java;

/**
 * 商品实体类
 * 
 * @author 你是我的信仰
 *
 */
public class Product {
	private double price;
	private String name;
	/** 商品的描述 **/
	private String description;
	/** 商品的服务 **/
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
