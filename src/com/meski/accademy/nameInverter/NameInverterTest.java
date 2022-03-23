package com.meski.accademy.nameInverter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NameInverterTest {
    @Test
    public void givenNull_returnEmptyString() throws Exception {
       assertInverted(null, "");
    }

    private void assertInverted(String originalName, String invertedName) {
        assertEquals(invertedName, invertName(originalName));
    }

    @Test
    public void givenEmptyString_returnEmptyString() throws Exception {
        assertInverted("", "");
    }

    @Test
    public void givenSimpleName_returnEmptyString() throws Exception {
        assertInverted("Name", "Name");
    }

    @Test
    public void givenASimpleNameWithSpaces_returnSimpleNameWithoutSpaces() throws Exception {
        assertInverted(" Name ", "Name");
    }

    @Test
    public void givenFirstLast_returnLastFirst() throws Exception {
        assertInverted("First Last", "Last, First");
    }

    @Test
    public void givenFirstLastWithExtraSpaces_returnLastFirst() throws Exception {
        assertInverted("   First  Last", "Last, First");
    }

    @Test
    public void ignoreHonorific() throws Exception {
        assertInverted("Mr. First Last", "Last, First");
        assertInverted("Mrs. First Last", "Last, First");
    }

    @Test
    public void postNominals_stayAtEnd() throws Exception {
        assertInverted("First Last Sr.", "Last, First Sr.");
    }

    private String invertName(String name) {
        if (name == null || name.length() <= 0) {
            return "";
        } else {
            List<String> names = splitNames(name);
            if (names.size() > 1 && isHonorific(names.get(0))) {
                names.remove(0);
            }
            if (names.size() == 1) {
                return names.get(0);
            } else {
                String postNominal = "";
                if (names.size() > 2) {
                    postNominal = names.get(2);
                }
                return String.format("%s, %s %s", names.get(1), names.get(0), postNominal).trim();
            }
        }
    }

    private boolean isHonorific(String word) {
        return word.matches("Mr\\.|Mrs\\.");
    }

    private ArrayList splitNames(String name) {
        return new ArrayList(Arrays.asList(name.trim().split("\\s+")));
    }


}
