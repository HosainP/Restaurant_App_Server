
import java.io.Serializable;
public class Food implements Serializable {

    int numberOfSales;
    String name;
    String details;
    int price;
    int counter = 1;
    String label;
    String isAvailable;

    Food(){

    }
    Food(int numberOfSales, String name, String details, int price, int counter, String label, String isAvailable) {
        this();
        this.numberOfSales = numberOfSales;
        this.name = name;
        this.details = details;
        this.price = price;
        this.counter = counter;
        this.label = label;
        this.isAvailable = isAvailable;
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
