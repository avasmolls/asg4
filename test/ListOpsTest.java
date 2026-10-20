import io.github.dt.VList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListOpsTest {

    // 1. sum
    @Test
    void testSum() {
        // Assignment example
        Assertions.assertEquals(7,
                ListOps.sum(VList.of(3, -1, 5)));

        // Empty
        Assertions.assertEquals(0,
                ListOps.sum(VList.empty()));

        // Singleton
        Assertions.assertEquals(5,
                ListOps.sum(VList.of(5)));

        // Longer
        Assertions.assertEquals(15,
                ListOps.sum(VList.of(1, 2, 3, 4, 5)));
    }


    // 2. length
    @Test
    void testLength() {
        // Assignment example - String
        Assertions.assertEquals(2,
                ListOps.length(VList.of("a", "b")));

        // Empty
        Assertions.assertEquals(0,
                ListOps.length(VList.<String>empty()));

        // Singleton
        Assertions.assertEquals(1,
                ListOps.length(VList.of("hello")));

        // Longer - Integer (second element type)
        Assertions.assertEquals(5,
                ListOps.length(VList.of(1, 2, 3, 4, 5)));
    }


    // 3. allEven
    @Test
    void testAllEven() {
        // Assignment example - true
        Assertions.assertTrue(
                ListOps.allEven(VList.of(-2, 0, 4)));

        // Empty
        Assertions.assertTrue(
                ListOps.allEven(VList.empty()));

        // Singleton - true
        Assertions.assertTrue(
                ListOps.allEven(VList.of(8)));

        // Singleton - false
        Assertions.assertFalse(
                ListOps.allEven(VList.of(3)));

        // Longer - true
        Assertions.assertTrue(
                ListOps.allEven(VList.of(2, 4, 6, 8, 10)));

        // Longer - false
        Assertions.assertFalse(
                ListOps.allEven(VList.of(2, 4, 7, 8, 10)));
    }


    // 4. incrementAll
    @Test
    void testIncrementAll() {
        VList<Integer> original = VList.of(-1, 0, 4);

        // Assignment example
        Assertions.assertEquals(
                VList.of(0, 1, 5),
                ListOps.incrementAll(original));

        // Empty
        Assertions.assertEquals(
                VList.empty(),
                ListOps.incrementAll(VList.empty()));

        // Singleton
        Assertions.assertEquals(
                VList.of(6),
                ListOps.incrementAll(VList.of(5)));

        // Longer
        Assertions.assertEquals(
                VList.of(2, 3, 4, 5, 6),
                ListOps.incrementAll(VList.of(1, 2, 3, 4, 5)));

        // Input unchanged
        Assertions.assertEquals(
                VList.of(-1, 0, 4),
                original);
    }


    // 5. keepEven
    @Test
    void testKeepEven() {
        VList<Integer> original = VList.of(-2, 3, 0, 4);

        // Assignment example
        Assertions.assertEquals(
                VList.of(-2, 0, 4),
                ListOps.keepEven(original));

        // Empty
        Assertions.assertEquals(
                VList.empty(),
                ListOps.keepEven(VList.empty()));

        // Singleton even
        Assertions.assertEquals(
                VList.of(4),
                ListOps.keepEven(VList.of(4)));

        // Singleton odd
        Assertions.assertEquals(
                VList.empty(),
                ListOps.keepEven(VList.of(3)));

        // Longer
        Assertions.assertEquals(
                VList.of(2, 4, 6),
                ListOps.keepEven(VList.of(1, 2, 3, 4, 5, 6)));

        // Input unchanged
        Assertions.assertEquals(
                VList.of(-2, 3, 0, 4),
                original);
    }


    // 6. isNondecreasing
    @Test
    void testIsNondecreasing() {
        VList<Integer> original = VList.of(-2, 0, 0, 4);

        // Assignment example - true
        Assertions.assertTrue(
                ListOps.isNondecreasing(original));

        // Empty
        Assertions.assertTrue(
                ListOps.isNondecreasing(VList.empty()));

        // Singleton
        Assertions.assertTrue(
                ListOps.isNondecreasing(VList.of(5)));

        // Longer - true
        Assertions.assertTrue(
                ListOps.isNondecreasing(
                        VList.of(1, 2, 3, 4, 5)));

        // Equal neighbors are allowed
        Assertions.assertTrue(
                ListOps.isNondecreasing(
                        VList.of(1, 2, 2, 3, 3)));

        // False outcome
        Assertions.assertFalse(
                ListOps.isNondecreasing(
                        VList.of(1, 3, 2, 4)));

        // Input unchanged
        Assertions.assertEquals(
                VList.of(-2, 0, 0, 4),
                original);
    }


    // 7. append
    @Test
    void testAppend() {
        VList<Integer> first = VList.of(1, 2);
        VList<Integer> second = VList.of(3, 4);

        // Assignment example
        Assertions.assertEquals(
                VList.of(1, 2, 3, 4),
                ListOps.append(first, second));

        // Empty first
        Assertions.assertEquals(
                VList.of(1, 2),
                ListOps.append(
                        VList.<Integer>empty(),
                        VList.of(1, 2)));

        // Empty second
        Assertions.assertEquals(
                VList.of(1, 2),
                ListOps.append(
                        VList.of(1, 2),
                        VList.<Integer>empty()));

        // Singleton
        Assertions.assertEquals(
                VList.of(1, 2),
                ListOps.append(
                        VList.of(1),
                        VList.of(2)));

        // Longer
        Assertions.assertEquals(
                VList.of(1, 2, 3, 4, 5, 6),
                ListOps.append(
                        VList.of(1, 2, 3),
                        VList.of(4, 5, 6)));

        // Second element type - String
        Assertions.assertEquals(
                VList.of("a", "b", "c", "d"),
                ListOps.append(
                        VList.of("a", "b"),
                        VList.of("c", "d")));

        // Inputs unchanged
        Assertions.assertEquals(
                VList.of(1, 2),
                first);

        Assertions.assertEquals(
                VList.of(3, 4),
                second);
    }


    // 8. dropLast
    @Test
    void testDropLast() {
        VList<Integer> original = VList.of(3, 4, 5);

        // Assignment example
        Assertions.assertEquals(
                VList.of(3, 4),
                ListOps.dropLast(original));

        // Empty
        Assertions.assertEquals(
                VList.empty(),
                ListOps.dropLast(VList.<Integer>empty()));

        // Singleton
        Assertions.assertEquals(
                VList.empty(),
                ListOps.dropLast(VList.of(5)));

        // Longer
        Assertions.assertEquals(
                VList.of(1, 2, 3, 4),
                ListOps.dropLast(
                        VList.of(1, 2, 3, 4, 5)));

        // Second element type - String
        Assertions.assertEquals(
                VList.of("a", "b"),
                ListOps.dropLast(
                        VList.of("a", "b", "c")));

        // Input unchanged
        Assertions.assertEquals(
                VList.of(3, 4, 5),
                original);
    }


    // 9. reverse
    @Test
    void testReverse() {
        VList<Integer> original = VList.of(1, 2, 3);

        // Assignment example
        Assertions.assertEquals(
                VList.of(3, 2, 1),
                ListOps.reverse(original));

        // Empty
        Assertions.assertEquals(
                VList.empty(),
                ListOps.reverse(VList.<Integer>empty()));

        // Singleton
        Assertions.assertEquals(
                VList.of(5),
                ListOps.reverse(VList.of(5)));

        // Longer
        Assertions.assertEquals(
                VList.of(5, 4, 3, 2, 1),
                ListOps.reverse(
                        VList.of(1, 2, 3, 4, 5)));

        // Second element type - String
        Assertions.assertEquals(
                VList.of("c", "b", "a"),
                ListOps.reverse(
                        VList.of("a", "b", "c")));

        // Input unchanged
        Assertions.assertEquals(
                VList.of(1, 2, 3),
                original);
    }


    // 10. collapseRuns
    @Test
    void testCollapseRuns() {
        VList<String> original =
                VList.of("a", "a", "b", "a", "a");

        // Assignment example
        Assertions.assertEquals(
                VList.of("a", "b", "a"),
                ListOps.collapseRuns(original));

        // Empty
        Assertions.assertEquals(
                VList.empty(),
                ListOps.collapseRuns(
                        VList.<String>empty()));

        // Singleton
        Assertions.assertEquals(
                VList.of("a"),
                ListOps.collapseRuns(
                        VList.of("a")));

        // Longer - one large run
        Assertions.assertEquals(
                VList.of("a"),
                ListOps.collapseRuns(
                        VList.of("a", "a", "a", "a", "a")));

        // Longer - multiple runs
        Assertions.assertEquals(
                VList.of("a", "b", "c"),
                ListOps.collapseRuns(
                        VList.of(
                                "a", "a",
                                "b", "b", "b",
                                "c", "c")));

        // Second element type - Integer
        Assertions.assertEquals(
                VList.of(1, 2, 3, 1),
                ListOps.collapseRuns(
                        VList.of(
                                1, 1,
                                2, 2, 2,
                                3,
                                1, 1)));

        // Input unchanged
        Assertions.assertEquals(
                VList.of("a", "a", "b", "a", "a"),
                original);
    }
}