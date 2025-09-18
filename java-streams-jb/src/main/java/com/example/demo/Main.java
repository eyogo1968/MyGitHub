package com.example.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static long counter;
    private static void wasCalled() {
        counter++;
    }


    public static void main(String[] args) throws IOException {

        /*
            We should use the empty() method in case of
            the creation of an empty stream
         */
        Stream<String> streamEmpty = Stream.empty();

        /*
            We can also create a stream of any type of
            Collection (Collection, List, Set):
         */
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        /*
            An array can also be the source of a stream
         */
        Stream<String> streamOfArray = Stream.of("a", "b", "c");

        /*
            We can also create a stream out of an existing
            array or of part of an array:
         */
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        /*
            Stream.builder()
            When builder is used, the desired type should be additionally
            specified in the right part of the statement, otherwise the build()
            method will create an instance of the Stream<Object>
         */
        Stream<String> streamBuilder =
                Stream.<String>builder()
                        .add("a")
                        .add("b")
                        .add("c")
                        .build();
        /*
            Stream.generate()
            The generate() method accepts a Supplier<T> for element generation.
            As the resulting stream is infinite, the developer should specify the
            desired size, or the generate() method will work until it reaches the
            memory limit:

            The code following creates a sequence of ten strings with the value
            element.”
         */
        Stream<String> streamGenerated =
                Stream.generate(() -> "element")
                        .limit(10);

        /*
            Stream.iterate()
            Another way of creating an infinite stream is by using the iterate()
            method:

            In the following code :
            The first element of the resulting stream is the first parameter of the
            iterate() method. When creating every following element, the specified
            function is applied to the previous element. In the example above the
            second element will be 42.
         */
        Stream<Integer> streamIterated =
                Stream.iterate(40, n -> n + 2)
                        .limit(20);

        /*
            Stream of Primitives
            Java 8 offers the possibility to create streams out of three primitive
            types: int, long and double.

            As Stream<T> is a generic interface, and there is no way to use primitives
            as a type parameter with generics, three new special interfaces were created:
            IntStream, LongStream, DoubleStream.

            Using the new interfaces alleviates unnecessary auto-boxing, which allows for
            increased productivity:

            In the following code :

            The range(int startInclusive, int endExclusive) method creates an ordered
            stream from the first parameter to the second parameter. It increments the
            value of subsequent elements with the step equal to 1. The result doesn’t
            include the last parameter, it is just an upper bound of the sequence.

            The rangeClosed(int startInclusive, int endInclusive) method does the same
            thing with only one difference, the second element is included. We can use
            these two methods to generate any of the three types of streams of primitives.
         */
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        /*
            Since Java 8, the Random class provides a wide range of methods for generating
            streams of primitives. For example, the following code creates a DoubleStream,
            which has three elements:
         */
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);

        /*
            Stream of String
            We can also use String as a source for creating a stream with the help of the chars()
            method of the String class. Since there is no interface for CharStream in JDK, we use
            the IntStream to represent a stream of chars instead.
         */
        IntStream streamOfChars = "abc".chars();

        /*
            The following example breaks a String into sub-strings according to specified RegEx:
         */
        Stream<String> streamOfString =
                Pattern.compile(", ")
                        .splitAsStream("a, b, c");

        /*
            Stream of File
            Furthermore, Java NIO class Files allows us to generate a Stream<String> of a text
            file through the lines() method. Every line of the text becomes an element of the
            stream:

            The Charset can be specified as an argument of the lines() method
         */
        Path path = Paths.get("C:\\file.txt");
        Stream<String> streamOfStrings = Files.lines(path);
        Stream<String> streamWithCharset =
                Files.lines(path, Charset.forName("UTF-8"));

        /*
            We can instantiate a stream, and have an accessible reference to it,
            as long as only intermediate operations are called.

            Executing a terminal operation makes a stream inaccessible.

            To demonstrate this, we will forget for a while that the best practice is
            to chain the sequence of operation. Besides its unnecessary verbosity,
            technically the following code is valid:
         */
        Stream<String> stream =
                Stream.of("a", "b", "c")
                        .filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny();

        /*
            However, an attempt to reuse the same reference after calling the terminal
            operation will trigger the IllegalStateException:
         */
        Optional<String> firstElement = stream.findFirst();

        /*
            As the IllegalStateException is a RuntimeException, a compiler will not signalize
            about a problem. So it is very important to remember that Java 8 streams can’t be
            reused.

            This kind of behavior is logical. We designed streams to apply a finite sequence
            of operations to the source of elements in a functional style, not to store elements.

            So to make the previous code work properly, some changes should be made:
         */
        List<String> elements =
                Stream.of("a", "b", "c")
                        .filter(element -> element.contains("b"))
                        .collect(Collectors.toList());
        Optional<String> anyElement2 = elements.stream().findAny();
        Optional<String> firstElement2 = elements.stream().findFirst();

        /*
        Stream Pipeline
        To perform a sequence of operations over the elements of the data source and aggregate
        their results, we need three parts: the source, intermediate operation(s) and a
        terminal operation.

        Intermediate operations return a new modified stream. For example, to create a new
        stream of the existing one without few elements, the skip() method should be used:
         */
        Stream<String> onceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd")
                        .skip(1);

        /*
            If we need more than one modification, we can chain intermediate operations.
            Let’s assume that we also need to substitute every element of the current
            Stream<String> with a sub-string of the first few chars. We can do this by
            chaining the skip() and map() methods:
         */
        Stream<String> twiceModifiedStream =
                stream
                        .skip(1)
                        .map(element -> element.substring(0, 3));

        /*
            As we can see, the map() method takes a lambda expression as a parameter.
            If we want to learn more about lambdas, we can take a look at our tutorial
            Lambda Expressions and Functional Interfaces: Tips and Best Practices.

            A stream by itself is worthless; the user is interested in the result of the
            terminal operation, which can be a value of some type or an action applied to
            every element of the stream. We can only use one terminal operation per stream.

            The correct and most convenient way to use streams is by a stream pipeline,
            which is a chain of the stream source, intermediate operations, and a terminal
            operation:
         */
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list
                .stream()
                .skip(1)
                .map(element -> element.substring(0, 3))
                .sorted().
                count();

        /*
            Lazy Invocation
            Intermediate operations are lazy. This means that they will be invoked only if it
            is necessary for the terminal operation execution.

            For example, let’s call the method wasCalled(), which increments an inner counter
            every time it’s called:

            Now let’s call the method wasCalled() from operation filter():
         */
        List<String> list2 = Arrays.asList("abc1", "abc2","abc3");
        counter = 0;
        Stream<String> stream2 = list2
                .stream()
                .filter(element -> {
                    wasCalled();
                    return element.contains("2"); });

        /*
            As we have a source of three elements, we can assume that the filter() method
            will be called three times, and the value of the counter variable will be 3.
            However, running this code doesn’t change counter at all, it is still zero,
            so the filter() method wasn’t even called once. The reason why is missing of
            the terminal operation.

            Let’s rewrite this code a little bit by adding a map() operation and a terminal
            operation, findFirst(). We will also add the ability to track the order of method
            calls with the help of logging:

            In the following code :

            The result shows that we called the filter() method twice and the map()
            method once. This is because the pipeline executes vertically. In our example,
            the first element of the stream didn’t satisfy the filter’s predicate.

            Then we invoked the filter() method for the second element, which passed the
            filter. Without calling the filter() for the third element, we went down through
            the pipeline to the map() method.

            The findFirst() operation satisfies by just one element. So, in this particular
            example, the lazy invocation allowed us to avoid one method call for filter().
        */
        Optional<String> stream3 = list
            .stream()
            .filter(element -> {
                System.out.println("filter() was called");
                return element.contains("2");})
            .map(element -> {
                System.out.println("map() was called");
                return element.toUpperCase();})
            .findFirst();

       /*
            Order of Execution
            From the performance point of view, the right order is one of the most
            important aspects of chaining operations in the stream pipeline:
      */
       long size2 = list
            .stream()
            .map(element -> {
                    wasCalled();
                    return element.substring(0, 3);})
            .skip(2).count();
       /*
            Execution of this code will increase the value of the counter by three.
            This means that we called the map() method of the stream three times,
            but the value of the size is one. So the resulting stream has just one
            element, and we executed the expensive map() operations for no reason
            wo out of the three times.

            If we change the order of the skip() and the map() methods, the counter
            will increase by only one. So we will call the map() method only once:

            This brings us to the following rule: intermediate operations which reduce
            the size of the stream should be placed before operations which are applying
            to each element. So we need to keep methods such as skip(), filter(), and
            distinct() at the top of our stream pipeline.
       */
       long size3 = list
                .stream()
                .skip(2)
                .map(element -> {
                        wasCalled();
                        return element.substring(0, 3);})
                .count();

       /*
            7. Stream Reduction
            The API has many terminal operations which aggregate a stream to a type
            or to a primitive: count(), max(), min(), and sum().

            However, these operations work according to the predefined implementation.

            So what if a developer needs to customize a Stream’s reduction mechanism?

            There are two methods which allow us to do this, the reduce() and the collect()
            methods.

            The reduce() Method
       */

        /*
        The reduce() Method
         */

       OptionalInt reduced =
                IntStream.range(1, 4).reduce((a, b) -> a + b);

       int reducedTwoParams =
                IntStream.range(1, 4).reduce(10, (a, b) -> a + b);

       /*
        The collect() Method
        */

       List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));


       //Converting a stream to the Collection (Collection, List or Set):

       List<String> collectorCollection =
                productList
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.toList());

       //Reducing to String:

       String listToString = productList
                .stream()
                .map(Product::getName)
                .collect(Collectors.joining(", ", "[", "]"));


       //Processing the average value of all numeric elements of the stream:

       double averagePrice = productList
                .stream()
                .collect(Collectors.averagingInt(Product::getPrice));


       //Processing the sum of all numeric elements of the stream:

       int summingPrice = productList
                .stream()
                .collect(Collectors.summingInt(Product::getPrice));


       //Collecting statistical information about stream’s elements:

       IntSummaryStatistics statistics = productList
                .stream()
                .collect(Collectors.summarizingInt(Product::getPrice));

        //Grouping of stream’s elements according to the specified function:

       Map<Integer, List<Product>> collectorMapOfLists = productList
                .stream()
                .collect(Collectors.groupingBy(Product::getPrice));

        //Dividing stream’s elements into groups according to some predicate:

       Map<Boolean, List<Product>> mapPartioned = productList.
                stream()
                .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

        //Pushing the collector to perform additional transformation:

       Set<Product> unmodifiableSet = productList
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        Collections::unmodifiableSet));

       /*
            Custom collector
            If for some reason a custom collector should be created, the easiest and least verbose
            way of doing so is to use the method of() of the type Collector.
       */
       Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

       LinkedList<Product> linkedListOfPersons =
                productList
                        .stream()
                        .collect(toLinkedList);

       /*
            Stream API Enhancements in Java 9
            Java 9 introduces a few notable improvements to the Stream API that make working with streams
            even more expressive and efficient. In this section, we’ll cover the takeWhile(), dropWhile(),
            iterate(), and ofNullable() methods, exploring how they simplify various operations compared
            to Java 8
        */

        //takeWhile() and dropWhile()

        Stream<String> stream4 = Stream
                .iterate("", s -> s + "s")
                .takeWhile(s -> s.length() < 10);

        Stream<String> stream5 = Stream
                .of("a", "aa", "aaa", "aaaaa")
                .dropWhile(s -> s.length() < 5);

        //Enhanced iterate() Method

        Stream.iterate(0, i -> i < 10, i -> i + 1)
                .forEach(System.out::println);

       //ofNullable() for Optional Elements

        Map<String,Product> map = new HashMap<String,Product>();
       collection.stream()
                .flatMap(s -> Stream.ofNullable(map.get(s)))
                .collect(Collectors.toList());

    }

    /*
        We often use the empty() method upon creation to avoid returning
        null for streams with no element
    */
    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
}