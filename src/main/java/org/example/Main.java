package org.example;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Store store=new Store();
        store.addLot(new Toy(store.createId(), "Игрушка 1", 5400.0, "Медведь-Гризли",
                Toy.Category.BEAR, Toy.AgeProv.AGE_4_PLUS));
        store.addLot(new Toy(store.createId(), "Игрушка 2", 8510.0, "Кукла Вуду",
                Toy.Category.DOLLS, Toy.AgeProv.AGE_15_PLUS));
        store.addLot(new Toy(store.createId(), "Игрушка 3", 7200.0, "Белый медведь",
                Toy.Category.WHITE_BEAR, Toy.AgeProv.AGE_6_8));
        store.addLot(new Toy(store.createId(), "Игрушка 4", 370.0, "Король Лев",
                Toy.Category.ANIMALS, Toy.AgeProv.AGE_4_PLUS));
        store.addLot(new Toy(store.createId(), "Игрушка 5", 30540.0, "Лягушка",
                Toy.Category.LAX, Toy.AgeProv.AGE_6_8));

        store.printProducts();

        store.saveProducts("AppProduct.dat");

        store.clearProducts();

        store.readProducrts("AppProduct.dat");

        store.printProducts();

        Raffle raffle =new Raffle();

        Random random=new Random();
        int weight=0;
        for(int i=0;i<store.getProducts().size();i++){
            weight=random.nextInt(100);
            raffle.addLotToRaffle(store.getProducts().get(i),weight);
        }

        store.addRaffle(raffle);
        store.saveRaffle("AppRaffle.dat");
        store.clearLotteries();
        store.readRaffle("AppRaffle.dat");
        raffle =store.getRaffles().get(store.getRaffles().size()-1);
        System.out.println("Товары доступные в лотерее:");
        System.out.println(raffle.toString());

        System.out.println("Первый приз :");
        Toy toy_1=(Toy) raffle.drawLot();
        System.out.println(toy_1.toString());

        System.out.println("Второй приз :");
        Toy toy_2=(Toy) raffle.drawLot();
        System.out.println(toy_2.toString());

        System.out.println("Третий приз :");
        Toy toy_3=(Toy) raffle.drawLot();
        System.out.println(toy_3.toString());

        System.out.println("Четвертый приз :");
        Toy toy_4=(Toy) raffle.drawLot();
        System.out.println(toy_4.toString());

        System.out.println("Пятый приз :");
        Toy toy_5=(Toy) raffle.drawLot();
        System.out.println(toy_5.toString());


    }
}