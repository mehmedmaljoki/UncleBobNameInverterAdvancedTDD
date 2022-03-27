package com.meski.accademy;

import org.junit.*;

public class TransientFreshTest {
    public TransientFreshTest() {
        System.out.println("construct");
    }

    @Before
    public void setup() {
        System.out.println("setup");
//        System.out.println("Das setup wird vor jedem Test aufgeführt" +
//                "Hier fügen wir sachen rein, wir wir für die Tests brauchen");
    }

    @BeforeClass
    public static void suiteSetup() {
        System.out.println("suite setup");
//        System.out.println("Wird einmal und nicht vor jedem Test ausgeführt");
//        System.out.println("Versuche es ganz zu vermeiden");
    }

    @After
    public void teardown() {
        System.out.println("teardown");
//        System.out.println("Wird immer nach jedem Test aufgeführt" +
//                "Dient dazu da um aufzuräumen nach dem Test, wenn man etwas braucht" +
//                "Hier räumt man zB wie in C auf Files, Sockets, Semaphoren, Grapic Context, " +
//                "Database Connection");
//        System.out.println("Aber es ist besser Database Connection mit BeforeClass und Afterklass");
//        System.out.println("Verwende es so wenig wie möglich");
    }

    @AfterClass
    public static void suiteTearDown() {
        System.out.println("suite teardown");
//        System.out.println("wird nur einmal und nicht nach jedem Tests ausgeführt");
//        System.out.println("versuche es ganz zu vermeiden");
    }

    @Test
    public void test1() throws Exception {
        System.out.println("test1");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("test2");
    }
}
