package samples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    @Test(groups = {"unit"})
    public void firstTest(){
        System.out.println("Unit");
    }

    @Test(groups = {"web"})
    public void secondTest(){
        System.out.println("Web");
        Assert.assertEquals("2", "1");
    }

    @Test (groups = {"db"})
    public void thirdTest(){
        System.out.println("DB");
    }
}
