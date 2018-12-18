package ru.job4j.search;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            result.put(Integer.parseInt(user.getId()), user);
        }
        return result;
    }
}
