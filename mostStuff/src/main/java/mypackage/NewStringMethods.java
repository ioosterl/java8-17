package mypackage;

public class NewStringMethods {

    public static void main(String[] args) {
//        demoChars();

//        demoLines();

//        demoRepeat();

//        demoTransform();

//        demoIndent();
    }

    static void demoChars() {
        System.out.printf("Number of i in String = %d%n", "Lorem ipsum dolor sit amet, consectetur adipiscing elit".chars()
                .filter(i -> i == 'i')
                .count());
    }

    static void demoLines() {
        var input = "a multi line \n string has multiple \n lines. \n Imagine that \n!!!";
        System.out.println(input);
        input.lines()
                .map(l -> "Line: " + l.strip())
                .forEach(System.out::println);
    }

    static void demoRepeat() {
        System.out.println("ssdd".repeat(5));
    }

    static void demoTransform() {
        var base = "hello string";
        System.out.println(base.<String>transform(s -> s.split(" ")[0].toUpperCase()));
    }

    static void demoIndent() {
        System.out.println("hello\nworld");
        System.out.println("hello\nworld".indent(5));
        System.out.println(" hello\n world".stripIndent());
        System.out.println("hello\n world".stripIndent());
    }
}

