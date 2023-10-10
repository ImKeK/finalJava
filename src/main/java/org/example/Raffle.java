package org.example;

import java.util.*;

public class Raffle implements IRaffle {


    private PriorityQueue<RaffleLot> PlayLots;

    public Raffle() {
        PlayLots = new PriorityQueue<>();
    }

    @Override
    public PriorityQueue<RaffleLot> getLotsToBePayed()
    {
        return PlayLots;
    }

    @Override
    public void clearRaffle() {
        PlayLots.clear();
    }

    @Override
    public void createRaffle(ArrayList<Lot> lots) {
        Scanner scanner = new Scanner(System.in);
        int weight = 0;
        for (Lot lot : lots) {
            System.out.println("Для отмены : -1");
            System.out.println("\n" + lot);
            System.out.print("Вес лота : ");
            if (scanner.hasNextInt()) weight = scanner.nextInt();
            if (weight < 0) {
                scanner.close();
                return;
            }
            addLotToRaffle(lot, weight);
            System.out.println("Добавлено");
        }
        scanner.close();
    }

    @Override
    public void addLotToRaffle(Lot lot, int weight) {
        PlayLots.add(new RaffleLot(lot, weight));
    }

    @Override
    public void removeLotFromRaffle(Lot lot) {
        RaffleLot l = null;
        for (RaffleLot ll : PlayLots) {
            if (l.equals(ll.getLot())) l = ll;
        }
        if (l != null) PlayLots.remove(l);
    }

    @Override
    public Lot drawLot() {
        if (!PlayLots.isEmpty()) return PlayLots.poll().getLot();
        else return null;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for(RaffleLot lot : PlayLots){
            builder.append(lot.getLot().getName()+" *** ").append(lot.getWeight()+" ***" +
                    " ").append(
                    "\n");
        }
        return builder.toString();
    }
}
