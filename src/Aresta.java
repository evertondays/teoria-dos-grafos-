public class Aresta {
    private Vertice origem;
    private Vertice destino;
    private Integer peso;
    private boolean digrafo;
    private boolean mapped = false;

    
    public Aresta(Vertice or, Vertice de, Integer p, boolean d){
        origem = or;
        destino = de;
        peso = p;
        digrafo = d;
    }

    public Aresta(Vertice or, Vertice de, boolean d){
        this(or, de, null, d);
    }
  
    public String print(){
        String aresta;
        
        if (getDigrafo())
            aresta = "(" + getOrigem().getNome() +
                    " -> " + getDestino().getNome();
        else
            aresta = "(" + getOrigem().getNome() +
                    " - " + getDestino().getNome();
        if ((Integer)getPeso() == null)
            aresta += ")";
        else
            aresta += ", " + getPeso() + ")";
        return aresta;
    }

    // Getters / Setters
    
    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public boolean getDigrafo() {
        return digrafo;
    }

    public void setDigrafo(boolean digrafo) {
        this.digrafo = digrafo;
    }

    public boolean getMapped() {return this.mapped;}
    public void setMapped(boolean v) {this.mapped = v;}
}
