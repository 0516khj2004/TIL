package myspring.di.xml.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {
	BeanFactory factory;
	
	@Before
	public void init() {
		// 1. spring bean container ����
		//resourceLocations = spring Bean Config xml ������ ���� 
		factory = new GenericXmlApplicationContext("config/spring_beans.xml");		
	}
	
	@Test
	public void hello() {
		//2. Container���� hello bean�� ��û 
		Hello hello = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
		//2.1 assertSame(a, b); �޼��带 ����ؼ� �ּ� ��
		assertSame(hello, hello2); // �ּҰ� ������ test�� ����Ѵ�.
		//2.2 Assert.assertEquals() �޼��带 ����ؼ� ���� ��
		assertEquals("Hello ������", hello.sayHello());
		
		hello.print();
		//3. Container���� StringPrinter bean�� ��û 
		Printer sPrinter = factory.getBean("sPrinter",Printer.class);
		assertEquals("Hello ������", sPrinter.toString());
		
	}
}
