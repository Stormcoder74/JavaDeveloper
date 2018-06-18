import com.stormcoder.nurse.Register;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest {

    private Register register;

    @Before
    public void setUp() throws Exception {
        register = new Register();
    }

    @Test
    public void absentObjectReturnsNull(){
        Object something = register.get("absent");
        Assert.assertNull(something);

    }

    @Test
    public void canRegisterSomethingAndReceive(){
        Object one = new Object();
        register.add("one", one);
        Object two = new Object();
        register.add("two", two);

        Object receivedOne = register.get("one");
        Object receivedTwo = register.get("two");

        Assert.assertNotNull(receivedOne);
        Assert.assertSame(one, receivedOne);
        Assert.assertSame(two, receivedTwo);
        Assert.assertNotSame(receivedOne, receivedTwo);
    }

    @Test
    public void canRegisterByTypeAndReceive(){
        Glucose glucose = new Glucose();
        register.add(glucose);
        Water water = new Water();
        register.add(water);

        Glucose receivedGlucose = register.get(Glucose.class);
        Water receivedWater = register.get(Water.class);

        Assert.assertNotNull(receivedGlucose);
        Assert.assertSame(glucose, receivedGlucose);
        Assert.assertSame(water, receivedWater);
        Assert.assertNotSame(receivedGlucose, receivedWater);
    }
}
