package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.PriorityQueue;


public interface IRaffle extends Serializable {



    public PriorityQueue<RaffleLot>getLotsToBePayed();

    public void clearRaffle();

    public void createRaffle(ArrayList<Lot> lots);

    void addLotToRaffle(Lot lot, int weight);

    void removeLotFromRaffle(Lot lot);
    Lot drawLot();
}
