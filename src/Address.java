import java.io.Serializable;

public class Address implements Serializable {
    private String AddressName;
    private double latitude;
    private double longitude;

    public Address(String addressName, double latitude, double longitude) {
        AddressName = addressName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAddressName() {
        return AddressName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Address{" +
                "AddressName='" + AddressName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}