package self;

import java.util.*;

/**
 * Created by Jebeljing on 12/13/2016.
 * suppose you are on vacation somewhere and you bought a bunch of train tickets from some crappy website where each ticket is only from one place to another(there is no stop in between). I want you to implement a simple algorithm that can group the tickets into one itinerary if the train station are connected and give me the total number of itinerary you have on your vacation.
 for example,  a - c, d - b, c - d, e - f => a - c - d - b, e - f

 a - b - c - d - e - f


 a - c, c - d, e - f, d - g, g - h

 a - d, e -f


 c - d a - c  e - f

 a - d, e -f

 a,b
 */
public class TrainTickets {

    public static void main(String... args) {
        TrainTickets test = new TrainTickets();
        Map<Character, Character> tickets = new HashMap<>();
        tickets.put('d', 'g');
        tickets.put('z', 'c');
        tickets.put('c', 'd');
        tickets.put('e', 'f');
        tickets.put('g', 'h');
        tickets.put('i', 'j');
        tickets.put('t', 'k');
        tickets.put('h', 'i');
        tickets.put('j', 'l');

        System.out.println(test.getTickets(tickets));
        System.out.println(test.getTickets2(tickets));
        System.out.println(test.getTickets3(tickets));
    }

    //Wrong
    public Map<Character, Character> getTickets(Map<Character, Character> tickets) {
        if (tickets == null || tickets.size() < 2) {
            return tickets;
        }

        Set<Character> notVisited = new HashSet<>(tickets.keySet());

        Map<Character, Character> result = new HashMap<>();
        for (Character c: tickets.keySet()) {
            if(!notVisited.contains(c)) continue;
            notVisited.remove(c);
            Character dest = tickets.get(c);
            notVisited.remove(dest);

            if (!tickets.containsKey(dest)) {
                result.put(c, dest);
            }
            while (tickets.containsKey(dest)) {
                notVisited.remove(dest);
                notVisited.remove(tickets.get(dest));
                result.put(c, tickets.get(dest));
                dest = tickets.get(dest);
            }
        }
        return result;
    }

    //Correct one
    public int getTickets2(Map<Character, Character> tickets) {
        if (tickets == null || tickets.size() < 2) {
            return tickets == null ? 0: tickets.size();
        }

        Set<Character> starts = new HashSet<>(tickets.keySet());
        Set<Character> ends = new HashSet<>(tickets.values());
        int result = 0;
       for (Character key: starts) {
           if (!ends.contains(key)) result++;
       }
        return result;
    }

    //Correct one
    public Map<Character, Character> getTickets3(Map<Character, Character> tickets) {
        if (tickets == null || tickets.size() < 2) {
            return tickets;
        }

        Set<Character> notVisited = new HashSet<>(tickets.keySet());

        Map<Character, Character> result = new HashMap<>();
        for (Character c: tickets.keySet()) {
           if (tickets.containsKey(tickets.get(c))) {
               notVisited.remove(tickets.get(c));
           }
        }

        for (Character key: notVisited) {
            Character value = key;
            while(tickets.get(value) != null) {
                value = tickets.get(value);
            }
            result.put(key, value);
        }
        return result;
    }
}
