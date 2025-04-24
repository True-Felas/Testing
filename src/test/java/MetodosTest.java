import org.example.Metodos;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MetodosTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testIntroducirUsuarioCorrectamente() {
        String input = "Juan\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Metodos metodos = new Metodos();
        metodos.introducirUsuario();

        assertTrue(outContent.toString().contains("Bienvenido, Juan!"));
    }

    @Test
    void testIntroducirIngresoConUsuario() {
        String input = "Juan\n100\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Metodos metodos = new Metodos();
        metodos.introducirUsuario();
        metodos.introducirIngreso();

        assertTrue(outContent.toString().contains("Ingreso exitoso"));
    }

    @Test
    void testIntroducirGastoMayorQueSaldo() {
        String input = "Juan\n50\n1\n100\n50\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Metodos metodos = new Metodos();
        metodos.introducirUsuario();     // Juan
        metodos.introducirIngreso();     // 50€
        metodos.introducirGasto();       // Vacaciones -> intenta gastar 100 (falla), luego 50 (ok)

        assertTrue(outContent.toString().contains("El saldo es insuficiente"));
        assertTrue(outContent.toString().contains("registrado exitosamente"));
    }

    @Test
    void testMostrarSaldo() {
        String input = "Juan\n200\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Metodos metodos = new Metodos();
        metodos.introducirUsuario();
        metodos.introducirIngreso();
        outContent.reset();

        metodos.mostrarSaldo();
        assertTrue(outContent.toString().contains("Juan, su saldo actual es de: 200.0€"));
    }

    @Test
    void testIngresoSinUsuario() {
        Metodos metodos = new Metodos();
        metodos.introducirIngreso();
        assertTrue(outContent.toString().contains("Debe introducir el nombre del usuario primero."));
    }

    @Test
    void testGastoSinUsuario() {
        Metodos metodos = new Metodos();
        metodos.introducirGasto();
        assertTrue(outContent.toString().contains("Debe introducir el nombre del usuario primero."));
    }

    @Test
    void testMostrarSaldoSinUsuario() {
        Metodos metodos = new Metodos();
        metodos.mostrarSaldo();
        assertTrue(outContent.toString().contains("Debe introducir el nombre del usuario primero."));
    }
}
