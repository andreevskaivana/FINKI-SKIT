//import org.testng.annotations.Test;

import org.junit.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest1 {
    String msg="Tom";
    Message message=new Message(msg);

    @Test
    public void testPrintMsgTrue(){
        assertEquals(msg,message.printMessage());
    }
    @Test
    public void testPrintMsgFalse(){
        assertEquals("Mark",message.printMessage());
    }

    @Test
    public void testPrintMsgWithDuration(){
        assertTimeout(Duration.ofMillis(5000),()->{
//            System.out.println("Message: "); ->kolku da se znae deka sme vo metodot
            message.printMessage();
            //tuka odi thread vrzan metod
            //Thread.sleep(1000);
        });
    }
}
