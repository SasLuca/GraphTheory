package com.luca.graphtheory.assets;

/**
 * Created by Sas on 11/17/2015.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.forms.L_Sprite;

import static java.lang.Math.toDegrees;
import static java.lang.Math.acos;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Edge extends L_Object
{

    private     Vertex          vertex1;
    private     Vertex          vertex2;

    private     L_Sprite        edge;

    private     float           rotation;

    public Edge(Vertex vertex1, Vertex vertex2)
    {

        this.vertex1            = vertex1;

        this.vertex2            = vertex2;

        edge                    = new L_Sprite("Edge.png", Color.BLUE, new Vector2(vertex1.getX() + vertex1.getWidth()/2, vertex1.getY() + vertex1.getHeight()/2));

        setSize                 (distanceOfTwoPoints(vertex1.getX() + vertex1.getWidth()/2, vertex2.getX() + vertex2.getWidth()/2, vertex1.getY() + vertex1.getHeight()/2, vertex2.getY() + vertex2.getHeight()/2));

        calculateEdge();

    }

    private float distanceOfTwoPoints(float X1, float X2, float Y1, float Y2)
    {

        return                  ((float)sqrt(pow(floatToDouble(X1 - X2), 2) + pow(floatToDouble(Y1 - Y2), 2)));

    }

    private double floatToDouble(float f)
    {

        return                  Double.parseDouble(new Float(f).toString());

    }

    public void calculateEdge()
    {

        resize();

        edge.                   setPosition(vertex1.getX() + vertex1.getWidth()/2 - 5, vertex1.getY() + vertex1.getHeight()/2 - 5);

        rotation                = (float) toDegrees(acos(((pow(floatToDouble(edge.getWidth()), 2) + pow(floatToDouble(edge.getWidth()), 2) - pow(distanceOfTwoPoints(edge.getX() + edge.getWidth(), vertex2.getX() + vertex2.getWidth() / 2 - 5, edge.getY(), vertex2.getY() + vertex2.getHeight() / 2 - 5), 2)) / (2 * pow(floatToDouble(edge.getWidth()), 2)))));

        edge.getSprite().       setRotation(vertex2.getY() < vertex1.getY() ? -rotation : rotation);

    }

    public void setSize(float newSize)
    {

        edge.                   setSize(newSize, 10);

    }

    @Override
    public void render()
    {

        edge.                   render();

    }

    public void resize()
    {

        setSize(distanceOfTwoPoints(vertex1.getX() + vertex1.getWidth() / 2, vertex2.getX() + vertex2.getWidth() / 2, vertex1.getY() + vertex1.getHeight() / 2, vertex2.getY() + vertex2.getHeight() / 2));

    }

    public Vertex getVertex1() { return vertex1; }
    public Vertex getVertex2() { return vertex2; }

}
