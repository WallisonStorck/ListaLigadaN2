public class Celula {
  private Celula proxima; // Aponta para a próxima célula na lista
  private Object elemento; // Armazena o dado, de qualquer tipo

  public Celula(Celula proxima, Object elemento) {
    this.proxima = proxima;
    this.elemento = elemento;
  }

  public Celula(Object elemento) {
    this.elemento = elemento;
  }

  public void setProxima(Celula proxima) {
    this.proxima = proxima;
  }

  public Celula getProxima() {
    return proxima;
  }

  public Object getElemento() {
    return elemento;
  }
}
