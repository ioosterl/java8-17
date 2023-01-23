public class Var {

    static Supercalifragilisticexpialidocious getSupercalifragilisticexpialidocious() {
        return new Supercalifragilisticexpialidocious();
    }

    public static void main(String[] args) {
        explicitTypeDeclaration();

        localVariableTypeInference();
    }

    private static void localVariableTypeInference() {
        var s = getSupercalifragilisticexpialidocious();
        System.out.println(s.getMeaning());
    }

    private static void explicitTypeDeclaration() {
        Supercalifragilisticexpialidocious s = getSupercalifragilisticexpialidocious();
        System.out.println(s.getMeaning());
    }


    static class Supercalifragilisticexpialidocious {
        String getMeaning() {
            return "Just a little word so say when you have nothing to say...";
        }
    }
}
