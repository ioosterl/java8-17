public class NullPointerExample {

    private static Address getAddress() {
        return new Address(
                new Street("Demo Street"),
                new HouseNumber(13),
                new Locality(
                        new ZipCode(null),
                        "Example Town"
                )
        );
    }


    public String formatAddress(final Address address) {
        return address.street.name + " "
                + address.houseNumber.number + address.houseNumber.suffix.toUpperCase() + "\n"
                + address.locality.zipCode.code + " - " + address.locality.City;
    }

    public static void main(String[] args) {
        System.out.println(new NullPointerExample().formatAddress(getAddress()).equals("Demo Street 13\n - Example Town"));
    }

    static class Address {

        final Street street;
        final HouseNumber houseNumber;

        final Locality locality;


        public Address(Street street, HouseNumber houseNumber, Locality locality) {
            this.street = street;
            this.houseNumber = houseNumber;
            this.locality = locality;
        }
    }

    static class HouseNumber {

        final int number;

        final String suffix;

        public HouseNumber(int number) {
            this.number = number;
            this.suffix = null;
        }

        public HouseNumber(int number, String suffix) {
            this.number = number;
            this.suffix = suffix;
        }
    }

    static class Locality {
        final ZipCode zipCode;

        final String City;

        public Locality(ZipCode zipCode, String city) {
            this.zipCode = zipCode;
            City = city;
        }


    }

    static class Street {

        final String name;

        public Street(String name) {
            this.name = name;
        }
    }

    static class ZipCode {

        final String code;

        public ZipCode(String code) {
            this.code = code;
        }
    }
}
