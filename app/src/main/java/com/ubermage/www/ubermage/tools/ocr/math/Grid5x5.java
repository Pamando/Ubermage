package com.ubermage.www.ubermage.tools.ocr.math;

import java.util.ArrayList;

/**
 * Created by laowai on 31.03.2015.
 */
public class Grid5x5 {
    ArrayList<Coordinate> gridList;
    Grid5x5(){
        gridList=new ArrayList<Coordinate>(10); //10 is arbitrary
    }
    Grid5x5(Grid5x5 in){
              gridList=in.gridList;
    }

    /**
     * x and y range 0-4 each
     * @param x
     * @param y
     */
    void add(int x, int y){
        if(x > 4 || y > 4){
            throw new IllegalArgumentException("grid5x5 out of bounds"); //TODO everything
        }
        gridList.add(new Coordinate(x,y));
    }
    int length(){
        return gridList.size();
    }

    /**
     * remove last element. false if empty
     * @return success
     */
    boolean redact(){
        if(gridList.size()<1){
            return false;
        }
        gridList.remove(gridList.size() - 1);
        return true;
    }


}
