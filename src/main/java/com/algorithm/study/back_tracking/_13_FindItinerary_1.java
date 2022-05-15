package com.algorithm.study.back_tracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 332. 重新安排行程
 * 回溯
 */
public class _13_FindItinerary_1 {

    // 出发机场 -> <到达机场，(出发与到达机场)相同的航班次数>
    Map<String, Map<String, Integer>> map = new HashMap<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //初始化
        for (List<String> ticket : tickets) {
            String depart = ticket.get(0);
            String arrive = ticket.get(1);
            Map<String, Integer> departMap;
            if (map.containsKey(depart)) {
                departMap = map.get(depart);
                departMap.put(arrive, departMap.getOrDefault(arrive, 0) + 1);
            } else {
                //升序map
                departMap = new TreeMap<>();
                departMap.put(arrive, 1);
                map.put(depart, departMap);
            }
        }

        path.add("JFK");
        backtracking(tickets.size());
        return path;
    }

    private boolean backtracking(int size) {
        if (path.size() == size + 1) {
            return true;
        }

        String last = path.getLast();
        Map<String, Integer> departMap = map.get(last);
        if (departMap != null) {
            for (Map.Entry<String, Integer> entry : departMap.entrySet()) {
                String arrive = entry.getKey();
                Integer count = entry.getValue();
                if (count > 0) {
                    path.add(arrive);
                    entry.setValue(count - 1);
                    if (backtracking(size)) {
                        return true;
                    }
                    entry.setValue(count);
                    path.removeLast();
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new LinkedList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));

        System.out.println(new _13_FindItinerary_1().findItinerary(tickets));
    }
}
