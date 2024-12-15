import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Grafo {

    private Vector V;
    private Vector A;
    private boolean ehDigrafo;
    private Map<String, Vector<Aresta>> verticeMap = new HashMap<>();
    public static boolean DIGRAFO = true;
    public static boolean NAO_DIGRAFO = false;

    public Grafo(int nV, int nA, boolean dig) {
        V = new Vector(nV);
        A = new Vector(nA);
        ehDigrafo = dig;
    }

    public void adicionarVertice(String nomeVertice) {
        getV().add(new Vertice(nomeVertice));
    }

    public void adicionarAresta(String vert1, String vert2, Integer peso) {
        Vertice v1 = null, v2 = null;
        Aresta aresta = null;

        for (int i = 0; i < getV().size(); i++) {
            v1 = (Vertice) getV().get(i);
            if (v1.getNome() == vert1) {
                break;
            }
        }

        for (int i = 0; i < getV().size(); i++) {
            v2 = (Vertice) getV().get(i);
            if (v2.getNome() == vert2) {
                break;
            }
        }
        aresta = new Aresta(v1, v2, peso, getEhDigrafo());
        getA().add(aresta);
    }

    public void adicionarAresta(String vert1, String vert2) {
        this.adicionarAresta(vert1, vert2, null);
    }

    public void imprimir() {
        Vertice vert = null;
        Aresta are = null;
        for (int i = 0; i < getV().size(); i++) {
            vert = (Vertice) getV().get(i);
            System.out.println(vert.print() + ":");
            for (int j = 0; j < getA().size(); j++) {
                are = (Aresta) getA().get(j);
                if (getEhDigrafo()) {
                    if (are.getOrigem().getNome() == vert.getNome()) {
                        System.out.println("   " + are.print());
                    };
                }else {
                    if ((are.getOrigem().getNome() == vert.getNome())
                            || (are.getDestino().getNome() == vert.getNome())) {
                        System.out.println("   " + are.print());
                    }

                }
            }
        }
    }

    public String hierholzer(String verticeInicio) {
        if (this.ehDigrafo) {
            return this.hierholzerDirecionado(verticeInicio);
        }

        return this.hierholzerNaoDirecionado(verticeInicio);
    }

    public void initHashmap() {
        for (int i = 0; i < getV().size(); i++) {
            var vertice = (Vertice) getV().get(i);
            var arestasDoVertice = new Vector<Aresta>();

            for (int x = 0; x < getA().size(); x++) {
                var aresta = (Aresta) getA().get(x);

                if (aresta.getOrigem().getNome() == vertice.getNome()) {
                    arestasDoVertice.add(aresta);
                }
            }

            this.verticeMap.put(vertice.getNome(), arestasDoVertice);
        }
    }

    public String hierholzerDirecionado(String verticeInicio) {
        this.initHashmap();

        Vector<String> pilha = new Vector();
        Vector<String> result = new Vector();

        pilha.add(verticeInicio);

        do {
            var nomeVertice = pilha.getLast();
            var arestasDoVertice = verticeMap.get(nomeVertice);
            var temVerticeParaMapear = false;

            if (!arestasDoVertice.isEmpty()) {
                var aresta = arestasDoVertice.removeFirst();
                pilha.add(aresta.getDestino().getNome());
                temVerticeParaMapear = true;
            }

            if (!temVerticeParaMapear) {
                var x = pilha.removeLast();
                result.add(x);
            }
        } while (!pilha.isEmpty());

        var stringResult = "";
        for (int i = result.size() - 1; i >= 0; i--) {
            stringResult = stringResult + result.get(i);
        }

        return stringResult;
    }

    public String hierholzerNaoDirecionado(String verticeInicio) {
        Vector<String> pilha = new Vector();
        Vector<String> result = new Vector();

        pilha.add(verticeInicio);
        var arestas = getA();

        do {
            var nomeVertice = pilha.getLast();
            var temVerticeParaMapear = false;

            for (int i = 0; i < arestas.size(); i++) {
                var aresta = (Aresta) arestas.get(i);
                if (aresta.getOrigem().getNome() == nomeVertice) {
                    pilha.add(aresta.getDestino().getNome());
                    temVerticeParaMapear = true;
                    arestas.remove(i);
                    break;
                }

                if (aresta.getDestino().getNome() == nomeVertice) {
                    pilha.add(aresta.getOrigem().getNome());
                    temVerticeParaMapear = true;
                    arestas.remove(i);
                    break;
                }
            }

            if (!temVerticeParaMapear) {
                var x = pilha.removeLast();
                result.addLast(x);
            }

        } while(!pilha.isEmpty());

        var stringResult = "";
        for (int i = result.size() - 1; i >= 0; i--) {
            stringResult = stringResult + result.get(i);
        }

        return stringResult;
    }

    // Getters / Setters

    public Vertice getVertice(String nome) throws Exception {
        for (int i = 0; i < getV().size(); i++) {
            var v = (Vertice) getV().get(i);
            if (v.getNome() == nome) {
                return v;
            }
        }

        throw new Exception("Não foi possivel achar o vertice");
    }
    
    public Vector getV() {
        return V;
    }

    public void setV(Vector V) {
        this.V = V;
    }

    public Vector getA() {
        return A;
    }

    public void setA(Vector A) {
        this.A = A;
    }
    
    public boolean getEhDigrafo(){
      return ehDigrafo;
    }
    
    public void setEhDigrafo(boolean dig){
      ehDigrafo = dig;
    }
}

