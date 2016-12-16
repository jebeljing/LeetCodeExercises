package package100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by jingshanyin on 12/15/16.
 * 127. Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        //Use queue to do BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int idx = 0; idx < size; idx++) {
                String elem = queue.poll();
                for (int i = 0; i < elem.length(); i++) {
                    char[] chars = elem.toCharArray();
                    for (char c = 'a'; c <='z'; c++) {
                        chars[i] = c;
                        String tempStr = new String(chars);

                        if (tempStr.equals(endWord)) return length + 1;
                        if (wordList.contains(tempStr) &&
                                !visited.contains(tempStr)) {
                            visited.add(tempStr);
                            queue.offer(tempStr);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
}
