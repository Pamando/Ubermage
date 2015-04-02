package com.ubermage.www.ubermage.tools.ocr.g0;

import java.util.ArrayList;

/**
 * takes only 5x5 bitArray, so Arraylist Boolean (25)
 * Created by laowai.reaxyl (Maertin Dietreich) on 02.04.2015 for Ubermage.
 */
public class g0_1 {
    /**
     * submit bitList db;
     * @param db
     */
    ArrayList<Boolean []> db;
    public g0_1(ArrayList<Boolean []> db){
        this.db=db;
    }
    public int parse(Boolean [] in){
        outLoop: for(int i=0; i<db.size();i++){
            for(int j=0;j<25;j++){
                if(!db.get(i)[j].equals(in[j])) continue outLoop;
            }
            return i;
        }
        return -1;
    }

}
