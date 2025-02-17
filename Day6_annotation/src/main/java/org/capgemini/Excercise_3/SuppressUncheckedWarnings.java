package org.capgemini.Excercise_3;

import java.util.ArrayList;

public class SuppressUncheckedWarnings {
    //Suppress Unchecked Warnings annotation
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {
        //create arrayList with rawType
        ArrayList arrayList = new ArrayList();

        arrayList.add("name");
        arrayList.add(23);
    }
}
