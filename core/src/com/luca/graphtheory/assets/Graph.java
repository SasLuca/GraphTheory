package com.luca.graphtheory.assets;

/**
 * Created by Sas on 11/17/2015.
 */

import java.util.ArrayList;

public class Graph
{

    //TODO: Finish all the algorithms

    private     ArrayList<Edge>     edges                           = new ArrayList<Edge>();

    private     ArrayList<Vertex>   vertices                        = new ArrayList<Vertex>();

    private     int[][]             adjacencyMatrix                 = new int[20][20];

    private     int                 numberOfEdges                   = 0;

    private     int                 numberOfVertices                = 0;

    private     int[]               traversedVertices               = new int[20];

    private     int                 numberOfConnectedComponents     = 0;

    private     boolean[]           setToCenter                     = new boolean[100];

    private     boolean             draggable                       = true;

    //region Constructors
    public Graph()
    {

        vertices.add(new Vertex(0));
        edges.add(new Edge(vertices.get(0), vertices.get(0)));

    }
    //endregion

    //region Methods
    public void render()
    {

        for(int i = 1; i <= numberOfEdges; i++)
        {

            edges.get(i).                                           render();

        }

        for(int i = 1; i <= numberOfVertices; i++)
        {

            if(vertices.get(i).getIaRun())                          { vertices.get(i).render(L_Object.DrawMethod.CENTER_TO_POSITION); } else { vertices.get(i).render(); }

        }

    }

    public void addVertex()
    {

        vertices.add(new Vertex(vertices.size()));

        for(int i = 1; i <= vertices.size() - 1; i++)
        {

            adjacencyMatrix[vertices.size()][i]                     = 0;

        }

        vertices.get(vertices.size() - 1).                          setPosition(500, 500);

        vertices.get(vertices.size() - 1).                          setSize(0, 0);

        setToCenter[vertices.size() - 1]                            = true;

        numberOfVertices++;

    }

    public int getReleasedVertex()
    {

        for(int i = vertices.size() - 1; i >= 1; i--)
        {

            if(vertices.get(i).isReleased())                       return i;

        }

        return                                                      0;

    }

    public void drag()
    {

        if (draggable)
        {

            for(Vertex vertex : vertices)
            {

                if (!vertex.getIaRun())
                {

                    vertex.                                             drag();

                    if(vertex.getDraggable())
                    {

                        for(Edge edge : edges)
                        {

                            if(edge.getVertex1() == vertex || edge.getVertex2() == vertex)
                            {

                                edge.calculateEdge();

                            }

                        }

                    }

                    checkVertexBounds(vertex);

                }

            }
        }

    }

    public void checkVertexBounds(Vertex vertex)
    {

        if(vertex.getX() > 1199)    vertex.                         setX(1198);

        if(vertex.getX() < 344)     vertex.                         setX(343);

        if(vertex.getY() > 635)     vertex.                         setY(634);

        if(vertex.getY() < -8)      vertex.                         setY(-7);

    }

    public void updateInput()
    {

        Vertex vertex;

        //We go through the array from end to beginning since when we press on a vertex that is on top of a lower indexed vertex we want to gain control of the top most vertex
        for(int i = vertices.size() - 1; i >= 1; i--)
        {

            vertex                                                  = vertices.get(i);

            vertex.                                                 increaseAnim(90, 5f, 0.01f);

            if(!vertex.getIaRun())
            {

                if(setToCenter[vertex.getIndex()])
                {

                    vertex.                                         setPosition(vertex.getX() - vertex.getWidth() / 2, vertex.getY() - vertex.getHeight() / 2);

                    setToCenter[vertex.getIndex()]                  = false;

                }

                vertex.                                             updateInput();

                if(vertex.isClicked() || vertex.isPressed())        break;

            }

        }

    }

    public boolean isGraphConnected()
    {

        return                                                      true;

    }

    public boolean isVertexEndPoint(int vertex)
    {

        int a                                                       = 0;

        for(int i = 1; i <= numberOfVertices; i++)
        {

            if(adjacencyMatrix[vertex][i] == 1)                     a++;

            if(a > 1) return                                        false;

        }

        return                                                      true;

    }

    public int getNumberOfConnectedComponenets()
    {

        int[] traversedVerticies                                    = new int[20];

        int ct                                                      = 1;

        for(int i = 1; i <= numberOfVertices; i++)
        {

            if(traversedVerticies[i] == 0)
            {

                ct++;

                traverseByHeight(traversedVerticies, i, ct);

                i                                                   = 1;

            }

        }

        int max                                                     = 0;

        for(int i = 1; i <= numberOfVertices; i++)
        {

            if(traversedVerticies[i] > max) max                     = traversedVerticies[i];

        }

        return                                                      max;

    }

    public void addEdge(int vertex1, int vertex2)
    {

        if (adjacencyMatrix[vertex1][vertex2] != 1 && vertex1 != vertex2)
        {

            adjacencyMatrix[vertex1][vertex2]                       = 1;
            adjacencyMatrix[vertex2][vertex1]                       = 1;

            edges.                                                  add(new Edge(vertices.get(vertex1), vertices.get(vertex2)));

            numberOfEdges++;

            System.out.                                             println("Edge created between vertex " + vertex1 + " and vertex " + vertex2);

        }
        else if(adjacencyMatrix[vertex1][vertex2] == 1)
        {

            System.out.                                             println("Vertices " + vertex1 + " and " + vertex2 + " are already adjacent");

        }
        else if(vertex1 == vertex2)
        {

            System.out.                                             println("A vertex can not be adjacent to itself!");

        }

    }

    public void deleteEdge(int vertex1, int vertex2)
    {

        adjacencyMatrix[vertex1][vertex2]                           = 0;
        adjacencyMatrix[vertex2][vertex1]                           = 0;

    }

    public boolean adjacencyOfVerticies(int vertex1, int vertex2)
    {

        if(adjacencyMatrix[vertex1][vertex2] == 1)
        {

            return                                                  true;

        }
        else
        {

            return                                                  false;

        }

    }

    public void traverseByHeight(int[] traversedVerticies, int vertex, int component)
    {

        traversedVerticies[1]                                       = component;

    }
    //endregion

    //region Getters and Setters
    public void setDraggable(boolean draggable)
    {

        this.draggable                                              = draggable;

    }

    public int getNumberOfVertices()                                { return numberOfVertices; }
    public int[][] getAdjacencyMatrix()                             { return adjacencyMatrix; }
    public ArrayList<Vertex> getVertices()                          { return vertices; }
    public ArrayList<Edge>   getEdges()                             { return edges;     }
    public boolean getDraggable()                                   { return draggable; }
    //endregion

}
