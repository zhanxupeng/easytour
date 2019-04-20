package com.mr;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2019/2/27
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(test(Arrays.asList("A", "B", "C"), 2));
    }

    public static List<List<String>> test(List<String> list, int num) {
        if (num == 0) {
            return null;
        }
        List<List<String>> listList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            List<String> subList = new LinkedList<>();
            for (int j = i + 1; j < list.size(); j++) {
                if (j != i) {
                    subList.add(list.get(j));
                }
            }

            List<List<String>> childrenList = test(subList, num - 1);
            if (childrenList != null) {
                for (List<String> childrenItem : childrenList) {
                    List<String> parentList = new LinkedList<>();
                    parentList.add(list.get(i));
                    parentList.addAll(childrenItem);
                    listList.add(parentList);
                }
            } else {
                listList.add(Collections.singletonList(list.get(i)));
            }
        }
        return listList;
    }
}
