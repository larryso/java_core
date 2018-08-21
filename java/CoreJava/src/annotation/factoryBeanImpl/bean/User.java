package annotation.factoryBeanImpl.bean;

import annotation.factoryBeanImpl.Entity;
import annotation.factoryBeanImpl.EntityProperty;

@Entity(name = "user", isLazyLoad = false)
public class User {
	@EntityProperty(value = "1000")
	private String id;
	@EntityProperty(value = "Male")
	private String sex;
	@EntityProperty(value = "Larry")
	private String name;
	@EntityProperty(value = "2000")
	private String wage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}

}
