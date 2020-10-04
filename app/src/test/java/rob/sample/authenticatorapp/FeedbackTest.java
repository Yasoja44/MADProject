package rob.sample.authenticatorapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FeedbackTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    private  feedbackUser feedUser;

    @Before
    public void setup(){
        feedUser = new feedbackUser();
    }

    @Test
    public void testTotal(){
        //give right output
        Boolean result1 = feedUser.FeedbackCheck("The hotel is very good");
        assertEquals(true,result1);

        Boolean result2 = feedUser.FeedbackCheck("good");
        assertEquals(false,result2);

        //give wrong output
        Boolean result3 = feedUser.FeedbackCheck("goodasdasdaqaweqweqwesdasdasd");
        assertEquals(false,result3);

        Boolean result4 = feedUser.FeedbackCheck("goodas");
        assertEquals(true,result4);


    }
}
