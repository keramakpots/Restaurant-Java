package model;

import java.util.ArrayList;
import java.util.List;

public class Order {


    private List<Lunch> lunches;
    private List<Drink> drinks;
  
    public Order() {
        this.lunches = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(Drink drink) {
        this.drinks.add(drink);
    }

    public void removeDrink(Drink drink) {
        this.drinks.remove(drink);
    }

    public List<Lunch> getLunch() {
        return lunches;
    }

    public void setLunch(Lunch lunch) {
        this.lunches.add(lunch);
    }

    public Float getPrice() {
        Float price = 0f;
        for (Lunch lunch : lunches) {
            price += lunch.getPrice();
        }
        for (Drink drink : drinks) {
            price += drink.getPrice();
        }
        return price;
    }
}