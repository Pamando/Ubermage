package com.ubermage.www.ubermage.tools.ocr;

import java.util.ArrayList;
import com.ubermage.www.ubermage.tools.ocr.g0.*;
/**
 * OCR master class. contains all OCR API calls. Read javadoc on individual methods
 *
 * Created by laowai.reaxyl (Maertin Dietreich) on 01.04.2015 for Ubermage.
 */
public class OCR {
    /**
     * compare 5x5 verbatim query to database.
     * @param query
     * @param database
     * @return code, -1 if not found.
     */
    public static int g0_1_1_5x5(Boolean[] query, ArrayList<Boolean []> database){
        g0_1 x = new g0_1(database);
        return x.parse(query);
    }

    /**
     * insert 5x5 array of Booleans, so Boolean[25].
     * @param query
     * @return name of input
     */
    public static String g0_1_2_5x5(Boolean[] query){
        return String.valueOf(g0_1_1_5x5(query,com.ubermage.www.ubermage.db.d5x5.get()));
    }
}
