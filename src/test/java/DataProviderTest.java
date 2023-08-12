import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertSame;


@RunWith(DataProviderRunner.class)
public class DataProviderTest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {1, 1, 2},
                {2, 2, 4},
                {2, 3, 5},
                {6, 5, 11}
        };
    }

    @DataProvider
    public static Object[][] sub_data() {
        return new Object[][]{
                {1, 1, 0},
                {3, 2, 1},
                {2, 3, -1},
                {16, 5, 11}
        };
    }


    @Test
    @UseDataProvider("data")
    public void test_sum(int v1, int v2, int expected_res) {
        Calculator c = new Calculator();
        assertSame(expected_res, c.sum(v1, v2));
    }

    @Test
    @UseDataProvider("sub_data")
    public void test_sub(int v1, int v2, int expected_res) {
        Calculator c = new Calculator();
        assertSame(expected_res, c.sub(v1, v2));
    }
}
