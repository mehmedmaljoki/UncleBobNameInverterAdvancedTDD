package com.meski.accademy.nameInverter;

import org.junit.Test;

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

    private String invertName(String name) {
        if (name == null || name.length() <= 0) {
            return "";
        } else {
            String[] names = name.trim().split("\\s+");
            if (names.length == 1) {
                return names[0];
            } else {
                return String.format("%s, %s", names[1], names[0]);
            }
        }
    }





}
