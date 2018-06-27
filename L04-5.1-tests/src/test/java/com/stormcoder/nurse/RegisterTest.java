package com.stormcoder.nurse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterTest {

    private Register register;

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
        register = new Register();
    }

    @Test
    public void absentObjectReturnsNull(){
        System.out.println("test1");
        Object something = register.get("absent");
        Assert.assertNull(something);

    }

    @Test
    public void canRegisterSomethingAndReceive(){
        System.out.println("test2");
        Object one = new Object();
        register.add("one", one);
        Object two = new Object();
        register.add("two", two);

        Object receivedOne = register.get("one");
        Object receivedTwo = register.get("two");

        assertNotNull(receivedOne);
        Assert.assertSame(one, receivedOne);
        Assert.assertSame(two, receivedTwo);
        Assert.assertNotSame(receivedOne, receivedTwo);
    }

    @Test
    public void canRegisterByTypeAndReceive(){
        System.out.println("test3");
        Glucose glucose = new Glucose();
        register.add(glucose);
        Water water = new Water();
        register.add(water);

        Glucose receivedGlucose = register.get(Glucose.class);
        Water receivedWater = register.get(Water.class);

        assertNotNull(receivedGlucose);
        Assert.assertSame(glucose, receivedGlucose);
        Assert.assertSame(water, receivedWater);
        Assert.assertNotSame(receivedGlucose, receivedWater);
    }

    @Test(expected = RuntimeException.class)
    public void secondRegisterOfSameNameTrowsException() {
        System.out.println("test4");
        register.add("same", new Object());
        register.add("same", new Object());
    }

    @Test
    public void patientShouldBeInjectedByGlucose() {
        System.out.println("test5");
        Glucose glucose = new Glucose();
        register.add(new Patient());
        register.add(glucose);
        register.inject();
        Patient patient = register.get(Patient.class);
        Glucose injectionGlucose = patient.getGlucose();
        assertNotNull(injectionGlucose);
        assertSame(glucose, injectionGlucose);
    }
}
