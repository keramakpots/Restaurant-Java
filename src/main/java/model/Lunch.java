package model;

public class Lunch {

    private MainCourse mainCourse;
    private Dessert dessert;
    private Float price;

    public Lunch() {
    }

    public Lunch(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
        this.dessert = null;
    }

    public MainCourse getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public Float getPrice() {
        if (dessert == null) {
            return this.mainCourse.getPrice();
        }
        return this.dessert.getPrice() + this.mainCourse.getPrice();
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Main Dish:" + this.mainCourse.getName() + " " + this.mainCourse.getPrice()
            + ", Dessert " + this.dessert.getName() + " " + this.dessert.getPrice();
    }
}