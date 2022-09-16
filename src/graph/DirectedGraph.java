package graph;

import java.util.Scanner;

public class DirectedGraph {

    private Scanner file;
    private int [][] adjacencyMatrix;
    private int edgesQuantity;
    private int verticesQuantity;
    private int isolatedVertices;

    public DirectedGraph(Scanner file) {
        this.file = file;
        this.startDirectedGraph();
    }

    private void startDirectedGraph(){
        this.verticesQuantity = Integer.parseInt(this.file.nextLine());
        this.edgesQuantity = Integer.parseInt(this.file.nextLine());
        this.adjacencyMatrix = new int [this.verticesQuantity][this.edgesQuantity];

        this.adjacencyMatrix = setAdjacencyMatrixValues(this.adjacencyMatrix, this.file);
        this.isolatedVertices = isolatedVerticesCounter();
    }

    private int [][] setAdjacencyMatrixValues(int [][] adjacencyMatrix, Scanner file) {
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String [] array = line.split(" ");
            int originVertice = Integer.parseInt(array[0]);
            int destineVertice = Integer.parseInt(array[1]);
            adjacencyMatrix[originVertice][destineVertice] = 1;
        }
        return adjacencyMatrix;
    }

    private int isolatedVerticesCounter() {
        boolean isIsolatedVertice;
        int counter = 0;

        for (int i = 0; i < this.adjacencyMatrix.length; i++) {
            isIsolatedVertice = true;
            for (int j = 0; j < this.adjacencyMatrix.length; j++) {
                if (this.adjacencyMatrix[i][j] == 1 || this.adjacencyMatrix[j][i] == 1)
                    isIsolatedVertice = false;
            }
            if (isIsolatedVertice == true)
                counter++;
        }
        return counter;
    }

    public void getEntryDegree() {
        int counter = 0;

        for (int i = 0; i < this.adjacencyMatrix.length; i++) {
            System.out.print("Entry degree of '"+i+"': ");
            for (int j = 0; j < this.adjacencyMatrix.length; j++) {
                if (this.adjacencyMatrix[j][i] != 0)
                    counter++;
            }
            System.out.println(counter);
            counter = 0;
        }
    }

    public int[][] getAdjacencyMatrix() {
        return this.adjacencyMatrix;
    }

    public int getEdgesQuantity() {
        return edgesQuantity;
    }

    public int getVerticesQuantity() {
        return verticesQuantity;
    }

    public int getIsolatedVertices() {
        return isolatedVertices;
    } 

}
