package model;

public class Meal {

    private Float price;
    private String name;

    Meal(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
