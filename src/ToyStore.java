import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
            }
        }
    }

    public Toy drawToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        double randomNum = new Random().nextDouble() * totalWeight;

        for (Toy toy : toys) {
            randomNum -= toy.getWeight();
            if (randomNum <= 0 && toy.getQuantity() > 0) {
                toy.decreaseQuantity();
                return toy;
            }
        }

        return null;
    }

    public String getPrize() {
        Toy prize = drawToy();
        if (prize != null) {
            try {
                FileWriter writer = new FileWriter("prizes.txt", true);
                writer.write("Выиграл: " + prize.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prize.getName();
        } else {
            return "Приз недоступен";
        }
    }
}