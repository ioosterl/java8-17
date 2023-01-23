package sealed;

import java.util.Random;

public class SealedDemo {

    static final Random rnd = new Random();

    public static void main(String[] args) {
        var a1 = makeAnimal("DOG");
        var a2 = makeAnimal("CAT");

        a1.makeNoice();
        a2.makeNoice();
    }

    public static Animal makeAnimal(String type) {
        return switch(type) {
            case "DOG" -> new Dog();
            case "CAT" -> rnd.nextInt()%2 == 0? new Cat.NiceCat() : new Cat.EvilCat();
            default -> new Animal();
        };
    }
}
