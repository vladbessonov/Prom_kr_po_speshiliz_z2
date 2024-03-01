import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Controller {
    public PriorityQueue<Toy> getQueue(ArrayList<Toy> toys, int number) {

        Comparator<Toy> comparator = (o1, o2) -> o1.getWeight() - o2.getWeight();
        PriorityQueue<Toy> prizes = new PriorityQueue<>(comparator);
        for (int i = 0; i < toys.size(); i++) {
            for (int j = 0; j < (toys.get(i).getWeight() * number / 100); j++) {
                prizes.add(toys.get(i));
            }
        }
        return prizes;
    }

    public Toy lottery(PriorityQueue<Toy> pq) {
        Toy result = null;
        Random random = new Random();
        int element = random.nextInt(0, pq.size());
        for (int i = 0; i <= element; i++) {
            result = pq.poll();
        }
        return result;
    }

    public void fileWriter(ArrayList<Toy> toys, String text, Integer number) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(text));

        for (int i = 0; i < number; i++) {
            Toy toy = lottery(getQueue(toys, number));
            writer.write(toy.toString() + "\n");
        }
        writer.close();
    }
}
