# Recursive Lists | Java

**HCDD 311: Object-Oriented Programming & Design — Assignment 4**

## Overview

This project explores recursive algorithms and immutable data structures in Java through the implementation of ten list-processing methods. Using the `VList` library, the project focuses on manipulating recursively defined lists without traditional loops or built-in collection methods.

The goal was to strengthen my understanding of recursion, generic programming, pattern matching, and functional programming principles while developing efficient and readable solutions to common list operations.

## Technologies Used

- **Java** — Object-oriented and functional programming
- **Maven** — Project management and build automation
- **JUnit** — Automated unit testing
- **VList** — Immutable, recursively defined list data structure
- **Recursion** — List traversal and manipulation
- **Generics** — Type-independent list operations
- **Pattern Matching** — Exhaustive switch expressions

## Features

The project implements ten recursive methods that perform various operations on immutable lists.

| Method | Description |
|---|---|
| `sum(xs)` | Calculates the sum of all integers in a list. |
| `length(xs)` | Counts the number of elements in a list of any type. |
| `allEven(xs)` | Determines whether every integer in a list is even. |
| `incrementAll(xs)` | Increments every integer by one while preserving order. |
| `keepEven(xs)` | Filters a list to retain only even integers. |
| `isNondecreasing(xs)` | Checks whether the elements are in nondecreasing order. |
| `append(first, second)` | Combines two lists while preserving their original order. |
| `dropLast(xs)` | Removes the final element of a list. |
| `reverse(xs)` | Reverses the order of elements in a list. |
| `collapseRuns(xs)` | Removes consecutive duplicate elements while preserving nonconsecutive duplicates. |

All operations use recursion and exhaustive pattern matching over the `VList.Empty` and `VList.Cons` cases.

## Example Usage

### Summing Elements

```java
VList<Integer> numbers = VList.of(3, -1, 5);

System.out.println(ListOps.sum(numbers));
// Output: 7
```

### Checking Even Numbers

```java
VList<Integer> numbers = VList.of(-2, 0, 4);

System.out.println(ListOps.allEven(numbers));
// Output: true
```

### Filtering Even Numbers

```java
VList<Integer> numbers = VList.of(-2, 3, 0, 4);

VList<Integer> evens = ListOps.keepEven(numbers);

System.out.println(evens);
// Output: [-2, 0, 4]
```

### Appending Lists

```java
VList<Integer> first = VList.of(1, 2);
VList<Integer> second = VList.of(3, 4);

VList<Integer> result = ListOps.append(first, second);

System.out.println(result);
// Output: [1, 2, 3, 4]
```

### Reversing a List

```java
VList<Integer> numbers = VList.of(1, 2, 3);

VList<Integer> reversed = ListOps.reverse(numbers);

System.out.println(reversed);
// Output: [3, 2, 1]
```

### Removing Consecutive Duplicates

```java
VList<String> letters = VList.of("a", "a", "b", "a", "a");

VList<String> result = ListOps.collapseRuns(letters);

System.out.println(result);
// Output: [a, b, a]
```

## Project Structure

```text
asg4/
├── pom.xml
├── src/
│   └── ListOps.java
└── test/
    └── ListOpsTest.java
```

- **ListOps.java** — Contains the ten recursive list-processing methods.
- **ListOpsTest.java** — Contains JUnit tests validating each method.
- **pom.xml** — Configures Maven dependencies and project settings.

## Implementation Approach

### Recursive List Processing

Each operation uses recursion to process a list by separating it into two cases:

1. **Base Case:** Handles an empty list or another terminating condition.
2. **Recursive Case:** Processes the current element and recursively handles the remainder of the list.

Exhaustive switch expressions ensure that both possible list structures are handled.

### Immutable Data Structures

The project follows immutability principles, meaning existing lists are never modified. Operations that transform lists instead construct new lists using `VList.cons()` and `VList.empty()`.

This approach supports predictable behavior and avoids unintended changes to the original data.

### Generic Programming

Several methods use Java generics to support lists containing different element types, including integers and strings.

Methods such as `length()`, `append()`, `dropLast()`, `reverse()`, and `collapseRuns()` operate independently of the list's element type.

## Testing

JUnit tests are used to verify the correctness of all ten methods.

Test cases cover:

- Empty, singleton, and multi-element lists
- Positive, negative, and zero values
- Generic operations on integers and strings
- True and false outcomes for boolean methods
- Correct element ordering after list transformations
- Consecutive and nonconsecutive duplicate values
- Preservation of original lists
- Edge cases involving lists of different lengths

To execute the tests, run:

```bash
mvn test
```

## Key Learning Outcomes

Through this project, I strengthened my understanding of:

- **Recursive Algorithms:** Designing solutions using base cases and recursive calls rather than iterative loops.
- **Immutable Data Structures:** Creating transformed lists without modifying existing data.
- **Pattern Matching:** Using exhaustive switch expressions to handle recursively defined list structures.
- **Generic Programming:** Developing reusable functions that support multiple data types.
- **Functional Programming:** Applying recursive transformations and filtering techniques.
- **Algorithmic Problem Solving:** Implementing increasingly complex operations such as reversing lists and collapsing consecutive duplicates.
- **Unit Testing:** Writing comprehensive JUnit tests to verify functionality and edge cases.

## Project Context

Developed as part of **HCDD 311 at Pennsylvania State University**, this assignment focused on building a stronger foundation in recursive programming, immutable data structures, and Java's modern language features.

The project also served as preparation for implementing custom recursive data structures in subsequent assignments.
