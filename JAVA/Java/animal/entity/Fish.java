package workshop.animal.entity;

public class Fish extends Animal implements Pet{
	private String fishName;
	
	public Fish() {
		super(0);
	}
	
	@Override
	public void setName(String name) {
		fishName = name;
	}

	@Override
	public String getName() {
		return fishName;
	}

	@Override
	public void play() {
		System.out.println("������ ���ħ��");
		
	}

	@Override
	public void eat() {
		System.out.println("������ ���̸� �Դ´�");
		
	}

	@Override
	public void walk() {
		System.out.println("������ �ٸ��� ����");
	}
	

}
