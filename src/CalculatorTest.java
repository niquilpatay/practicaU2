import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest
{
    private Calculator calculator;

    @BeforeAll
    public static void beforeAll()
    {
        System.out.println("Ejecutando beforeAll...");
    }

    @BeforeEach
    public void setUp()
    {
        calculator = new Calculator();
        System.out.println("Creando objeto Calculator...");
    }

    @Test
    public void testAdd()
    {
        int result = calculator.add(3, 4);
        assertEquals(7, result, "La suma de 3 y 4 debe ser 7");
        System.out.println("Ejecutando testAdd...");
    }

    @Test
    public void testSubstract()
    {
        int result = calculator.subtract(5, 2);
        assertEquals(3, result, "La resta de 5 y 2 debe ser 3");
        System.out.println("Ejecutando testSubstract...");
    }

    @AfterEach
    public void tearDown()
    {
        calculator = null;
        System.out.println("Eliminando objeto Calculator...");
    }

    @AfterAll
    public static void afterAll()
    {
        System.out.println("Ejecutando afterAll...");
    }
}
