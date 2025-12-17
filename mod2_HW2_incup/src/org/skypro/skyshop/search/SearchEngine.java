package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> treeSet = new TreeSet<>(new SortedSearchableComparator());

    public void addSearchable(Searchable search){
        treeSet.add(search);
    }

    public Set<Searchable> findSearchableObj(String search) {
        Set<Searchable> setFind;

        setFind = treeSet.stream()
                .filter(Objects::nonNull)
                .filter(el -> el.getText().contains(search))
                .collect(Collectors.toCollection(()->new TreeSet<>(new SortedSearchableComparator())));

        return setFind;
    }
}
