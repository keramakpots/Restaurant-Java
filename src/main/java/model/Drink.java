package model;

public class Drink extends Meal {

    private Boolean iceCubes;
    private Boolean lemon;

    public Drink(String name, Float price) {
        super(name, price);
        this.iceCubes = false;
        this.lemon = false;
    }

    public Boolean getIceCubes() {
        return iceCubes;
    }

    public void setIceCubes(Boolean iceCubes) {
        this.iceCubes = iceCubes;
    }

    public Boolean getLemon() {
        return lemon;
    }

    public void setLemon(Boolean lemon) {
        this.lemon = lemon;
    }
}
