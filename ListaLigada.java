public class ListaLigada {
  //Um Elemento é a classe que contém a classe Aluno com os dados do aluno
	private Elemento primeiro;
  private Elemento atual;
	private Elemento ultimo;
	private int tamanho;

	public ListaLigada() {
		this.tamanho = 0;
	}

	public Elemento getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(Elemento primeiro) {
		this.primeiro = primeiro;
	}

	public Elemento getUltimo() {
		return ultimo;
	}

	public void setUltimo(Elemento ultimo) {
		this.ultimo = ultimo;
	}
  public Elemento getAtual() {
		return atual;
	}

	public void setAtual(Elemento atual) {
		this.atual = atual;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void addNoInicio(Aluno aluno) {

    // Cria um novo Elemento
    Elemento novo = new Elemento(aluno);//aluno tem os dados inseridos pelo usuário
    novo.proximo = getPrimeiro(); // Primeiro dado passa a ser o proximo

    setPrimeiro(novo);
    //e agora o novo passa a ser o primeiro da lista
    this.tamanho++;
  }
 
	public void addNoFim(Aluno aluno) {
		atual = getPrimeiro(); // a busca começa pelo primeiro Elemento

    // while buscar o ultimo Elemento salvo //se null não existe próximo
    while ( atual.proximo != null) //se !null existe próximo
    {
      atual = atual.proximo;
    }
    ultimo = atual; //ultimo dado encontrado

    // Cria um novo Elemento
    Elemento novo = new Elemento(aluno);//aluno tem os dados inseridos pelo usuário

    ultimo.proximo = novo;
    /* 
    Agora o ultimo dado vai apontar para o novoDado, 
    sendo assim novoDado e agora e ultimo dado.
    */
    this.tamanho++;
	}
	
	  public boolean addNaPosicao(Aluno aluno, int posicao) {
      int cont = 1;// pq para o usuário não existe posicao 0
		  atual = getPrimeiro(); // a busca começa pelo primeiro Elemento
      Elemento novo = new Elemento(aluno);//aluno tem os dados inseridos pelo usuário
      
      if( (primeiro == null) || (posicao == 1 ) ){
        addNoInicio(aluno);
        return true;
      }
      // while buscar o ultimo Elemento salvo //se null não existe próximo
      while ( atual.proximo != null) 
      {   
          if( cont == posicao -1 ){// -1 pq preciso da aposição anterior a escolhida 
            novo.proximo = atual.proximo;// novo recebe uma copia os dados dos próximos
            atual.proximo = novo;// dados do proximo é substituído pelo novo. novo contém a cópia dos próximos
            this.tamanho++;
            return true;  
          }
          
          atual = atual.proximo;
          cont++;
      }
      addNoFim(aluno);

      return false;
	  }


  	public Aluno getAluno(int posicao) {
      atual = getPrimeiro(); // a busca começa pelo primeiro Elemento
      int cont = 1;
      Aluno aluno = new Aluno();
      while ( atual.proximo != null) 
        {   
            if( cont == posicao){
              return atual.aluno;  
            }
            atual = atual.proximo;
            cont++;
        }
		  return null;
	  }

  	public void removerNoInicio() {
      setPrimeiro(getPrimeiro().proximo); 
      this.tamanho--;
	  }

    public void removerNoFim() {
      atual = getPrimeiro();
      Elemento penultimo = new Elemento();//elemento vazio
      while ( atual.proximo != null) 
      {   
         penultimo = atual; 
         atual= atual.proximo;// dados do proximo é substituído pelo próximo do próximo   
      }
      penultimo.proximo = null;
      setUltimo(penultimo); 
      this.tamanho--;
	  }
    
    public boolean removerPosicao(int posicao) {
      int cont = 1;// pq para o usuário não existe posicao 0
		  atual = getPrimeiro(); // a busca começa pelo primeiro Elemento
      Elemento anterior = new Elemento();//para cópia dos anteriores
      
      if( (primeiro == null) || (posicao == 1 ) ){
        removerNoInicio();
        return true;
      }
      // while buscar o ultimo Elemento salvo //se null não existe próximo
      while ( atual.proximo != null) 
      {   
          if( cont == posicao-1 ){// -1 pq preciso da aposição anterior a escolhida 
            //acho que isso é pegar atalho
            atual.proximo = atual.proximo.proximo;// dados do proximo é substituído pelo próximo do próximo 
            this.tamanho--;
            return true;  
          }
          
          atual = atual.proximo;
          cont++;
      }
      return false;
	  }
} 