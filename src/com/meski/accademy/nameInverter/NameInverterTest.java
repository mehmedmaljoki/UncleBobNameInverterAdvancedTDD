package com.meski.accademy.nameInverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameInverterTest extends NameInverter {
    private NameInverter nameInverter;

    @Before
    public void setup() {
        nameInverter = new NameInverter();
    }

    @Test
    public void givenNull_returnEmptyString() throws Exception {
       assertInverted(null, "");
    }

    private void assertInverted(String originalName, String invertedName) {
        assertEquals(invertedName, nameInverter.invertName(originalName));
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
        assertInverted("First Last BS. PhD.", "Last, First BS. PhD.");
    }

    @Test
    public void integration() throws Exception {
        assertInverted("   Mehmed   Maljoki    BS.    PhD.", "Maljoki, Mehmed BS. PhD.");
    }

}
