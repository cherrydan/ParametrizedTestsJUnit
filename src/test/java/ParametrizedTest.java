import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class ParametrizedTest {

    private final int v1; //первая переменная на вход методу sum
    private final int v2; //вторая переменная на вход
    private final int expected_res; //ожидаемый результат

    public ParametrizedTest(int v1, int v2, int expected_res) {
        this.v1 = v1;
        this.v2 = v2;
        this.expected_res = expected_res;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                        {1,1, 2},
                        {2, 2, 4},
                        {2, 3, 5}
        }
                );
    }

    @Test
    public void test_sum() {
        Calculator c = new Calculator();
        Assert.assertSame(expected_res, c.sum(v1, v2));
    }
}
