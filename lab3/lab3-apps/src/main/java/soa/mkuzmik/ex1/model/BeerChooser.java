package soa.mkuzmik.ex1.model;

import com.google.common.collect.ImmutableSet;

import java.util.*;

public class BeerChooser {

    Map<BeerColor, Set<String>> colorBrandsMap;

    public BeerChooser() {
        colorBrandsMap = new HashMap<>();
        colorBrandsMap.put(BeerColor.PALE, ImmutableSet.of("Harnaś jasne pełne", "Żywiec klasyczne"));
        colorBrandsMap.put(BeerColor.AMBER, ImmutableSet.of("Miloslaw Marcowe"));
        colorBrandsMap.put(BeerColor.BROWN, ImmutableSet.of("Coś brązowego"));
        colorBrandsMap.put(BeerColor.DARK, ImmutableSet.of("Stout"));
    }

    public Set<String> getBrands(BeerColor color) {
        return colorBrandsMap.get(color);
    }


}
