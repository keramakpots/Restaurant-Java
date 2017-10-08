import DAO.DaoDessert;
import DAO.DaoDrink;
import DAO.DaoMainDish;
import java.util.List;
import model.Dessert;
import model.Drink;
import model.Lunch;
import model.Order;
import ui.InputGetter;
import view.Menu;
import view.Printer;

class Application {

    private final Order order;
    private DaoDessert daoDessert;
    private DaoDrink daoDrink;

    private Application(Order order, DaoDessert daoDessert, DaoDrink daoDrink) {
        this.order = order;
        this.daoDessert = daoDessert;
        this.daoDrink = daoDrink;
    }

    public static void run() {
        Application application = new Application(new Order(), new DaoDessert(), new DaoDrink());
        mainLoop:
        while (true) {
            Printer.printMenu(Menu.getMainMenu());
            Integer option = InputGetter.getIntegerInput();
            switch (option) {
                case 1:
                    application.handleOrderLunch();
                case 2:
                    application.handleOrderDrink();
                case 3:
                    Printer.printOrder(application.order);
                case 4:
                    application.handlePayment();
                    continue;
                case 0:
                    break mainLoop;
                default:
                    System.out.println("Try again");
            }
        }
    }

    private void handlePayment() {
        Printer.printOrder(this.order);
        paymeantLopp:
        while (true) {
            Printer.printObject("Do you want to pay by Cash (press 1) or Card (press 2)?");
            Printer.printObject("0 to go back");
            Integer option = InputGetter.getIntegerInput();
            switch (option) {
                case 1: {
                    Printer.printObject("You are paying by Cash");
                }
                case 2: {
                    Printer.printObject("You are paying by Card");
                }
                case 0: {
                    break paymeantLopp;
                }
                default: {
                    Printer.printObject("Not an option try again");
                }
            }
        }
    }

    private void handleOrderDrink() {
        while (true) {
            Printer.printBreak();
            Printer.printDrinkHashMap(daoDrink.getDrinkHashMap());
            Integer option = InputGetter.getIntegerInput();
            Drink drink = daoDrink.getDrink(option);
            if (drink!=null) {
                Printer.printObject("Do you want ice Cubes? Enter 1 for yes and else for no.");
                Integer chooseIce = InputGetter.getIntegerInput();
                if (chooseIce == 1) {
                    drink.setIceCubes(true);
                }
                Printer.printObject("Do you want Lemon in drink? Enter 1 for yes and else for no.");
                Integer chooseLemon = InputGetter.getIntegerInput();
                if (chooseLemon == 1) {
                    drink.setIceCubes(true);
                }
                this.order.setDrinks(drink);
                break;
            } else {
                Printer.printObject("Bad Option. Try again");
            }
        }
    }

    private void handleOrderLunch() {
        String cuisuine;
        Lunch lunch = new Lunch();
        while (true) {
            try {
                cuisuine = Application.handleCuisuineChoose();
            } catch (Exception e) {
                Printer.printObject("Not an option");
                continue;
            }
            if (cuisuine!=null) {
                lunch.setMainCourse(DaoMainDish.getLunchFromCuisuine(cuisuine));
                break;
            } else if (cuisuine==null) {
                Printer.printObject("Bad Option. Try again");
            }
        }

        while (true) {
            Dessert dessert = Application.handleDessertChoose(daoDessert);
            if (dessert == null) {
                Printer.printObject("Bad Option. Try again");
            } else {
                lunch.setDessert(dessert);
                this.order.setLunch(lunch);
                break;
            }
        }
    }

    static Dessert handleDessertChoose(DaoDessert daoDessert) {
        Printer.printDessertHashMap(daoDessert.getDessertHashMap());
        Integer dessertOption = InputGetter.getIntegerInput();
        return daoDessert.getDessert(dessertOption);
    }

    static String handleCuisuineChoose() {
        Printer.printOption(Menu.getCuisuines());
        Integer option = InputGetter.getIntegerInput();
        List<String> cuisuines = Menu.getCuisuines();
        String cuisuine = cuisuines.get(option - 1);
        return cuisuine;
    }
}
