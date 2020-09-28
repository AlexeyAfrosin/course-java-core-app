package com.a.afrosin.course.java.core.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {
    Map<String, HashSet<String>> phoneBookItem = new HashMap<>();

    public HashSet<String> get(String fio) {
        return phoneBookItem.getOrDefault(fio, new HashSet<>());
    }

    public void add(String fio, String phone) {
        HashSet<String> phoneList =  this.phoneBookItem.getOrDefault(fio, new HashSet<>());
        phoneList.add(phone);
        this.phoneBookItem.put(fio, phoneList);
    }
}
