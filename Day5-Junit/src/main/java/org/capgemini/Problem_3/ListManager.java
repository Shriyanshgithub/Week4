package org.capgemini.Problem_3;

import java.util.List;

public class ListManager {

    public void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element);
        }
    }

    public boolean removeElement(List<Integer> list, int element) {
        if (list != null) {
            return list.remove(Integer.valueOf(element)); // Removes the first occurrence
        }
        return false;
    }

    public int getSize(List<Integer> list) {
        return (list != null) ? list.size() : 0;
    }
}
