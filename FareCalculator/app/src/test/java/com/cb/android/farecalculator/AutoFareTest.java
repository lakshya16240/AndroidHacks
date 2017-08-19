package com.cb.android.farecalculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by GhanshamBansal on 23/07/17.
 */

public class AutoFareTest {

    @Test
    public void calcFare() throws  Exception{
        assertEquals("Fares do not match" , 41f,MainActivity.calcFare(4,0),0.001f);
    }
}
