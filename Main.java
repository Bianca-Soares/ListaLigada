
import java.util.Scanner;
public class Main{

	static ListaLigada lista = new ListaLigada();
  static Elemento elemento;
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {

    Elemento elemento = new Elemento();

    do{
         menu();
    }while(true);
   
  }

  public static void exibirlista( ){	
    //fazer o Limpar a tela depois e usar aqui
	  System.out.println("\n\nExibicao da lista\n");
	  if(lista.getPrimeiro() == null) //verifica se a lista esta vazia
    {
		   System.out.println("\nLISTA VAZIA\tINSIRA DADOS NA LISTA\n");
    }
	  else
    {
      Aluno aluno = new Aluno();
      elemento = lista.getPrimeiro();

      System.out.print("Primeiro -> "); 
      do{
          aluno = elemento.aluno;
          System.out.print(aluno.getNome()+"  ");
          elemento = elemento.proximo;
      }while(elemento != null);
      System.out.println("<- ultimo \n"); 
    }
  }
  public static void adicionar(Aluno aluno, int posicao){	
    //lista.setPrimeiro(elemento); 
    //aluno.nome ="joão";
    adicionar(entradaDeDados(), 1);
    
  }
  public static void menu(){

    if(lista.getPrimeiro() == null){
      System.out.println("Escolha:\n 1 - Inserir no Dados");
    }else{
      System.out.println("Escolha:\n 1 - Inserir no Início \n 2 - Inserir no Fim\n 3 - Exibir lista \n 4 - Inserir na posicao\n  5- remover início \n 6 - remover fim \n 7 remover posição ");
    }
      int escolha = input.nextInt();
       
      soInserir(escolha);
  }

  public static void soInserir(int escolha){
    
    switch (escolha) {
      case 1:
        lista.addNoInicio(entradaDeDados());

        break;
      case 2:
        lista.addNoFim(entradaDeDados());
        break;
      case 3:
        exibirlista( );
        break;
      case 4:
        System.out.println("Escolha a posicao entre 1 e "+lista.getTamanho()+" ");
        int posicao = input.nextInt();
       
        if(!lista.addNaPosicao(entradaDeDados(), posicao))//add na posição se retornar false posição ñ encontrada
          System.out.println("Posição não existe os dados foram para última posição");
        break;
      case 5:
        lista.removerNoInicio();
        break;
      case 6:
        lista.removerNoFim();
        break;
      case 7:
        System.out.println("Escolha a posicao entre 1 e "+lista.getTamanho()+" ");
        posicao = input.nextInt();
       
        if(!lista.removerPosicao(posicao))//add na posição se retornar false posição ñ encontrada
          System.out.println("Posição não existe");
        break;

      default:
        menu();
      }
  }
  public static Aluno entradaDeDados(){
    Aluno aluno= new Aluno();

    System.out.println("Informe o nome do aluno: \n");
    input.nextLine();//limpar buffer do teclado

    aluno.setNome(input.nextLine());

    System.out.println("Informe a idade do aluno: \n");
    
    try { 
      aluno.setIdade(input.nextInt());
    }catch (Exception e) { 
       System.out.println("Informe a idade do aluno(valor inteiro): \n");
       input.nextLine();//limpar buffer do teclado
       aluno.setIdade(input.nextInt());
    }
    //aluno.setIdade(idade);

    System.out.println("Informe a turma do aluno: \n");
    input.nextLine();//limpar buffer do teclado

    aluno.setTurma(input.nextLine());

    return aluno;
  }
  public static void escolhaRemover(){
    
  }


 // public static void addNoFim(Aluno aluno) {
	//	lista.atual = lista.primeiro; // a busca começa pelo primeiro elemento

    // while buscar o ultimo elemento salvo //se null não existe próximo
    // while ( lista.atual.proximo != null) //se !null existe próximo
    // {
    //   atual = atual.proximo;
    // }
    // ultimo = atual; //ultimo dado encontrado

    // // Cria um novo elemento
    // elemento novo = new Elemento(aluno);//aluno tem os dados inseridos pelo usuário

    // ultimo.proximo = novo;
    // /* 
    // Agora o ultimo dado vai apontar para o novoDado, 
    // sendo assim novoDado e agora e ultimo dado.
    // */
    // this.tamanho++;
//	}


	// public void salvar(ActionEvent event) {
	// 	try {
	// 		String nome = txtName.getText().trim();
	// 		int idade = Integer.parseInt(txtIdade.getText().trim());
	// 		String turma = txtTurma.getText().trim();
	// 		if (!nome.equals("") || !turma.equals("")) {
	// 			Aluno aluno = new Aluno(nome, idade, turma);
	// 			lista.add(aluno);
	// 			attTextArea();
	// 			alerts.showWarning("Lista atualizada", "Aluno adicionado", AlertType.INFORMATION);
	// 		} else {
	// 			alerts.showWarning("Erro", "Campos inválidos", AlertType.ERROR);
	// 		}
	// 	} catch (NumberFormatException e) {
	// 		alerts.showWarning("Erro", "Digite uma idade válida", AlertType.ERROR);
	// 	}
	// }


	// public void remover(ActionEvent event) {
	// 	String nome = txtRemove.getText().trim();
	// 	Aluno aluno = new Aluno(nome, 0, null);
	// 	if (lista.remover(aluno)) {
	// 		attTextArea();
	// 		alerts.showWarning("Lista atualizada", "Aluno removido", AlertType.INFORMATION);
	// 	} else {
	// 		alerts.showWarning("Erro", "Aluno não existe", AlertType.ERROR);
	// 	}
	// }
}