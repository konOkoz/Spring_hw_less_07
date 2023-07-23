import de.ait.config.ApplicationConfig;
import de.ait.services.ProductsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductsService productsService = context.getBean(ProductsService.class);

        Scanner scanner = new Scanner(System.in);




        while (true) {
            System.out.println("If you want to register new product press '1'");
            System.out.println("If you want to check a product list press '2'");
            System.out.println("If you want to exit press '0'");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> {
                    String name = scanner.nextLine();
                    Integer count = scanner.nextInt();

                    productsService.saveProduct(name, count);
                }
                case 2 -> System.out.println(productsService.getAllProducts());

                case 0 -> System.exit(0);
            }

        }
    }

    }

