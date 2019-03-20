package samples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void firstTest(){
        System.out.println("Unit");
    }

    @Test
    public void secondTest(){
        System.out.println("Web");
        Assert.assertEquals("2", "1");
    }

    @Test
    public void thirdTest(){
        System.out.println("DB");
    }
}
