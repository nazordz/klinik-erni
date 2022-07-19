/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.util;

import com.mycompany.maven.app.enumeration.MedicineUse;

/**
 *
 * @author mac
 */
public class MedicineUtil {
    public static String medicineUseToString(MedicineUse use) {
        String str = "";
        if (use == MedicineUse.ONE_TIME_THREE) {
            str = "1x3";
        } else if (use == MedicineUse.ONE_TIME_TWO) {
            str = "1x2";
        } else if (use == MedicineUse.TWO_TIME_ONE) {
            str = "2x1";
        }
        return str;
    }
}
