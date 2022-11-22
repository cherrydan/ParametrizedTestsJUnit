import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(DataProviderRunner.class)
public class DataProviderTest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {1, 1, 2},
                {2, 2, 4},
                {2, 3, 5}
        };
    }


    @Test
    @UseDataProvider("data")
    public void test_sum(int v1, int v2, int expected_res) {
        Calculator c = new Calculator();
        Assert.assertSame(expected_res, c.sum(v1, v2));
    }
}
