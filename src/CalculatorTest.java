import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalculatorTest
{
    //Crear instancia de calculadora
    private Calculator calculator;

    //Realizar antes del comienzo de la ejecucion de la clase Test
    @BeforeAll
    public static void beforeAll()
    {
        System.out.println("Ejecutando beforeAll...");
    }

    //Realizar antes del comienzo de cada ejecucion
    @BeforeEach
    public void setUp()
    {
        //Inicializar instancia de calculadora
        calculator = new Calculator();
        System.out.println("Creando objeto Calculator...");
    }

    //Testear suma
    @Test
    public void testAdd()
    {
        //Almacenar resultado de metodo en variable
        int result = calculator.add(3, 4);
        //Verificar (resultado esperado, resultado almacenado, mensaje en caso de error)
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

    //Testear multiplicacion (METODO PRIVADO)
    @Test
    public void testMulti() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        //Buscar método junto con sus parámetros y almacenarlo en variable
        Method metodoPrivado = Calculator.class.getDeclaredMethod("multi", double.class, double.class);
        //Cambiar accesibilidad al metodo
        metodoPrivado.setAccessible(true);

        //Invoca el metodo (instancia de la clase, argumentos) y al resultado lo almacena en una variable
        double resultado = (double) metodoPrivado.invoke(calculator, 2.0, 3.0);

        //Verificar si el resultado es correcto (valor esperado, valor almacenado,)
        Assertions.assertEquals(6.0, resultado, 0.001);
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

    /*
    Strategy: es un patrón de comportamiento que permite definir una familia de algoritmos, encapsularlos y hacerlos intercambiables. Se compone de tres elementos clave: la interfaz Strategy, que define la estructura básica para las implementaciones de estrategia, las clases de estrategia concretas que implementan esta interfaz, y el contexto, que utiliza un objeto Strategy para delegar un comportamiento específico.
    //
    Iterator: es un patrón de comportamiento que proporciona una forma de acceder secuencialmente a los elementos de una colección sin exponer su representación interna. Separa la responsabilidad de acceder y recorrer los elementos de la colección de la colección en sí, lo que permite que las colecciones se puedan modificar sin afectar la forma en que se accede a sus elementos.
    //
    Template Method: es un patrón comportamental que define el esqueleto de un algoritmo en una superclase, pero delega algunos pasos a las subclases. Permite que las subclases cambien el comportamiento de ciertas partes de un algoritmo sin cambiar su estructura general.
    //
     Factory Method: es un patrón creacional que proporciona una interfaz para crear objetos en una superclase, mientras permite a las subclases modificar el tipo de objetos que se crearán.
     */
}
