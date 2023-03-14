import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private Bun bun;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"black bun", 10},
                {"", 0},
                {null, -10},
                {"Miracle_Long_Bun_Miracle_Long_Bun", 3.4E+38f},
                {"856492", 40.123456f},
                {"!@#$%^&*()", 4.7E-23f},
        };
    }
    @Before
    public void createNewInstance() {
        bun = new Bun("original", 200.0f);
    }

    @Test
    public void getName() {
        String expected = "original";
        String actual = bun.getName();

        assertEquals("Incorrect values bun name", expected, actual);
    }

    @Test
    public void getPrice() {
        float expected = 200.0f;
        float actual = bun.getPrice();

        assertEquals("Incorrect values bun price", expected, actual, 0);
    }
}