public class Food {
    int numberOfSales;
    String name;
    String details;
    int price;
    int counter = 1;
    String label;

    Food(int numberOfSales, String name, String details, int price, int counter, String label) {
        this.numberOfSales = numberOfSales;
        this.name = name;
        this.details = details;
        this.price = price;
        this.counter = counter;
        this.label = label;
    }

    @Override
    public String toString() {
        return "Food{" +
                "numberOfSales=" + numberOfSales +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", price=" + price +
                ", counter=" + counter +
                ", label='" + label + '\'' +
                '}';
    }
}
