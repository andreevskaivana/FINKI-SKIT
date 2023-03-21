package junit;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {

    String message="Tom";
    Message messageObj=new Message(message);

    public MessageTest(String message) {
        this.message = message;
    }

    @Test
    public void testPrintMessageTrue(){
        assertEquals(message,messageObj.printMessage());
        //proto e ona sto go ocekuvame,vtoroto e ona sto go dobivame kako vistinski rez
    }

    @Test
    public void testPrintMessageFalse(){
        assertEquals("Mark",messageObj.printMessage());
    }

}
