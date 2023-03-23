import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class PrimeCheckerTest {

    private PrimeNumberChecker primeNumberChecker;

    @BeforeEach
    //ke se vrsi pred sekoj test,pred sekoja instanca
    public void init(){
        //incijalizirame se ona sto ni treba pred sekoj test
        primeNumberChecker=new PrimeNumberChecker();
    }

    //vrednost(int) i bool-nekoj vid na mapa
    public static Collection<Object[]>numbers(){
        return Arrays.asList(new Object[][]{
                //inline deklaracija na niza
                //vrapuvana vo kolekcija
                {2,true},
                {6,false},
                {28,false},
                {19,true}
        });
    }

    @ParameterizedTest
    @MethodSource("numbers") //vrednostite ke gi zima od metod
    public void testPrimeNumberChecker(int number,boolean expectedResult){
        //kako ke se zemaat podatocite od numbers, soodvetno da se predavaat kako argumenti
        System.out.println("Number: "+number+" , expected Result: "+expectedResult);
        assertEquals(expectedResult,primeNumberChecker.validate(number));
    }

}
