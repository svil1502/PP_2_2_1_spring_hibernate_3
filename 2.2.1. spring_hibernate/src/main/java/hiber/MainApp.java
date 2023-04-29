package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        User user1 = new User("Masha", "1111112", "11111l2.ru");
        Car car1 = new Car();
        car1.setModel("Mitcubisi");
        car1.setSeries(123582);
        car1.setUser(user1);
        user1.setCar(car1);
        userService.add(user1);
        carService.add(car1);

        User user2 = new User("Sasha", "1111112", "mypost.ru");
        Car car2 = new Car();
        car2.setModel("Volga-Volga");
        car2.setSeries(12372);
        car2.setUser(user2);
        user2.setCar(car2);
        userService.add(user2);
        carService.add(car2);

        List<User> userList = userService.listUsers();
        for (User user : userList) {
            System.out.println("Found user: " + user.getFirstName());
            System.out.println("User's model's car: " + user.getCar().getModel());
            System.out.println("User's series's car:: " + user.getCar().getSeries());
        }
        User user5 = userService.getUser("Volga-Volga", 12372);
        System.out.println(user5.getFirstName());

        context.close();
    }
}
