package search;

//  There are some my acquaintances.
//  The goal is to find the person who sells mango from them and their acquaintances.
//  The seller has to be the nearest to me.

import java.util.*;

public class BreadthFirstSearch {
    private static Map<String, Set<String>> acquaintances = new HashMap<>();
    private static Queue<String> searchQueue = new LinkedList<>();

    static {
        acquaintances.put("me", Set.of("Abdulla", "Tanya", "Lena", "Pasha"));
        acquaintances.put("Abdulla", Set.of("Mahmud", "Vazir", "Muslim", "Ahmad"));
        acquaintances.put("Tanya", Set.of("Vita", "Alla"));
        acquaintances.put("Lena", Set.of("Sadovska", "Kadrovichka"));
        acquaintances.put("Pasha", new HashSet<>());
        acquaintances.put("Vita", Set.of("Andrey"));
        acquaintances.put("Alla", Set.of("Sergiy"));
    }

    public static boolean isMangoSeller(String name){
        return name.charAt(name.length() - 2) == 'e';

    }

    public static String findNearestMangoSeller() {
        String nameToCheck;
        while(!searchQueue.isEmpty()) {
            nameToCheck = searchQueue.poll();
            if(isMangoSeller(nameToCheck)) {
                return "The nearest to you mango seller is " + nameToCheck;
            } else {
                Set<String> nameAcquaintances = acquaintances.get(nameToCheck);
                if(nameAcquaintances != null && !nameAcquaintances.isEmpty()) {
                    searchQueue.addAll(nameAcquaintances);
                }
            }
        }
        return "There is no mango seller between neither your acquaintances nor their acquaintances";
    }


    public static void main(String[] args) {
        searchQueue.addAll(acquaintances.get("me"));
        System.out.println(findNearestMangoSeller());
    }
}
