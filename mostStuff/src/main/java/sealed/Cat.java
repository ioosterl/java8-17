package sealed;

public sealed class Cat extends Animal
permits Cat.EvilCat, Cat.NiceCat{


    static final class EvilCat extends Cat {
        @Override
        void makeNoice() {
            System.out.println("Making evil hissing sound");
        }
    }

    static final class NiceCat extends Cat {
        @Override
        void makeNoice() {
            System.out.println("Purrrrrrr");
        }
    }
}
