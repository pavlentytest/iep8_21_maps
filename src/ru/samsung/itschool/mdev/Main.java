package ru.samsung.itschool.mdev;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Object object = new Object();
        System.out.println(object.hashCode());


	    HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("apple","Fruit");
        hashMap.put("apple","Fruit");
        hashMap.put("apple","DDDD");
        hashMap.put("lemon","Fruit");
        hashMap.put("orange","Fruit");
        hashMap.put("tomato","Veget");

        for(Map.Entry<String,String> m: hashMap.entrySet()) {
            System.out.println(m.getKey() + "=> "+ m.getValue());
        }

        // hashMap.containsKey()
        // hashMap.containsValue()
        // hashMap.get("lemon")

        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(66,"Ivan");
        treeMap.put(66,"Ivan");
        treeMap.put(66,"Ivan");
        treeMap.put(667,"Petr");
        treeMap.put(1,"Olga");
        treeMap.put(7,"Maria");

        for(Map.Entry<Integer,String> m: treeMap.entrySet()) {
            System.out.println(m.getKey() + "=> "+ m.getValue());
        }

        TreeMap<String, String> pets = new TreeMap<>();
        pets.put("Bobik","Ivan");
        pets.put("Reks","Maxim");
        pets.put("AAA","BBBB");
        pets.put("ZZZ","NNNN");

        TreeMap <String, String> mondayPets = new TreeMap<>();
        for(Map.Entry<String,String> m: pets.entrySet()) {
            if(m.getKey().charAt(0) >= 'A' &&
                    m.getKey().charAt(0) <= 'H') {
                mondayPets.put(m.getKey(),m.getValue());
            }
        }
        //mondayPets.subMap("A","H").clear();

        TreeMap<String, TreeMap<String,Integer>> shop = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String[] word = scanner.nextLine().split(" ");
            // 0 - Ivanov
            // 1 - paper
            // 2 - 10
            if(shop.containsKey(word[0])) {
                TreeMap<String,Integer> user = shop.get(word[0]);
                if(user.containsKey(word[1])) {
                    user.put(word[1],Integer.parseInt(word[2])+user.get(word[1]));
                } else {
                    user.put(word[1],Integer.parseInt(word[2]));
                }
            } else {
                TreeMap<String,Integer> good = new TreeMap<>();
                good.put(word[1],Integer.parseInt(word[2]));
                shop.put(word[0],good);
            }
        }

        for(Map.Entry e: shop.entrySet()) {
            System.out.println(e.getKey() + ": ");
            TreeMap<String,Integer> user = (TreeMap) e.getValue();
            for(Map.Entry e1: user.entrySet()) {
                System.out.println(e1.getKey() + " " + e1.getValue());
            }
        }



    }
}
