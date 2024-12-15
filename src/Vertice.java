public class Vertice {
    private String nome;
    
    public Vertice(String n){
        nome = n;
    }

    public String print(){
        return this.getNome();
    }

    // Getters / Setters
    
    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}