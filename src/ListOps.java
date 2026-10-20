import io.github.dt.VList;

public class ListOps {

    // todo: Sum the elements; return 0 for an empty list.
    static int sum(VList<Integer> xs) {
        return switch (xs) {
            // base case
            case VList.Empty<Integer> ignored -> 0;
            // recursive case
            case VList.Cons<Integer>(var head, var tail) -> head + sum(tail);
        };
    }

    // todo: Count elements, for any element type.
    static <A> int length(VList<A> xs) {
        return switch (xs) {
            // base case
            case VList.Empty<A> ignored -> 0;
            // recursive
            case VList.Cons<A>(var head, var tail) ->
                1 + length(tail);
        };
    }

    // todo: Return true if every element is even, including for an empty list.
    static boolean allEven(VList<Integer> xs) {
        return switch (xs) {
            // base
            case VList.Empty<Integer> ignored -> true;
            // recursive
            case VList.Cons<Integer>(var head, var tail) -> head % 2 == 0 && allEven(tail);
        };
    }

    // todo: Add 1 to every element, preserving order.
    static VList<Integer> incrementAll(VList<Integer> xs) {
        return switch (xs) {
            // base case
            case VList.Empty<Integer> ignored -> VList.empty();
            // recursive
            case VList.Cons<Integer>(var head, var tail) ->
                VList.cons(head + 1, incrementAll(tail));
        };
    }

    // todo: Keep only even elements, preserving order. Zero and negative even values count.
    static VList<Integer> keepEven(VList<Integer> xs) {
        return switch (xs) {
            // base case
            case VList.Empty<Integer> ignored -> VList.empty();
            // recursive
            case VList.Cons<Integer>(var head, var tail) -> {
                // check if head is even
                if ((head % 2) == 0) {
                    yield VList.cons(head, keepEven(tail));
                }
                else {
                    yield keepEven(tail);
                }
            }
        };
    }

    // todo: Return true if each element is at most the next. Empty and singleton lists return true; match the tail to compare neighbors.
//       isNondecreasing(VList.of(-2, 0, 0, 4)) --> true
    static boolean isNondecreasing(VList<Integer> xs) {
        return switch (xs) {
            // base case
            case VList.Empty<Integer> ignored -> true;
            // recursive
            case VList.Cons<Integer>(var head, var tail) ->
                switch (tail) {
                    // base
                    case VList.Empty<Integer> ignored -> true;
                    // recursive
                    case VList.Cons<Integer>(var next, var rest) ->
                        head <= next && isNondecreasing(tail);
                };
        };
    }

    // todo: Return first followed by second. Recurse over first; when it is empty, return second. Draw or describe which nodes are rebuilt and which list is shared.
//       append(VList.of(1, 2), VList.of(3, 4)) --> [1, 2, 3, 4]
    static <A> VList<A> append(VList<A> first, VList<A> second) {
        return switch (first) {
            // base
            case VList.Empty<A> ignored -> second;
            // recursive
            case VList.Cons<A>(var head, var tail) ->
                VList.cons(head, append(tail, second));
        };
    }

    // todo: Return all but the final element. Empty and singleton inputs return empty.
//       dropLast(VList.of(3, 4, 5)) --> [3, 4]
    static <A> VList<A> dropLast(VList<A> xs) {
        return switch (xs) {
            // base
            case VList.Empty<A> ignored -> VList.empty();

            // recursive
            case VList.Cons<A>(var head, var tail) ->
                    switch (tail) {
                        // base
                        case VList.Empty<A> ignored -> VList.empty();

                        // recursive
                        case VList.Cons<A>(var next, var rest) ->
                                VList.cons(head, dropLast(tail));
                    };
        };
    }

    // todo: Reverse the order. You may use your own append method.
    static <A> VList<A> reverse(VList<A> xs) {
        return switch (xs) {
            // base
            case VList.Empty<A> ignored -> VList.empty();
            // recursive
            case VList.Cons<A>(var head, var tail) ->
                    append(reverse(tail), VList.cons(head, VList.empty()));
        };
    }

    // todo: Keep one value from each run of equal neighbors. Match the tail and compare with head.equals(next).
//       collapseRuns(VList.of("a", "a", "b", "a", "a")) --> ["a", "b", "a"]
    static <A> VList<A> collapseRuns(VList<A> xs) {
        return switch (xs) {
            case VList.Empty<A> ignored -> VList.empty();

            case VList.Cons<A>(var head, var tail) ->
                    switch (tail) {
                        case VList.Empty<A> ignored-> VList.cons(head, VList.empty());

                        case VList.Cons<A>(var next, var rest) -> {
                            if (head.equals(next)) {
                                yield collapseRuns(tail);
                            } else {
                                yield VList.cons(head, collapseRuns(tail));
                            }
                        }
                    };
        };
    }
}
