package org.example;

import java.io.Serializable;

public class RaffleLot implements Comparable<RaffleLot>, Serializable {
    protected int weight;
    protected Lot lot;


    public RaffleLot(Lot lot, int weight) {
        this.weight = weight;
        this.lot = lot;
    }


    public Lot getLot() {
        return lot;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(RaffleLot o) {
        return Integer.compareUnsigned(o.getWeight(), this.getWeight());
    }
}
