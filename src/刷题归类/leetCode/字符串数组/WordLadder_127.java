package 刷题归类.leetCode.字符串数组;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 * <p>
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 */
public class WordLadder_127 {
    public static int ladderLength(String b, String e, List<String> wordList) {
        if (b.equals(e)) return 1;
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(e)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(b);
        dict.remove(b);

        int level = 2;

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                String tmp = q.poll();

                for (int j = 0; j < tmp.length(); j++) {
                    char[] chars = tmp.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String tmp2 = new String(chars);

                        if (tmp2.equals(e)) return level;

                        if (dict.remove(tmp2)) {
                            q.add(tmp2);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }

//    public static int ladderLength(String start, String end, List<String> wordList) {
//        Set<String> dict = new HashSet<>(wordList);
//        dict.remove(start);
//        if (!dict.contains(end)) return 0;
//        HashMap<String, Integer> disMap = new HashMap<>();
//        LinkedList<String> queue = new LinkedList<>();
//        queue.add(start);
//        disMap.put(start, 1);
//        while (!queue.isEmpty()) {
//            String word = queue.poll();
//            for (int i = 0; i < word.length(); i++) {
//                for (char ch = 'a'; ch <= 'z'; ch++) {
//                    StringBuilder sb = new StringBuilder(word);
//                    sb.setCharAt(i, ch);
//                    String nextWord = sb.toString();
//                    if (end.equals(nextWord))
//                        return disMap.get(word) + 1;
//                    if (dict.contains(nextWord) && !disMap.containsKey(nextWord)) {
//                        disMap.put(nextWord, disMap.get(word) + 1);
//                        queue.add(nextWord);
//                    }
//                }
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>();//"hot","dot","dog","lot","log"
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
       // list.add("cog");
        System.out.println(ladderLength(start, end, list));
    }
}
