public class Food {
    int numberOfSales;
    String name;
    String details;
    int price;
    int counter = 1;
    String label;

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
