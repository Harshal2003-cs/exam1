abstract class Pizza {
    void prepare() { System.out.println("Preparing " + this.getClass().getSimpleName()); }
    void bake() { System.out.println("Baking " + this.getClass().getSimpleName()); }
    void cut() { System.out.println("Cutting " + this.getClass().getSimpleName()); }
    void box() { System.out.println("Boxing " + this.getClass().getSimpleName()); }
}

class NYStyleCheesePizza extends Pizza { 
    public NYStyleCheesePizza() {
        System.out.println("Creating NY Style Cheese Pizza - Thin Crust, Marinara Sauce");
    }
}

class ChicagoStyleCheesePizza extends Pizza { 
    public ChicagoStyleCheesePizza() {
        System.out.println("Creating Chicago Style Cheese Pizza - Deep Dish, Tomato Sauce");
    }
}

abstract class PizzaStore {
    abstract Pizza createPizza(String type);
    
    Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

class NYPizzaStore extends PizzaStore {
    Pizza createPizza(String type) {
        if (type.equals("cheese")) return new NYStyleCheesePizza();
        else return null;
    }
}

class ChicagoPizzaStore extends PizzaStore {
    Pizza createPizza(String type) {
        if (type.equals("cheese")) return new ChicagoStyleCheesePizza();
        else return null;
    }
}

public class PizzaTestDrive {
    public static void main(String[] args) {
        System.out.println("=== NY Pizza Store ===");
        PizzaStore nyStore = new NYPizzaStore();
        Pizza nyPizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + nyPizza.getClass().getSimpleName() + "\n");
        
        System.out.println("=== Chicago Pizza Store ===");
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza chicagoPizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + chicagoPizza.getClass().getSimpleName());
    }
}