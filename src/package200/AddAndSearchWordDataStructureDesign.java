package package200;

/**
 * Created by Jebeljing on 12/22/2016.
 * 211. Add and Search Word - Data structure design
 *  Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)

 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true

 Note:
 You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWordDataStructureDesign {


}

class WordDictionary {

    class TrieNode {
        boolean isWord = false;
        TrieNode[]  children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    //Adds a word into the data structure
    public void addWOrd(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could contains the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(word.toCharArray(), 0, TrieNode root)
    }

    private boolean helper(char[] chars, int index, TrieNode root) {
        if (index == chars.length) return root.isWord;
        if (chars[index] != '.') {
            if (root.children[chars[index] - 'a'] == null) {
                return false;
            } else {
                return helper(chars, index + 1, root.children[chars[index] - 'a']);
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    if (helper(chars, index + 1, root.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // Your WordDictionary object will be instantiated and called as such:
    // WordDictionary wordDictionary = new WordDictionary();
    // wordDictionary.addWord("word");
    // wordDictionary.search("pattern");
}
