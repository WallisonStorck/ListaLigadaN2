public class App {
  public static void main(String[] args) {
    // Criando uma nova lista ligada
    ListaLigada lista = new ListaLigada();

    lista.adiciona("Elemento 1");
    lista.adiciona("Elemento 2");
    lista.adiciona("Elemento 3");
    lista.adiciona("Elemento 4");

    System.out.println(lista.contem("Elemento 4"));

    System.out.println("lista.tamanho(): " + lista.tamanho());

    // Exibindo os elementos da lista usando o método toString()
    System.out.println("Elementos da lista: " + lista.toString());

    System.out.println("Executando 'lista.removeDoComeco()'...");
    lista.removeDoComeco();

    System.out.println("Elementos da lista: " + lista.toString());

    System.out.println("lista.mostraCelula(0): " + lista.mostraCelula(0));
  }
}
