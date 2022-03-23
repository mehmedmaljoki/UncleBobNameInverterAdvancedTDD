package com.meski.accademy.nameInverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameInverter {

    String invertName(String name) {
        if (name == null || name.length() <= 0) {
            return "";
        } else {
            return formatName(removeHonorifics(splitNames(name)));
        }
    }

    private String formatName(List<String> names) {
        if (names.size() == 1) {
            return names.get(0);
        } else {
            return formatMultiElementName(names);
        }
    }

    private String formatMultiElementName(List<String> names) {
        String postNominal = getPostNominals(names);
        String firstName = names.get(0);
        String lastName = names.get(1);
        return String.format("%s, %s %s", lastName, firstName, postNominal).trim();
    }

    private String getPostNominals(List<String> names) {
        String postNominal = "";
        if (names.size() > 2) {
            List<String> postNominals = names.subList(2, names.size());
            for (String pn : postNominals) {
                postNominal += pn + " ";
            }
        }
        return postNominal;
    }

    private List<String> removeHonorifics(List<String> names) {
        if (names.size() > 1 && isHonorific(names.get(0))) {
            names.remove(0);
        }
        return names;
    }

    private boolean isHonorific(String word) {
        return word.matches("Mr\\.|Mrs\\.");
    }

    private ArrayList splitNames(String name) {
        return new ArrayList(Arrays.asList(name.trim().split("\\s+")));
    }
}
