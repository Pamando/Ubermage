package com.ubermage.www.ubermage.db;
//PATRIK IST EIN ...
import java.util.ArrayList;

/**
 * db prototype containing database of symbols and their names maybe
 * Created by laowai.reaxyl (Maertin Dietreich) on 02.04.2015 for Ubermage.
 */
public class d5x5 {
    public static ArrayList<Boolean[]> get(){
        ArrayList<Boolean[]> out = new ArrayList<>();
        final Boolean o=false, x=true;
        { //null
            Boolean[] local = new Boolean[]
                    {
                            o,o,o,o,o,
                            o,o,o,o,o,
                            o,o,o,o,o,
                            o,o,o,o,o,
                            o,o,o,o,o
                    };
            out.add(local);
        }
        { //F
            Boolean[] local = new Boolean[]
                    {
                            x,x,x,x,x,
                            x,o,o,o,o,
                            x,x,x,x,x,
                            x,o,o,o,o,
                            x,o,o,o,o
                    };
            out.add(local);
        }
        { //U (X)
            Boolean[] local = new Boolean[]
                    {
                            x,o,o,o,x,
                            o,x,o,x,o,
                            o,o,x,o,o,
                            o,x,o,x,o,
                            x,o,o,o,x
                    };
            out.add(local);
        }
        { //U (X)
            Boolean[] local = new Boolean[]
                    {
                            x,o,o,o,o,
                            x,o,o,o,o,
                            x,o,o,o,o,
                            x,o,o,o,o,
                            x,o,o,o,o
                    };
            out.add(local);
        }



           //TODO all the others


        return out;
    }
}
