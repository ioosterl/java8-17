package sealed;

public sealed class Animal
permits Cat, Dog{

    void makeNoice() {
        System.out.println("Throws pot on the floor");
    }

}
