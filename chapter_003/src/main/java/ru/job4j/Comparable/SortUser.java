package ru.job4j.Comparable;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });

        return new ArrayList<>(list);
    }

    public List<User> sortByAllFields (List<User> list){
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result =  Integer.parseInt(o1.getName()) -  Integer.parseInt(o2.getName());
 /*               if (result == 0){
                    result = o1.getAge()-(o2.getAge());
                }*/
                return result;
            }
        });
        return list;
    }
}
