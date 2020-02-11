//*******************************************************************
//*******************************************************************
//
//  File: Vertex.java
//
//  Implements a class which modles a vertex in a graph.
//
//*******************************************************************
//*******************************************************************

public class Vertex
  {
   /**
    *  Identifier of the vertex
    */
   final private String id;

   /**
    *  Name of the vertex
    */
   final private String name;


   /**
    *  Class constructor
    *
    */
   public Vertex(String id, String name)
     {
	  //
	  //--- Copy arguments to class globals
	  //

      this.id   = id;
      this.name = name;
     }
      // End of constructor

   /**
    *  Method: getId()
    *
    */
   public String getId()
     {
      return this.id;
     }
      // End of method getId()

   /**
    *  Method: getName()
    */
   public String getName()
     {
      return this.name;
     }
      // End of method getName()

   /**
    *  Method: hashCode()
    *
    *  Generate a hash code for the object
    *
    */
   public int hashCode()
     {
      final int prime = 31;

      int result = 1;

      result = prime * result + ((id == null) ? 0 : id.hashCode());

      return result;
     }
      // End of method hashCode()

   /**
    *  Method: equals()
    */
   public boolean equals(Object obj)
     {
	  boolean zRc = false;

      if(this == obj)
        {
	     zRc = true;
	    }
      else
        {
         if(obj == null)
           {
            zRc = false;
	       }
	     else
	       {
            if(getClass() != obj.getClass())
              {
               zRc = false;
		      }
		    else
		      {
               Vertex other = (Vertex) obj;

               if(id == null)
                 {
                  if(other.id != null)
                    {
                     zRc = false;
                    }
			     }
               else
                 {
			      if(!id.equals(other.id))
                    {
                     zRc = false;
			        }
                  else
                    {
                     zRc = true;
			        }
			     }
		      }
	       }
	    }

	  //

	  return zRc;
     }
      // End of method equals()

   /**
    *  Method: toString()
    */
   public String toString()
     {
      return this.name;
     }
      // End of method toString()
  }

//*******************************************************************
//*******************************************************************
//
//  End of file: Vertex.java
//
//*******************************************************************
//*******************************************************************