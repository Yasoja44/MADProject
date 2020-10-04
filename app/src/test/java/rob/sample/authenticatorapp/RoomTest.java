package rob.sample.authenticatorapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class RoomTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    private  RoomServiceAdd roomServiceAdd;

    @Before
    public void setup(){
        roomServiceAdd = new RoomServiceAdd();
    }

    @Test
    public void testTotal(){
        //give the right output
        Double result1 = roomServiceAdd.findTotal(1000.0,2.0);
        assertEquals(2000.0,result1,0.0001);

        Double result2 = roomServiceAdd.findTotal(1000.0,3.0);
        assertEquals(2700.0,result2,0.0001);

        //give the wrong output
        Double result3 = roomServiceAdd.findTotal(1000.0,4.0);
        assertEquals(3601.0,result3,0.0001);

        Double result4 = roomServiceAdd.findTotal(1000.0,1.0);
        assertEquals(900.0,result4,0.0001);
    }
}
