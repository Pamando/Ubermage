package com.ubermage.www.ubermage.tools;

import java.util.ArrayList;

/**
 * Created by laowai on 31.03.2015.
 * tensor class
 * coordinate root 0
 */
public class Tensor<T> {
    private final Dims dims;
    ArrayList<T> tensor;
    Tensor(Dims dims){
        dims.scrub();
        this.dims=dims;
        long sum=1;
        int susum=1;
        for(int i=0;i<dims.level();i++){
            sum*=dims.get(i);
            susum*=dims.get(i);
        }
        if(susum!=sum){
            throw new IllegalArgumentException("Tensor too large for data structure!");
        }
        tensor=new ArrayList<T>(susum);
        for(T x:tensor) x=null; //OPTIMIZE maybe unneeded

    }
    void set(Coordinate position, T input){
        tensor.set(locate(position),input);
    }
    boolean set_Silent(Coordinate position, T input){
        try{
            set(position,input);
        }catch(IllegalArgumentException e){
            return false;
        }
        return true;
    }
    T get(Coordinate position){
        return tensor.get(locate(position));
    }

    /**
     * if there's a bug, it's likely here
     * @param location root 0
     * @return array position
     */
    private int locate(Coordinate location){
        if(location.level()>dims.level()){
            throw new IllegalArgumentException("Location Superdimensional!");
        }
        int pos=0;
        int sum=1;
        for(int i=0;i<location.level();i++){
            if(location.get(i)>=dims.get(i)){
                throw new IllegalArgumentException("Location out of bounds at Lv "+i+".");
            }
            pos=pos+(sum*location.get(i)); // set pos=pos+(sum*location.get(i)-1) if coords have root 0;
            sum=sum*dims.get(i);
        }
        return pos;
    }

}
