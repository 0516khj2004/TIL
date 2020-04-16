package workshop.person.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import workshop.person.entity.PersonEntity;

public class PersonManagerCollection {

	public static void main(String[] args) {

		PersonManagerCollection manager = new PersonManagerCollection();
		List<PersonEntity> persons = new ArrayList<>();
		
		manager.fillPersons(persons);
		
		manager.showPersons(persons);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ���");
		
		char gender = scanner.next().charAt(0);
		
		System.out.println("�Էµ� ������ ���� " + gender);
		
		System.out.println("������(��) " + manager.findByGender(persons, gender)+ "�� ���Դϴ�.");
		
		
		System.out.println("�̸��� �Է��ϼ���");
		String name = scanner.next();
		System.out.println("�̸�" + name + "���� ã�� ��� �Դϴ�.");
		manager.showPersons(persons, name);
		scanner.close();
	}

	public void showPersons(List<PersonEntity> persons, String name) {
		for (PersonEntity person : persons) {
			if(name.equals(person.getName())) {
				System.out.println("[�̸� ] " + person.getName());
				System.out.println("[����] " + person.getGender());
				System.out.println("[��ȭ��ȣ ]" + person.getPhone());
				break;
			}
		}
	}

	public int findByGender(List<PersonEntity> persons, char gender) {
		int cnt =0 ;
		for (PersonEntity person : persons) {
			if(person.getGender() == gender) {
				cnt++;
			}
 		}
		return cnt;
	}

	public void showPersons(List<PersonEntity> persons) {
		for (PersonEntity person : persons) {
			System.out.println("[�̸�]" + person.getName() +
					"\t [����]" + person.getGender() + "\t [��ȭ��ȣ]" + person.getPhone());
		}
	}

	private void fillPersons(List<PersonEntity> persons) {
		persons.add(new PersonEntity("�̼�ȣ","7212121028102", "��õ ��籸", "032-392-2932")) ;
		persons.add(new PersonEntity("���ϴ�","7302132363217", "���� ������", "02-362-1932"))  ;
		persons.add(new PersonEntity("�ڿ���","7503111233201", "���� ���ϱ�", "02-887-1542"))  ;
		persons.add(new PersonEntity("���μ�","7312041038988", "���� ������", "032-384-2223")) ;
		persons.add(new PersonEntity("ȫ����","7606221021341", "���� ��õ��", "02-158-7333"))  ;
		persons.add(new PersonEntity("�̹̼�","7502142021321", "���� ������", "02-323-1934"))  ;
		persons.add(new PersonEntity("�ڼ���","7402061023101", "���� ���α�", "02-308-0932"))  ;
		persons.add(new PersonEntity("������","7103282025101", "���� ����", "02-452-0939"))  ;
		persons.add(new PersonEntity("Ȳ����","7806231031101", "��õ �߱�", "032-327-2202"))   ;
		persons.add(new PersonEntity("��ö��","7601211025101", "��õ ��籸", "032-122-7832")) ;
	}

}