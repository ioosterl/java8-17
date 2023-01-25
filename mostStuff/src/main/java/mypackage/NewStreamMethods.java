package mypackage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewStreamMethods {

    public static void main(String[] args) {
        demoMapMulti();

        demoTakeWhile();

        demoToList();

        demoFlatMapping();

        demoFiltering();

        demoTeeing();

    }

    private static void demoTeeing() {
        List<Blog> blogList = Arrays.asList(
                new Blog("Ann", "meh", "great", "blah"),
                new Blog("Sue", "horrible" ),
                new Blog("James", "+1", "superb", "write more", "enjoyed" ),
                new Blog("Bill"));

        Map<String, Object> result = blogList.stream().collect(
                Collectors.teeing(
                        Collectors.filtering(b -> b.getComments().size() >= 3, Collectors.toList()),
                        Collectors.filtering(e -> e.getComments().size() >=3, Collectors.counting()),
                        (list, count) -> {
                            var map = new HashMap<String, Object>();
                            map.put("list", list);
                            map.put("count", count);
                            return map;
                        }
                ));

        System.out.println(result);
    }

    private static void demoFiltering() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 5);

        Map<Integer, Long> streamFiltered = numbers.stream()
                .filter(val -> val > 3)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        System.out.println(streamFiltered);

        Map<Integer, Long> collectionFiltered = numbers.stream()
                .collect(Collectors.groupingBy(i -> i,
                        Collectors.filtering(val -> val > 3, Collectors.counting())));
        System.out.println(collectionFiltered);
    }

    private static void demoFlatMapping() {
        Blog blog1 = new Blog("Lee", "Nice", "Very Nice");
        Blog blog2 = new Blog("Ann", "Disappointing", "Ok", "Could be better");
        List<Blog> blogs = List.of(blog1, blog2);

        Map<String, List<String>> commentsByAuthor = blogs.stream()
                .collect(Collectors.groupingBy(Blog::getAuthorName,
                        Collectors.flatMapping(blog -> blog.getComments().stream(),
                                Collectors.toList())));
        System.out.println(commentsByAuthor);

        Map<String, List<List<String>>> commentsByAuthorUsingMapping = blogs.stream()
                .collect(Collectors.groupingBy(Blog::getAuthorName,
                        Collectors.mapping(Blog::getComments,
                                Collectors.toList())));
        System.out.println(commentsByAuthorUsingMapping);
    }

    static class Blog {
        private String authorName;
        private List<String> comments;

        Blog(String author, String... comments) {
            authorName = author;
            this.comments = Arrays.asList(comments);
        }

        public String getAuthorName() {
            return authorName;
        }

        public List<String> getComments() {
            return comments;
        }
    }

    private static void demoToList() {
        try {
            List<Integer> toList = IntStream.iterate(0, i -> i < 10, i -> i + 2)
                    .boxed()
                    .toList();
            toList.add(12);
            System.out.println("toList: "+ toList);
        } catch (UnsupportedOperationException uoe) {
            uoe.printStackTrace();
        }

        List<Integer> collectToList = IntStream.iterate(0, i -> i < 10, i -> i + 2)
                .boxed()
                .collect(Collectors.toList());
        collectToList.add(12); // works but not guaranteed that the returned list is mutable
        System.out.println("collectToLIst: "+collectToList);

        List<Integer> collectToCollections = IntStream.iterate(0, i -> i < 10, i -> i + 2)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        collectToCollections.add(12); // we are sure this works, due to controlling the supplier for the collection
        System.out.println("collectToCollection:"+collectToCollections);
    }

    private static void demoTakeWhile() {
        var numbers = List.of(2, 4, 6, 7, 9, 12, 14);

        System.out.println("TakeWhile: " + numbers.stream()
                .takeWhile(i -> i % 2 == 0)
                .map(i -> "" + i)
                .collect(Collectors.joining(";")));

        System.out.println("Filter: " + numbers.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> "" + i)
                .collect(Collectors.joining(";")));
    }

    private static void demoMapMulti() {
        System.out.println(IntStream.rangeClosed(1, 5)
                .boxed()
                .mapMulti((i, buffer) -> IntStream.rangeClosed(1, 3).mapToDouble(Double::valueOf).map(n -> Math.pow(i, n)).forEach(buffer::accept))
                .map(d -> ((Double) d).intValue())
                .toList());
    }
}
