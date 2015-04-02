package com.ubermage.www.ubermage.db;

/**
 * class delivering names of enumerated symbols
 * Created by laowai.reaxyl (Maertin Dietreich) on 02.04.2015 for Ubermage.
 */
public class EName {
    public static String get(int i){
        switch(i){
            case -1: return "no/faulty result";
            case 1:  return "F";
            case 2:  return "U";
            case 3:  return "Th";
            case 4:  return "A";
            case 5:  return "R";
            case 7:  return "K";
            default: return "not in enum db code: "+i+".";
        }

    }
}
