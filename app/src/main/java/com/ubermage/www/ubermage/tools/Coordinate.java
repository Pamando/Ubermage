package com.ubermage.www.ubermage.tools;

/**
 * Created by laowai on 31.03.2015.
 */
public class Coordinate extends Dims{
    Coordinate(int x, int y){
        super();
        add(x);
        add(y);
    }
    int x(){return get(0);}
    int y(){return get(1);}
    void x(int in){set(0,in);}
    void y(int in){set(1,in);}
}
