package dev.brunow.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import dev.brunow.course.entities.Category;
import dev.brunow.course.entities.Order;
import dev.brunow.course.entities.OrderItem;
import dev.brunow.course.entities.Payment;
import dev.brunow.course.entities.Product;
import dev.brunow.course.entities.User;
import dev.brunow.course.entities.enums.OrderStatus;
import dev.brunow.course.repositories.CategoryRepository;
import dev.brunow.course.repositories.OrderItemRepository;
import dev.brunow.course.repositories.OrderRepository;
import dev.brunow.course.repositories.ProductRepository;
import dev.brunow.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepositoy;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepositoy;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepositoy.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);	
		p5.getCategories().add(cat2);
		
		productRepositoy.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9888888888", "123456");
		User u2 = new User(null, "Alex green", "alex@gmail.com", "9777777777777", "1234567");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepositoy.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2, oi3,oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepositoy.save(o1);
	}

}
