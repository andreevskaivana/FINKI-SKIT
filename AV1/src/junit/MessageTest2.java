package junit;

import org.junit.Test;
import org.testng.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest2 {
    String message="Tom";
    Message messageObj=new Message(message);

    @Test
    public void testSalute(){
        assertEquals("Hi "+message,messageObj.salute());
    }
}
