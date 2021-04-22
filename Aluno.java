public class Aluno{
  private String nome;
  int idade;
  String turma;

  public void Aluno(){

  }
  public void Aluno(String nome){
    this.nome = nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public String getNome(){
    return this.nome;
  }

  public void setIdade(int idade){
    this.idade = idade;
  }

  public int getIdade(){
    return this.idade;
  }

    public void setTurma(String turma){
    this.turma = turma;
  }

  public String getTurma(){
    return this.turma;
  }
}