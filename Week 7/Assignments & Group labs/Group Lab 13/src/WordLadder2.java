// this second implementation dosen't use the classes preovided in class

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder2 {

    public static List<List<String>> findLadders(String beginWord, String endWord, HashSet<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashSet<String> unvisited = new HashSet<>();
        unvisited.addAll(wordList);

        LinkedList<Node> queue = new LinkedList<>();
        Node node = new Node(beginWord, 0, null);
        queue.offer(node);

        int minLen = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node top = queue.poll();

            // top if have shorter result already
            if (result.size() > 0 && top.depth > minLen) {
                return result;
            }
            // try to find a word adjacent to topword
            for (int i = 0; i < top.word.length(); i++) {
                char c = top.word.charAt(i);
                char[] arr = top.word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j == c) {
                        continue;
                    }
                    arr[i] = j;
                    String t = new String(arr);
                    // add to result if successfully find a path
                    if (t.equals(endWord)) {
                        // add to result
                        List<String> aResult = new ArrayList<>();
                        aResult.add(endWord);
                        Node p = top;
                        while (p != null) {
                            aResult.add(p.word);
                            p = p.prev;
                        }

                        Collections.reverse(aResult);
                        result.add(aResult);

                        // stop if get shorter result
                        if (top.depth <= minLen) {
                            minLen = top.depth;
                        } else {
                            return result;
                        }
                    }

                    if (unvisited.contains(t)) {
                        Node n = new Node(t, top.depth + 1, top);
                        queue.offer(n);
                        unvisited.remove(t); // prevent endless loop
                    }
                }
            }
        }

        return result;
    }
}

class Node {
    public String word;
    public int depth;
    public Node prev;

    public Node(String word, int depth, Node prev) {
        this.word = word;
        this.depth = depth;
        this.prev = prev;
    }


public static void main(String[] args) {
    String start = args[0];
    String end = args[1];
    HashSet<String> dict = new HashSet<String>();
    String wordlistfilename = "sowpods.txt";
    String[] wordlist = new In(wordlistfilename).readAllLines();
    for (String i : wordlist) {
        if (i.length() == 5) {
            dict.add(i);
        }
    }

    List<List<String>> result = new ArrayList<>();
    result = WordLadder2.findLadders(start, end, dict);
    System.out.println("start" + " = " + start + ", " + "end" + " = " + end);
    if (result.size() > 0) {
        System.out.print("the shortest path is: ");
        for (String i : result.get(0)) {
            System.out.print(i + " ");
        }
    } else {
        System.out.println("can not find a proper word ladder between " + start + " and " + end);
    }
    System.out.println();
    }
}