package search;

//  There are some my acquaintances.
//  The goal is to find the person who sells mango from them and their acquaintances.
//  The seller has to be the nearest to me.

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BreadthFirstSearch {
    private static Map<String, Set<String>> acquaintances = new HashMap<>();
    private static Queue<String> searchQueue = new LinkedList<>();

    static {
        initializeAcquaintances();
        initializeQueue();
    }

    public static void initializeAcquaintances() {
        acquaintances.put("me", Set.of("Abdulla", "Tanya", "Lena", "Pasha"));
        acquaintances.put("Abdulla", Set.of("Mahmud", "Vazir", "Muslim", "Ahmad"));
        acquaintances.put("Tanya", Set.of("Vita", "Alla"));
        acquaintances.put("Lena", Set.of("Sadovska", "Kadrovichka"));
        acquaintances.put("Pasha", new HashSet<>());
        acquaintances.put("Vita", Set.of("Andrey"));
        acquaintances.put("Alla", Set.of("Sergiy"));
    }

    public static void initializeQueue() {
        searchQueue.clear();
        searchQueue.addAll(acquaintances.get("me"));
    }

    public static boolean isMangoSeller(String name, Predicate<String> condition){
        return condition.test(name);

    }

    public static String findNearestMangoSeller(Predicate<String> condition) {
        String nameToCheck;
        while(!searchQueue.isEmpty()) {
            nameToCheck = searchQueue.poll();
            if(isMangoSeller(nameToCheck, condition)) {
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
        System.out.println(findNearestMangoSeller((name) -> name.charAt(name.length() - 2) == 'y'));
    }
}
