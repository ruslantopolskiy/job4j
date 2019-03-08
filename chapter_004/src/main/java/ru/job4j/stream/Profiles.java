package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect (List<Profile> list){
        return  list.stream().
                map(Profile::getAddress).
                collect(Collectors.toList());
    }

}
