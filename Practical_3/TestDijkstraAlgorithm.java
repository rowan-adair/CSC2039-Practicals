//*******************************************************************
//*******************************************************************
//
//   File: TestDijkstraAlgorithm.java
//
//   Test harness for the classes implementing the
//
//      Dijkstra algorithm
//
//   This tutorial has been developed from an Internet example.
//
//   Original copyright hereby acknowledged as:
//
//   Copyright © 2012-2016 vogella GmbH. Free use of the software
//   examples is granted under the terms of the EPL License. This
//   tutorial is published under the Creative Commons
//   Attribution-NonCommercial-ShareAlike 3.0 Germany license.
//
//*******************************************************************
//*******************************************************************

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestDijkstraAlgorithm
  {
   private List<Vertex> nodes;
   private List<Edge>   edges;

   /**
    *  Main program
    *
    */
   public static void main(String[]  args)
     {
      TestDijkstraAlgorithm testObj = new TestDijkstraAlgorithm();

      testObj.RunTest();
     }

   /**
    *  Runs the test by building a graph
    */
   public void RunTest()
     {
      nodes = new ArrayList<Vertex>();
      edges = new ArrayList<Edge>();

      //
      //---- Add vertices to the graph
      //

      for(int i = 0; i < 11; i++)
         {
	      String vertexId_str   = "Vertex_" + i;
		  String vertexName_str = "Vertex_" + i;

          Vertex v = new Vertex(vertexId_str, vertexName_str);

          nodes.add(v);
         }
          // End of loop to add vertexs to the graph

      //
      //--- Now build a list of edges connecting vertexes
      //

      addEdge("Edge_0_1",  0,  1,  85);
      addEdge("Edge_0_2",  0,  2, 217);
      addEdge("Edge_0_4",  0,  4, 173);
      addEdge("Edge_2_6",  2,  6, 186);
      addEdge("Edge_2_7",  2,  7, 103);
      addEdge("Edge_3_7",  3,  7, 183);
      addEdge("Edge_5_8",  5,  8, 250);
      addEdge("Edge_8_9",  8,  9,  84);
      addEdge("Edge_7_9",  7,  9, 167);
      addEdge("Edge_4_9",  4,  9, 502);
      addEdge("Edge_9_10", 9, 10,  40);
      addEdge("Edge_1_10", 1, 10, 600);

      //
      //--- Build the graph class and execute Dijkstra
      //

      Graph graph = new Graph(nodes, edges);

      DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

      Vertex sourceNode       = nodes.get(0);
      Vertex  destinationNode = nodes.get(10);

      dijkstra.execute(sourceNode);

      LinkedList<Vertex> path = dijkstra.getPath(destinationNode);

      //

      System.out.println("\n");
      System.out.println("     Least cost path between ");
      System.out.println("\n");
      System.out.println("        source      node: " + sourceNode);
      System.out.println("        destination node: " + destinationNode);
      System.out.println("\n");
      System.out.println("     traverses nodes: ");
      System.out.println("\n");

      for(Vertex vertex : path)
         {
          System.out.println("     " + vertex);
         }

      System.out.println("\n");

      return;
     }
      // End of method RunTest

   /**
    *   Add edge to the list
    *
    */
   private void addEdge(String edgeId_str,
                        int    sourceLocNo, int destLocNo,
                        int    weight)
     {
      Edge lane = new Edge(edgeId_str,
                           nodes.get(sourceLocNo), nodes.get(destLocNo),
                           weight);

      edges.add(lane);
     }
      // End of method addEdge()
  }
   // End of class TestDijkstraAlgorithm

//*******************************************************************
//*******************************************************************
//
//  End of file: TestDijkstraAlgorithm.java
//
//*******************************************************************
//*******************************************************************