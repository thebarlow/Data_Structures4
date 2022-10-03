READ ME

Included Files:
1. Written.pdf
2. SpellChecker.java
a. Command line arguments are words.txt, filetospellcheck.txt in that order
3. Ktester.java
a. I just used the one posted on courseworks. This is the tester for KBestCounter.java
4. KBestCounter.java
5. Filetospellcheck.txt
a. ÒOne dark day in the middle of the nightÓ
6. words.txt


For all .java
1. Compile with javac ÐXlint filename.java
2. Run with java filename

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
Written (35 pts)

For the written section of this assignment, type up your answers and submit a computer based document to us. You can submit pdf files, or txt files.

(7 pts): Weiss, Exercise 5.1 - it is possible that some of the numbers in parts of the problems will not be insertable into the table.  Indicate when a number cannot be inserted in your answer. 
(7 pts): Weiss, Exercise 5.2 - You are rehashing each table that you built in the four parts of exercise 5.1. Use a new table size of 19, adjust the hash function accordingly.  Note one: you do not need to change the h2 function from part d, just the main function.  Note two: in 5.1 there will be at least one number that cannot be inserted. In this problem insert that number after you've rehashed you've rehashed the rest of them.
(7 pts): Weiss, Exercise 6.2 (show the contents of the heap after each step either as a tree or in binary heap array format)
(7 pts): Weiss, Exercise 6.3 - use the heap from part a in 6.2. (again, show the contents of the heap after each step either as a tree or binary heap array format)
(7 pts): Weiss Exercise 6.8 (just an explanation is good enough)

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
Programming (65 pts) [full credit]

For the programming portion of the assignment, please submit only your .java files and your README.txt.  Your code should be well commented.  In addition please include a detailed README.txt file which indicates exactly what files you are submitting, what problem they solve, and how to compile and run them.

(35 points) Based on Weiss Exercise 5.21 - implement this problem as described with the exception of the secondary dictionary.  Your program, called SpellChecker.java should take two command line arguments (that is via the args variable in main): (1) the name of a dictionary file (here is a sample: words.txtDownload words.txt), and (2) the name of the file that contains the text you wish to spellcheck. Submit some sample text with your solution.

Your program should be case insensitive (so you can toLower everything). Numbers and contractions are valid input, don't strip them out or treat them any differently than a regular word. Only strip leading and trailing punctuation, do not worry about ' characters at the end of a possessive plural; just remove them.

Note that each of the suggestion rules should be applied independently and in the first rule (add character) you need to try the characters a-z and the ', you do not need to add numbers.

You may use the java HashSet, HashMap, or HashTable to implement this program; but it must use some kind of hash table.

An announcement has been posted that covers frequently asked questions about punctuation handling, you can find it here on canvas, or as piazza @558.
(30 points) Finding the k-largest values in a set of data - Assume you are given a sequence of values. We do not know how many elements there are in this sequence. In fact, there could be infinitely many. Implement the class
KBestCounter<T extends Comparable<? super T>> that keeps track of the k-largest elements seen so far in a set of data. The class should have two methods:
public void count(T x) - process the next element in the set of data. This operation should run in the at worst O(log k) time.
public List<T> kbest() - return a sorted (largest to smallest) list of the klargest elements. This should run in O(k log k) time. The method should restore the priority queue to its original state after retrieving the k largest elements. If you run this method twice in a row, it should return the same values.
Use a Priority Queue to implement this functionality. We suggest using the built-in java.util.PriorityQueue, which implements a min-heap for you. You should never have more than k elements inserted into the Priority Queue at any given time.

An example illustrates how KBestCounter could be used in this attached tester class: TestKBest.javaDownload TestKBest.java.  We also include a skeleton for the KBestCounter class in the following file: KBestCounter.javaDownload KBestCounter.java.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
Grade: 87 (100 pts possible)
Graded Anonymously: no
Comments:
Late (TRUE/FALSE):FALSE, W1 (7):7, W2 (7):1.6, W3 (7):3.5, W4 (7):4, W5 (7):5, P1 (35):35, P2 (30):30, Comments:W2: -5.4 incorrect table size, incorrect across all four tables W5: -2 (b) the tree doesn't have to be perfect, it can be just complete W4: -3 no intermediate heaps shown W3: -3.5 Part b missing, Total (100):86.1
Mert Ussakli, Dec 8, 2017 at 4:06pm
Late (TRUE/FALSE):FALSE, W1 (7):7, W2 (7):1.6, W3 (7):3.5, W4 (7):4, W5 (7):5, P1 (35):35, P2 (30):30, Comments:W2: -5.4 incorrect table size, incorrect across all four tables W5: -2 (b) the tree doesn't have to be perfect, it can be just complete W4: -3 no intermediate heaps shown W3: -3.5 Part b missing, Total (100):86.1
Mert Ussakli, Dec 8, 2017 at 4:45pm
Late (TRUE/FALSE):FALSE, W1 (7):7, W2 (7):1.6, W3 (7):3.5, W4 (7):4, W5 (7):5, P1 (35):35, P2 (30):30, Comments:W2: -5.4 incorrect table size, incorrect across all four tables W5: -2 (b) the tree doesn't have to be perfect, it can be just complete W4: -3 no intermediate heaps shown W3: -3.5 Part b missing, Total (100):86.1
Mert Ussakli, Dec 8, 2017 at 4:46pm
Late (TRUE/FALSE):FALSE, W1 (7):7, W2 (7):1.6, W3 (7):3.5, W4 (7):4, W5 (7):5, P1 (35):35, P2 (30):30, Comments:W2: -5.4 incorrect table size, incorrect across all four tables W5: -2 (b) the tree doesn't have to be perfect, it can be just complete W4: -3 no intermediate heaps shown W3: -3.5 Part b missing, Total (100):86.1
Mert Ussakli, Dec 8, 2017 at 4:49pm
Late (TRUE/FALSE):FALSE, W1 (7):7, W2 (7):1.6, W3 (7):3.5, W4 (7):4, W5 (7):5, P1 (35):35, P2 (30):30, Comments:W2: -5.4 incorrect table size, incorrect across all four tables W5: -2 (b) the tree doesn't have to be perfect, it can be just complete W4: -3 no intermediate heaps shown W3: -3.5 Part b missing, Total (100):87
