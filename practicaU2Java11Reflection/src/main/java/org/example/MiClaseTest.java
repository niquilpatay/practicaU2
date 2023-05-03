package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

public class MiClaseTest
{
    private MiClase miClase;

    //Antes de cada método, inicalizar instancia de clase
    @BeforeEach
    public void setUp()
    {
        miClase = new MiClase();
    }

    //Test para un método privado, puede devolver una excepción
    @Test
    public void testMetodoPrivado() throws Exception
    {
        //Buscar metodo privado y almacenarlo en variable
        Method metodoPrivado = MiClase.class.getDeclaredMethod("metodoPrivado");
        //Cambiar accesibilidad del metodo privado
        metodoPrivado.setAccessible(true);

        //Invocamos el método privado y guardamos su retorno en una variable
        int resultado = (int) metodoPrivado.invoke(miClase);
        //Verificar que el valor de retorno sea igual a 1
        //Argumentos: (resultado esperado, variable que almacena ese resultado)
        Assertions.assertEquals(1, resultado);
    }
}
