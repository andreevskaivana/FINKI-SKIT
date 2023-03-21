package junit;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest3 {

    Message message=new Message("test message");

    @Test
    public void testGoodbyeTrue(){
        assertEquals(message.bye(),"Goodbye");
    }

    @Test
    public void testGoodbyeFalse(){
        assertNotEquals(message.bye(),"Goodbye 1");
    }
}
