package workshop.animal.entity;

public class Cat extends Animal implements Pet {
	private String catName;
	
	public Cat(String name) {
		super(4); //�ٸ� ������ ���ϴ� ����
		catName = name;
	}

	public Cat() {
		this("");
	}
	
	@Override
	public void setName(String name) {
		catName = name;
	}
	@Override
	public String getName() {
		return catName;
	}
	@Override
	public void play() {
		System.out.println("���ƴ� ���");
		
	}
	@Override
	public void eat() {
		System.out.println("����̴� �Դ´�");
		
	}
}
