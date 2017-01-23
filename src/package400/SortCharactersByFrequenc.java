package package400;

import java.util.*;

/**
 * Created by jingshanyin on 1/6/17.
 * 451. Sort Characters by Frequency.
 * Given a string, sort it in decreasing order based on the frequency of characters.

 Example 1:

 Input:
 "tree"

 Output:
 "eert"

 Explanation:
 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 Example 2:

 Input:
 "cccaaa"

 Output:
 "cccaaa"

 Explanation:
 Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 Note that "cacaca" is incorrect, as the same characters must be together.
 Example 3:

 Input:
 "Aabb"

 Output:
 "bbAa"

 Explanation:
 "bbaA" is also a valid answer, but "Aabb" is incorrect.
 Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequenc {

    public String frequencySort(String s) {
        final int[] counts = new int[128];

        Character[] chars =new Character[s.length()];

        int index = 0;
        for (char c : s.toCharArray()) {
            counts[c]++;
            chars[index++] = c;
        }

        Arrays.sort(chars, new Comparator<Character>() {

            @Override
            public int compare(Character c1, Character c2) {
                if (c1.equals(c2)) return 0;
                else {
                    if(counts[c2] - counts[c1] != 0) {
                        return counts[c2] - counts[c1];
                    } else {
                        return c2 - c1;
                    }
                }

            }
        });
        StringBuilder sb = new StringBuilder();
        for (char ch: chars) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public String frequencySort2(String s) {
        char[] arr = s.toCharArray();

        // bucket sort
        int[] count = new int[256];
        for(char c : arr) count[c]++;

        // count values and their corresponding letters
        Map<Integer, List<Character>> map = new HashMap<>();
        for(int i = 0; i < 256; i++){
            if(count[i] == 0) continue;
            int cnt = count[i];
            if(!map.containsKey(cnt)){
                map.put(cnt, new ArrayList<Character>());
            }
            map.get(cnt).add((char)i);
        }

        // loop throught possible count values
        StringBuilder sb = new StringBuilder();
        for(int cnt = arr.length; cnt > 0; cnt--){
            if(!map.containsKey(cnt)) continue;
            List<Character> list = map.get(cnt);
            for(Character c: list){
                for(int i = 0; i < cnt; i++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
