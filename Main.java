import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {

        Controller controller = new Controller();

        ArrayList<Toy> toys = new ArrayList<>();
        toys.add(new Toy(1, "Кукла", 15));
        toys.add(new Toy(2, "Робот", 30));
        toys.add(new Toy(3, "Конструктор", 10));
        toys.add(new Toy(4, "Машина", 40));
        toys.add(new Toy(5, "Оружие", 5));

        int numberOfPrizes = 20; // Количество розыгрышей

        controller.fileWriter(toys, "prize_result.txt", numberOfPrizes);
    }
}
