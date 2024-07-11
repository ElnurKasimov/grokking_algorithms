package search;

//  There are some my acquaintances.
//  The goal is to find the person who sells mango from them and their acquaintances.
//  The seller has to be the nearest to me.

import java.util.*;

public class BreadthFirstSearch {
    private static Map<String, Set<String>> acquaintances = new HashMap<>();


    static {
        acquaintances.put("me", Set.of("Abdulla", "Tanya", "Lena", "Pasha"));
        acquaintances.put("Abdulla", Set.of("Mahmud", "Vazir", "Muslim", "Ahmad"));
        acquaintances.put("Tanya", Set.of("Vita", "Alla"));
        acquaintances.put("Lena", Set.of("Sadovska", "Kadrovichka"));
        acquaintances.put("Pasha", new HashSet<>());
        acquaintances.put("Vita", Set.of("Andrey"));
        acquaintances.put("Alla", Set.of("Sergey"));
    }

    public static Queue<String> addIntoSearchQueueFirstAcquaintanceLevel(Set<String> names){
        return new LinkedList<>(names);
    }

    public static String findNearestMangoSeller(Queue<String> names) {
        return "";

    }


    public static void main(String[] args) {
        Queue<String> searchQueue = addIntoSearchQueueFirstAcquaintanceLevel(acquaintances.get("me"));



    }
}
