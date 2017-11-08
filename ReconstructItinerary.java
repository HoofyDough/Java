import java.util.*;

class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
		HashMap<String,Queue<String>> map = new HashMap<>();

        List<String> itinerary = new ArrayList<>();
        itinerary.add("JFK");

        for(int i=0; i<tickets.length; i++) {
        	Queue<String> destinations = (map.get(tickets[i][0]) != null)
        		? map.get(tickets[i][0]) : new PriorityQueue<>();
        	destinations.add(tickets[i][1]);
        	map.put(tickets[i][0], destinations);
        }

        Queue<String> destinations = map.get("JFK");
        while(destinations != null) {
        	String nextDest = null;

        	if(destinations.size() > 1) {
        		System.out.println(destinations);
				for(Iterator<String> it = destinations.iterator(); it.hasNext();) {
					String curStr = it.next();
					if(map.get(curStr) != null) {
						nextDest = curStr;
						destinations.remove(curStr);
						break;
					}
				}
			} else {
				nextDest = destinations.poll();
			}

        	if(nextDest != null)
        		itinerary.add(nextDest);
        	destinations = map.get(nextDest);
        }

     //    Iterator it = map.entrySet().iterator();
	    // while (it.hasNext()) {
	    //     Map.Entry pair = (Map.Entry)it.next();
	    //     if(((PriorityQueue)pair.getValue()).size() > 0)
	    //     	return null;
     //    }

        return itinerary;
	}
}