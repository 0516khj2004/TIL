package workshop.book.control;

import java.util.ArrayList;
import java.util.List;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.RefetenceBook;

public class ManageBook {
	
	public static void main(String[] args) {
		ManageBook manager = new ManageBook();
		
		List<Publication> books = new ArrayList<>();
		books.add(new Magazine("����ũ�μ���Ʈ","2007-10-01",328,9900,"�ſ�")); 
		books.add(new Magazine("�濵����ǻ��","2007-10-03",316,9000,"�ſ�"));
		books.add(new Novel("���߿�","2007-07-01",396,9800,"����������������","����Ҽ�"));
		books.add(new Novel("���ѻ꼺","2007-04-14",383,11000,"����","���ϼҼ�"));
		books.add(new RefetenceBook("�ǿ��������α׷���","2007-01-14",496,25000,"����Ʈ�������")); 
		
		System.out.println("===Book ���� ���===");
		for (Publication publication : books) {
			System.out.println(publication);
		}
		System.out.println("===�������� ���� ��===");
		System.out.println(books.get(2) + " : " + books.get(2).getPrice());
		
		System.out.println("===�������� ���� ��===");
		manager.modifyPrice(books.get(2));
		System.out.println(books.get(2) + " : " + books.get(2).getPrice());
	
	}
//������ ��ť��Ʈ 
	public void modifyPrice(Publication books) {
		int price = books.getPrice();
		double rate = 0.0;
		if(books instanceof Magazine) {
			rate = 0.4;
		}else if(books instanceof Novel) {
			rate = 0.2;
		}else if(books instanceof RefetenceBook) {
			rate = 0.1;
		}
		
		books.setPrice(price - (int)(price * rate));
		
	}            

}
