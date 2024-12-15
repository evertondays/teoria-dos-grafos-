public class TeoriaDosGrafos {
    public static void main(String[] args) throws Exception {
        Grafo grf = new Grafo(5, 6, Grafo.NAO_DIGRAFO);

        grf.adicionarVertice("A");
        grf.adicionarVertice("B");
        grf.adicionarVertice("C");
        grf.adicionarVertice("D");
        grf.adicionarVertice("E");

        grf.adicionarAresta("A", "B");
        grf.adicionarAresta("B", "C");
        grf.adicionarAresta("C", "A");
        grf.adicionarAresta("C", "E");
        grf.adicionarAresta("C", "D");
        grf.adicionarAresta("D", "E");


        System.out.println("Grafo não direcionado: " + grf.hierholzer("A"));
        System.out.println("link para imagem do grafo usado: https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJdDXfZAFvy7w1jcnyWyeVnKSQze013_Cc0Q&s");
        System.out.print("\n------------------\n\n");

        Grafo grfDirecionado = new Grafo(5, 6, Grafo.DIGRAFO);

        grfDirecionado.adicionarVertice("0");
        grfDirecionado.adicionarVertice("1");
        grfDirecionado.adicionarVertice("2");
        grfDirecionado.adicionarVertice("3");
        grfDirecionado.adicionarVertice("4");
        grfDirecionado.adicionarVertice("5");
        grfDirecionado.adicionarVertice("6");

        grfDirecionado.adicionarAresta("0", "1");
        grfDirecionado.adicionarAresta("0", "6");
        grfDirecionado.adicionarAresta("1", "2");
        grfDirecionado.adicionarAresta("2", "3");
        grfDirecionado.adicionarAresta("3", "4");
        grfDirecionado.adicionarAresta("4", "5");
        grfDirecionado.adicionarAresta("4", "2");
        grfDirecionado.adicionarAresta("5", "0");
        grfDirecionado.adicionarAresta("6", "4");
        grfDirecionado.adicionarAresta("2", "0");

        System.out.println("Grafo direcionado: " + grfDirecionado.hierholzer("0"));
        System.out.println("link para imagem do grafo usado: https://media.geeksforgeeks.org/wp-content/uploads/Euler2.jpg");
        System.out.println("(a resposta tá diferente mas está correto o algoritmo kkkk)");
    }
}