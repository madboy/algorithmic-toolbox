# Testing techniques

In the previous section, we've already done some testing and fixed some mistakes. In general, you should test your problem on the following groups of tests before submitting:

1. A few small manual tests.
1. A test for each possible type of answer (smallest answer, biggest answer, answer doesn't exist, etc.)
1. Test for time/memory limit: generate a test with the largest possible size of input ("max test"), run your program, measure time and memory consumption.

## Tests for corner cases:
1. Smallest possible "n": the length of the input sequence or string, the number of queries, etc.
1. Equal numbers, equal letters in the string, more generally, equal objects in the input. Any two objects that are not restricted to be different in the problem statement can be equal.
1. Largest numbers in the input allowed by the problem statement - for example, to test for integer overflow.
1. Degenerate cases like empty set, three points on one line, a tree which consists of just one chain of nodes.