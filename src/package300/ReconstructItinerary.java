package package300;

import java.util.*;

/**
 * Created by jingshanyin on 1/5/17.
 * 332. Reconstruct Itinerary
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

 Note:
 If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.
 Example 1:
 tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 Example 2:
 tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class ReconstructItinerary {

    Map<String, List<String>> adjList = new HashMap<>();
    private LinkedList<String> route = new LinkedList<>();
    private int numTickets = 0;
    private int numTicketsUsed = 0;

    public List<String> findItinerary(String[][] tickets) {
        numTickets = tickets.length;
        for (String[] ticket: tickets) {
            if (!adjList.containsKey(ticket[0])) {
                List<String> list = new ArrayList<>();
                list.add(ticket[1]);
                adjList.put(ticket[0], list);
            } else {
                adjList.get(ticket[0]).add(ticket[1]);
            }
        }

        for (List<String> value: adjList.values()) {
            Collections.sort(value);
        }

        route.add("JFK");
        dfsRoute("JFK");

        return route;
    }

    private void dfsRoute(String v) {
        if (!adjList.containsKey(v)) return;
        List<String> list = adjList.get(v);
        for (int i = 0; i < list.size(); ++i) {
            String neighbor = list.get(i);
            // remove ticket(route) from graph
            list.remove(i);
            route.add(neighbor);
            numTicketsUsed++;
            dfsRoute(neighbor);
            // we only return when we have used all tickets
            if (numTickets == numTicketsUsed) return;
            // otherwise we need to revert the changes and try other tickets
            list.add(i, neighbor);
            // This line took me a long time to debug
            // we must remove the last airport, since in an itinerary, the same airport can appear many times!!
            route.removeLast();
            numTicketsUsed--;
        }
    }
}
