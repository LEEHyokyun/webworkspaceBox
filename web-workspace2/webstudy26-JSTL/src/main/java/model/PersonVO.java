package model;

public class PersonVO {
	private String name;
	private int age;
	private CarVO carvo; // has a relationship

	public PersonVO() {
		super();
	}

	public PersonVO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public CarVO getCarvo() {
		return carvo;
	}

	public void setCarvo(CarVO carvo) {
		this.carvo = carvo;
	}

	public PersonVO(String name, int age, CarVO carvo) {
		super();
		this.name = name;
		this.age = age;
		this.carvo = carvo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", age=" + age + "]";
	}

}
