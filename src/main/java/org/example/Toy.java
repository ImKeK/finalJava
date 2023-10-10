package org.example;

public class Toy extends Lot {
    public enum Category {
        DOLLS, BEAR, WHITE_BEAR, LAX, ANIMALS
    }

    public enum AgeProv {
        AGE_6_8, AGE_15_PLUS, AGE_4_PLUS
    }

    private Category category;
    private AgeProv ageProv;


    public Toy(int id, String name, Double price, String description, Category category,
               AgeProv ageProv) {
        super(id,name,price,description);
        this.category = category;
        this.ageProv = ageProv;
    }


    public void setCategory(Category category){
        this.category=category;
    }

    public void setAgeProv(AgeProv ageProv){
        this.ageProv = ageProv;
    }

    public Category getCategory() {
        return category;
    }


    public AgeProv getAgeProv() {
        return ageProv;
    }
}
