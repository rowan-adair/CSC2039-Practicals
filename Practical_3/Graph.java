//*******************************************************************
//*******************************************************************
//
//  File: Graph.java
//
//  Implements a class to model a graph.
//
//  A graph is a datra structure consisting of Vertexes and Edges
//
//*******************************************************************
//*******************************************************************

import java.util.List;

public class Graph
  {
   /**
    *  List of vertexes in the graph
    */
   private final List<Vertex> vertexes;

   /**
    *  List of edges in the graph
    */
   private final List<Edge>   edges;

   /**
    *   Constructor
    *
    *   Takes a list of edges and vertices and stores into
    *   class globals
    */
   public Graph(List<Vertex> vertexes, List<Edge> edges)
     {
      this.vertexes = vertexes;
      this.edges    = edges;
     }
      // End of constructor

   /**
    *   Method: getVertexes()
    *
    *   Returns the list of vertices
    */
   public List<Vertex> getVertexes()
     {
      return this.vertexes;
     }
      // End of method getVertexes()

   /**
    *   Method: getEdges()
    *
    *   Returns the list of edges
    */
   public List<Edge> getEdges()
     {
      return ....
     }
      // End of method getEdges()

   /**
    *   Method: printGraph()
    *
    *   For each vertex prints the list of edges to which it
    *   is directly connected. All information is printed to
    *   System.out...
    */
   public void printGraph()
     {
	  //
	  //.... Complete this
	  //

      .....

	  return;
     }
      // End of printGraph()
  }
   // End of class Graph

//*******************************************************************
//*******************************************************************
//
//  End of file
//
//*******************************************************************
//*******************************************************************