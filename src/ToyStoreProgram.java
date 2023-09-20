public class ToyStoreProgram {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        Toy toy1 = new Toy(1, "Куклу", 10, 30);
        Toy toy2 = new Toy(2, "Машинку", 15, 20);
        Toy toy3 = new Toy(3, "Тедди", 8, 50);

        store.addToy(toy1);
        store.addToy(toy2);
        store.addToy(toy3);

        store.updateWeight(1, 40); // Увеличиваем вес куклы

        for (int i = 0; i < 5; i++) {
            String prize = store.getPrize();
            System.out.println("Ты выиграл " + prize);
        }
    }
}