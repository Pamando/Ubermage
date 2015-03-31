package com.ubermage.www.ubermage.tools;

import java.util.ArrayList;

/**
 * Created by laowai on 31.03.2015.
 * level starts at 0;
 *
 * instead of deleting dims, set them to 1 and call scrub;
 */
public class Dims {
    private ArrayList<Integer> dims;
    Dims(Dims dims){
        this.dims=dims.dims;
    }
    Dims(int x, int y, int z){
        dims = new ArrayList<Integer>(3);
        add(x); add(y); add(z);
    }
    Dims(){
        dims = new ArrayList<Integer>();
    }
    public void add(int newDim){
        if(newDim < 1){
            throw new IllegalArgumentException("dims cannot be less than 1. Learn some math noob");
        }
        dims.add(newDim);
    }
    public void set(int level, int value){
        while(level > dims.size()-1){
            dims.add(1);
        }
        dims.set(level, value);
    }
    /**
     * @return number of spanned dimensions
     */
    public int level(){
        return dims.size();
    }

    /**
     * @return approximation of size
     */
    public double size(){
        double out=1;
        for(int x:dims){
            out*=x;
        }
        return out;
    }

    /**
     * @param level
     * @return
     */
    public int get (int level){
        if(level>dims.size()-1){
            return 1;
        }
        if(level<0){
            throw new IllegalArgumentException("level cannot be less than 0. Learn some math noob. string theory is a sham");
        }
        return dims.get(level);
    }

    /**
     * alias of get(level)
     * @param level
     * @return dim
     */
    public int d(int level){
        return get(level);
    }

    /**
     * scrubs array of redundant info
     * you do not need to call this normally
     * @return number scrubbed levels
     */
    public int scrub(){
        int c= 0;
        for(int i=dims.size()-1;i>0;i--){
            if(dims.get(i)==1){
                dims.remove(i);
                c++;
            }
            else return c;
        }
        return c;
    }

}
