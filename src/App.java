import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import graph.DirectedGraph;

public class App {

    public static void main(String[] args) throws Exception {
        DirectedGraph graph;
        int [][] adjacencyMatrix;
        int edgesQuantity, verticesQuantity, isolatedVertices;

        graph = new DirectedGraph(readFile());
        adjacencyMatrix = graph.getAdjacencyMatrix();
        edgesQuantity = graph.getEdgesQuantity();
        verticesQuantity = graph.getVerticesQuantity();
        isolatedVertices = graph.getIsolatedVertices();

        System.out.println();
        showAdjacencyMatrix(adjacencyMatrix);
        System.out.println();
        System.out.println("Graph order: "+edgesQuantity);
        System.out.println("Graph size: "+verticesQuantity);
        System.out.println("Entry degree of all vertices: ");
        graph.getEntryDegree();
        System.out.println();
        System.out.println("Number of isolated vertices: "+isolatedVertices);
        System.out.println("In a directed graph, the number of extremity vertices is null");
    }


    private static void showAdjacencyMatrix(int[][] adjacencyMatrix) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(adjacencyMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    private static Scanner readFile() throws FileNotFoundException{
        String file = "src\\utils\\pequenoG.txt";
        FileReader reader = new FileReader(file);
        return new Scanner(reader).useDelimiter("\\n");
    }

}
