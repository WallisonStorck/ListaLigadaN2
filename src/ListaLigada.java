public class ListaLigada {
  private Celula primeira;
  private Celula ultima;

  private int totalDeElementos = 0;

  public void adicionaNoComeco(Object elemento) {
    Celula nova = new Celula(this.primeira, elemento);
    this.primeira = nova;

    if (this.totalDeElementos == 0) {
      this.ultima = this.primeira;
    }
    this.totalDeElementos++;
  }

  // Preenchendo da esquerda para direita, "adiciona" é adicionar no fim.
  public void adiciona(Object elemento) {
    // Você vai apagar esse comentario e implementar aqui seu código conforme
    // critérios da prova
  }

  // Concatena todas as celulas para serem mostradas.
  public String toString() {
    // Verificando se a Lista está vazia
    if (this.totalDeElementos == 0) {
      return "[]";
    }
    StringBuilder builder = new StringBuilder("[");
    Celula celulaAtual = primeira;
    // Percorrendo até o penúltimo elemento.
    for (int i = 0; i < this.totalDeElementos - 1; i++) {
      builder.append(celulaAtual.getElemento());
      builder.append(", ");
      celulaAtual = celulaAtual.getProxima();
    }
    // último elemento
    builder.append(celulaAtual.getElemento());
    builder.append("]");
    return builder.toString();
  }

  // Método auxiliar que verifica se a posição é válida...
  public boolean posicaoOcupada(int posicao) {
    return posicao >= 0 && posicao < this.totalDeElementos;
  }

  // Método auxiliar que busca uma celula em específico.
  public Celula pegaCelula(int posicao) {
    if (!posicaoOcupada(posicao)) {
      throw new IllegalArgumentException("Posição Inválida!");
    }

    Celula celulaAtual = primeira;
    for (int i = 0; i < posicao; i++) {
      celulaAtual = celulaAtual.getProxima();
    }
    return celulaAtual;
  }

  // Adiciona por posição
  public void adiciona(int posicao, Object elemento) {
    if (posicao == 0) {
      this.adicionaNoComeco(elemento);
    } else if (posicao == this.totalDeElementos) {
      this.adiciona(elemento);
    } else {
      Celula celulaAnterior = this.pegaCelula(posicao - 1);
      Celula novaCelula = new Celula(celulaAnterior.getProxima(), elemento);
      celulaAnterior.setProxima(novaCelula);
      this.totalDeElementos++;
    }
  }

  // Mostra o conteudo da celula escolhida.
  public Object mostraCelula(int posicao) {
    return this.pegaCelula(posicao).getElemento();
  }

  public void remove(int posicao) {
    if (!posicaoOcupada(posicao)) {
      throw new IllegalArgumentException("Posição Inválida!");
    }

    if (posicao == 0) {
      this.removeDoComeco();
    } else if (posicao == totalDeElementos) {
      this.removeDoFim();
    } else {
      Celula celulaAnterior = this.pegaCelula(posicao - 1);
      Celula celulaAtual = celulaAnterior.getProxima();
      Celula celulaProxima = celulaAtual.getProxima();
      celulaAnterior.setProxima(celulaProxima);
      this.totalDeElementos--;
    }
  }

  public int tamanho() {
    return this.totalDeElementos;
  }

  public boolean contem(Object elemento) {
    Celula celulaAtual = this.primeira;

    while (celulaAtual != null) {
      if (celulaAtual.getElemento().equals(elemento)) {
        return true;
      }
      celulaAtual = celulaAtual.getProxima();
    }
    return false;
  }

  public void removeDoComeco() {
    if (!posicaoOcupada(0)) {
      throw new IllegalArgumentException("Posição Inválida!");
    }

    this.primeira = this.primeira.getProxima();
    this.totalDeElementos--;

    if (this.totalDeElementos == 0) {
      this.ultima = null;
    }
  }

  public void removeDoFim() {
    Celula penultimaCelula = this.pegaCelula(totalDeElementos - 1);
    penultimaCelula.setProxima(null);
    this.ultima = penultimaCelula;
    this.totalDeElementos--;

    if (this.totalDeElementos == 0) {
      this.primeira = null;
    }
  }
}