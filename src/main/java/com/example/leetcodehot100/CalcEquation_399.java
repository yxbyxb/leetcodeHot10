package com.example.leetcodehot100;

import java.util.*;

public class CalcEquation_399 {
    private double currentDouble = 1;
    Map<Map.Entry<String, String>, Double> valuesMap;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, List<String>> map = new HashMap<>();
        valuesMap = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> strings = equations.get(i);
            String a = strings.get(0);
            String b = strings.get(1);
            List<String> aList = map.getOrDefault(a, new ArrayList<>());
            List<String> bList = map.getOrDefault(b, new ArrayList<>());
            aList.add(b);
            bList.add(a);
            map.put(a,aList);
            map.put(b,bList);
            valuesMap.put(Map.entry(a, b), values[i]);
            valuesMap.put(Map.entry(b, a), 1 / values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> strings = queries.get(i);
            String a = strings.get(0);
            String b = strings.get(1);
            Map.Entry<String, String> entry = Map.entry(a, b);
            if (!map.containsKey(a) || !map.containsKey(b)) {
                result[i] = -1.0;
            }else if (a.equals(b)) {
                result[i] = 1;
            }else if (valuesMap.containsKey(entry)) {
                result[i] = valuesMap.get(entry);
            }else {
                this.currentDouble = 1;
                boolean b1 = canReach(map, a, b);
                if (b1) {
                    result[i] = this.currentDouble;
                }else {
                    result[i] = -1.0;
                }
            }
        }
        return result;
    }

    private boolean canReach(Map<String, List<String>> map, String begin, String end) {
        return flashBack(map, end, begin, new HashSet<>());
    }

    private boolean flashBack(Map<String, List<String>> map, String end, String curr, Set<String> appeared) {
        List<String> strings = map.get(curr);
        if (!appeared.add(curr)) {
            return false;
        }
        if (curr.equals(end)) {
            return true;
        }

        for (int i = 0; i < strings.size(); i++) {
            Double aDouble = this.valuesMap.get(Map.entry(curr, strings.get(i)));
            this.currentDouble *= aDouble;
            if (flashBack(map, end, strings.get(i), appeared)) {
                return true;
            } else {
            }
            this.currentDouble /= aDouble;
        }
        appeared.remove(curr);
        return false;
    }
}
