package com.sda.bookingproject.reservation.app.utility;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> splitStringByComma(final String params){

        if(params == null){

            throw new IllegalStateException("Params should not be null!");
        }

        return Arrays.asList(params.split(","));

    }

}
