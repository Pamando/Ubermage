package com.ubermage.www.ubermage.tools.ocr.math;

/**
 * Created by laowai.reaxyl (Maertin Dietreich) on 01.04.2015 for Ubermage.
 */
public class Matrix<T>{
    Tensor<T> matrix;
    Matrix(int x, int y){
        matrix = new Tensor<>(new Dims(x,y));
    }
    Dims getDims(){
        return matrix.getDims();
    }
    void set(Coordinate pos, T in){
        matrix.set(pos, in);
    }
    T get(int x, int y){
        return matrix.get(new Coordinate(x,y));
    }
    void set(T item, int x, int y){
        set(new Coordinate(x,y), item);
    }
}
