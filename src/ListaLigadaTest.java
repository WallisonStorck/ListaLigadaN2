import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaLigadaTest {
  ListaLigada lista = new ListaLigada();

  @Test
  public void testAdiciona() {
    ListaLigada lista = new ListaLigada();

    lista.adiciona("Elemento 1");
    lista.adiciona("Elemento 5");
    lista.adiciona("Elemento 7");

    assertEquals(3, lista.tamanho(), "A lista deve ter 3 elementos após adicionar dois elementos.");
    assertEquals("Elemento 1", lista.mostraCelula(0), "O primeiro elemento deve ser 'Elemento 1'.");
    assertEquals("Elemento 5", lista.mostraCelula(1), "O segundo elemento deve ser 'Elemento 5'.");
    assertEquals("Elemento 7", lista.mostraCelula(2), "O segundo elemento deve ser 'Elemento 7'.");
  }
}
