package mypackage;

public class TextBlocks {

    static final String firstBlock = """
            Hello World
                How are you doing? ;-)""";

    static final String secondBlock= """
            Hello World
                How are you doing? ;-)
                """;

    static final String thirdBlock= """
            Hello World
                How are you doing? ;-)
            """;

    static final String fourthBlock= """
            Hello World
                How are you doing? ;-)
        """;

    static final String fifthBlock = """
            Hello World
                "How are you doing?" ;-)\
        """;

    static final String sixthBlock =
        """
            Hello World
                How are you doing? ;-)""";

    static final String seventhBlock =
                """
                Hello World
                    How are you doing? ;-)""";

    static final String eighthBlock =
            """
                Hello World
                    How are you doing? ;-)
        """;





    public static void main(String[] args) {
        introduceTextBlock();
        demoIndentationLogic();
    }

    private static void introduceTextBlock() {
        String hello_html = "<html>\n\t<body>\n\t\t<p>Hello, world</p>\n\t</body>\n</html>";

        String hello_html_alternative =
                "<html>\n" +
                        "   <body>\n" +
                        "       <p>Hello, world</p>\n" +
                        "   </body>\n" +
                        "</html>";

        String hello_html_block = """
            <html>
                <body>
                    <p>Hello, world</p>
                </body>
            </html>
            """;

        System.out.println(hello_html);
        System.out.println(hello_html_alternative);
        System.out.println(hello_html_block);
    }

    private static void demoIndentationLogic() {
        System.out.println("firstBlock\n" + firstBlock);
        System.out.println("secondBlock\n" + secondBlock);
        System.out.println("thirdBlock\n" + thirdBlock);
        System.out.println("fourthBlock\n" + fourthBlock);
        System.out.println("fifthBlock\n" + fifthBlock);
        System.out.println("sixthBlock\n" + sixthBlock);
        System.out.println("seventhBlock\n" + seventhBlock);
        System.out.println("eighthBlock\n" + eighthBlock);
    }
}
