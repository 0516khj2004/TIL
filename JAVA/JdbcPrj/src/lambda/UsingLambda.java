package lambda;

public class UsingLambda {
	public static void main(String[] args) {
		//Thread ���� ��� �ΰ���
		//1.
		Thread t1 = new Thread(new MyRunnable());
		t1.setName("����");
		t1.start();
		//2. Anonymous Inner Class �͸� Ŭ���� ���·� 
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t2.setName("�浿");
		t2.start();
		//3. Lambda �� ����
		Thread t3 = new Thread(() -> System.out.println(Thread.currentThread().getName())); // �� run() = ()  -> run() ������ 
 		t3.setName("�ڹ�");
		t3.start();
		
	}
}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

