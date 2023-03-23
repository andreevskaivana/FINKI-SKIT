import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertThrows;

public class DivisionTest {

    private Division division;

    @BeforeEach
    public void init(){
        //inicijalizacija na vrednostite za testiranje
        division=new Division();
    }

    @Test
    public void testDivision() {
        //prvo kazuvame sto isklucok ocekuvame
        //potoa sto povikuvame za toj isklucok
        assertThrows(ArithmeticException.class, () ->division.divide(12, 0));
    }
}
