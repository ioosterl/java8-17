import java.util.Optional;

public class NewOptionalMethods {

    public static void main(String[] args) {
        final var helloWorld = Optional.of("Hello, world");
        demoIfPresentOrElse(helloWorld);
        demoIfPresentOrElse(Optional.empty());

        demoIfPresentOrElse(Optional.empty().or(() -> helloWorld));

        helloWorld.stream().forEach(System.out::println);

        Optional.empty().orElseThrow();
    }

    private static void demoIfPresentOrElse(Optional<?> myOpt) {
        myOpt.ifPresentOrElse(System.out::println, () -> System.out.println("No text was given"));
    }
}
