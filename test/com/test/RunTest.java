package com.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {

    @DisplayName("test_msg1 on UtilTest")
    @Test void test_msg1() throws InterruptedException{
        // TimeUnit.SECONDS.sleep(5)
        assertEquals(Util.MSG_1, Util.msg1() );
    }
    
}
