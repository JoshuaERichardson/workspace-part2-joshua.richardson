package com.crunch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        radishes.add(new Radish("red", 1.1, 2.1, 0));
        radishes.add(new Radish("pink", 3.5, 0.0, 3));
        radishes.add(new Radish("black", 2.2, 4.5, 0));
        radishes.add(new Radish("white", 1.8, 0.6, 7));

        dump(radishes);



//        Sort by natural order:
        radishes.sort(null);  // Passing null means natural order!
        dump(radishes);
        System.out.println("\n");

//        Sort by color, via an instance of RadishColorComparator
        radishes.sort(new Radish.RadishColorComparator());

        dump(radishes);


        System.out.println("Sort by tailLength, via anonymous class");
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish o1, Radish o2) {
                return Double.compare(o1.getTailLength(),o2.getTailLength());
            }
        });
        dump(radishes);
    }

    private static void dump(List<Radish> radishList){
        radishList.forEach(System.out::println);
    }
}