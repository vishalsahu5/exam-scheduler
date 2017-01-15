/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examscheduler;
import java.util.*;
import java.util.LinkedList;
 
/**
 *
 * @author Sarthak Sahu
 */
// This class represents an undirected graph using adjacency list
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List
 
    //Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    //Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        int flag = 0;
        
        Iterator<Integer> it = adj[v].iterator() ;
        while( it.hasNext() )
        {
            int i = it.next();
            if( i == w )
            {
                flag = 1;
                break;
            }
        }
        
        if( flag == 0 )
        {
            adj[v].add(w);
            adj[w].add(v); //Graph is undirected
        }
    }
 
    void printAll()
    {
        for(int j=0; j<17; j++)
        {
            Iterator<Integer> it = adj[j].iterator() ;
            while(it.hasNext())
            {
                int i = it.next();
                System.out.print(i);
            }
            System.out.println("");
        }
    }
    // Assigns colors (starting from 0) to all vertices and
    // prints the assignment of colors
    int[] greedyColoring()
    {
        int result[] = new int[V];
 
        // Assign the first color to first vertex
        result[0]  = 0;
 
        // Initialize remaining V-1 vertices as unassigned
        for (int u = 1; u < V; u++)
            result[u] = -1;  // no color is assigned to u
 
        // A temporary array to store the available colors. True
        // value of available[cr] would mean that the color cr is
        // assigned to one of its adjacent vertices
        boolean available[] = new boolean[V];
        for (int cr = 0; cr < V; cr++)
            available[cr] = false;
 
        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < V; u++)
        {
            // Process all adjacent vertices and flag their colors
            // as unavailable
            Iterator<Integer> it = adj[u].iterator() ;
            while (it.hasNext())
            {
                int i = it.next();
                if (result[i] != -1)
                    available[result[i]] = true;
            }
 
            // Find the first available color
            int cr;
            for (cr = 0; cr < V; cr++)
                if (available[cr] == false)
                    break;
 
            result[u] = cr; // Assign the found color
  

            // Reset the values back to false for the next iteration
            it = adj[u].iterator() ;
            while (it.hasNext())
            {
                int i = it.next();
                if (result[i] != -1)
                    available[result[i]] = false;
            }
        }
 
        // print the result
        return result;
    }
}