package mypackage;

import java.time.LocalDate;
import java.time.Month;

public class RecordsDemo {

    static
    class PersonClass {
        private final String firstName;
        private final String lastName;
        private final LocalDate birthDay;

        public PersonClass(String firstName, String lastName, LocalDate birthDay) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDay = birthDay;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public LocalDate getBirthDay() {
            return birthDay;
        }

    }

    record PersonRecord(String firstName,
                        String lastName,
                        LocalDate birthDate){
    }


    public static void main(String[] args) {
        var pc = new PersonClass("Istvan", "Oosterlinck", LocalDate.of(1982, Month.MARCH, 18));
        var pc2 = new PersonClass("Istvan", "Oosterlinck", LocalDate.of(1982, Month.MARCH, 18));
        System.out.println(pc.equals(pc2));


        var pr = new PersonRecord("Istvan", "Oosterlinck", LocalDate.of(1982, Month.MARCH, 18));
        var pr2 = new PersonRecord("Istvan", "Oosterlinck", LocalDate.of(1982, Month.MARCH, 18));

        System.out.println(pr.equals(pr2));
    }

}
