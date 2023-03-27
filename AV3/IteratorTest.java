import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class IteratorTest {

    //mora da imame nesto niz koe ke iterirame
    private List<String> list;          // test fixture

    //mora da imame nesto sto ke ni pomaga da iterirame
    private Iterator<String> itr;       // test fixture

    //metod koj ni gi inicijalizra soodvetnite fixtures od koi
    //zavisime vo testiranjeto
    //rabotime so lista od stringovi
    @Before public void setUp()         // set up test fixture
    {
        list = new ArrayList<String>();
        list.add ("cat");
        list.add ("dog");
        //iteratorot mine niz ovaa lista
        itr = list.iterator();
    }


    // 3 Tests for Iterator method hasNext()
    //  The 2 characteristics associated with hasNext() are: (od koi karakteristiki zavisime) C1, C5

    // Test 1 of hasNext(): testHasNext_BaseCase():  C1-T, C5-T
    //c5 e za dali imalo concurent modifikacija
    @Test public void testHasNext_BaseCase()
    {
        //da vrati true ako iterator koj mine elementi naoga sleden element
        //vraka true bibdejki hasNext e boolean metod
        assertTrue (itr.hasNext());
    }

    // Test 2 of hasNext(): testHasNext_C1(): C1-F, C5-T
    //c5 e true bidejki nemame praveno modifikacija vo listata
    @Test public void testHasNext_C1()
    {
        //iteratorot gi mine dvata(i edinstveni elementi vo nizata)
        itr.next(); itr.next();        // consume the cat and the dog
        //da vrati false bidejki veke nema sledni elementi
        assertFalse (itr.hasNext());    // now empty
    }

    // Test 3 of hasNext(): testHasNext_C5(): C1-T, C5-F
    //c5 e false bidejki imame praveno modifikacija vo listata
    //c5-collection not modified znaci ne bil frlen isklucok
    //koga e false imalo modifikacija
    // This test fails!
    // The reason is that standard Java implementations of the Iterator
    // interface are not consistent in their use of ConcurrentModificationException.
    @Test(expected=ConcurrentModificationException.class)
    //ocekuvan c5 exception
    public void testHasNext_C5()
    {
        list.add ("elephant");
        itr.hasNext();
    }


    // 4 Tests for Iterator method next()
    // The 3 characteristics associated with next() are: C1, C2, C5

    // Test 1 of next(): testNext_BaseCase(): C1-T, C2-T, C5-T
    @Test public void testNext_BaseCase()
    {
        assertEquals ("cat", itr.next());
    }

    // Test 2 of next(): testNext_C1(): C1-F, C2-F, C5-T
    //nema sleden el i ne go vraka
    //nema elementi i ocekuva takov isklucok
    @Test(expected=NoSuchElementException.class)
    public void testNext_C1()
    {
        itr.next(); itr.next();        // consume the cat and the dog
        itr.next();                    // now empty
    }

    // Test 3 of next(): testNext_C2(): C1-T, C2-F, C5-T
    //za da vrati null mora da se kreira nova lista kade element e null
    //c5 e true oti nema modifikacija
    //ova go pravime bidejki c1 e true znaci deka ima elementi ama c2 e false oti ni vraka false za toa deka vraka nekakov element, ni vraka null
    @Test public void testNext_C2()
    {
        list = new ArrayList<String>();
        list.add (null);
        itr = list.iterator();
        assertNull (itr.next());
    }

    // Test 4 of next(): testNext_C5(): C1-T, C2-F, C5-F
    //promena vo listata
    @Test(expected=ConcurrentModificationException.class)
    public void testNext_C5()
    {
        list.add ("elephant");
        itr.next();
    }


    // 6 Tests for Iterator method remove()
    // The 5 characteristics associated with remove() are: C1, C2, C3, C4, C5

    // Test 1 of remove(): testRemove_BaseCase(): C1-T, C2-T, C3-T, C4-T, C5-T
    @Test public void testRemove_BaseCase()
    {
        itr.next();
        itr.remove();
        assertFalse (list.contains ("cat"));
    }

    // Test 2 of remove(): testRemove_C1(): C1-F, C2-F, C3-T, C4-T, C5-T
    @Test public void testRemove_C1()
    {
        itr.next(); itr.next();        // consume the cat and the dog
        itr.remove();                  // remove dog from list.
        assertFalse (list.contains ("dog"));
    }

    // Test 3 of remove(): testRemove_C2(): C1-T, C2-F, C3-T, C4-T, C5-T
    @Test public void testRemove_C2()
    {
        list.add (null);
        list.add ("elephant");
        itr = list.iterator();
        itr.next(); itr.next();        // consume the cat and the dog
        itr.next();        // consume null; iterator not empty
        itr.remove();      // remove null from list
        assertFalse (list.contains (null));
    }

    // Test 4 of remove(): testRemove_C3(): C1-T, C2-T, C3-F, C4-T, C5-T
    @Test(expected=UnsupportedOperationException.class)
    public void testRemove_C3()
    {
        //lista koja ne smee da se modifikuva
        list = Collections.unmodifiableList (list);
        itr = list.iterator();
        itr.next();   // consume first element to make C4 true
        itr.remove();
    }

    // Test 5 of remove(): testRemove_C4(): C1-T, C2-T, C3-T, C4-F, C5-T
    @Test (expected=IllegalStateException.class)
    public void testRemove_C4()
    {
        itr.remove();
    }


    // Test 6 of next(): testRemove_C5(): C1-T, C2-T, C3-T, C4-T, C5-F
    @Test (expected=ConcurrentModificationException.class)
    public void testRemove_C5()
    {
        itr.next();
        list.add ("elephant");
        itr.remove();
    }

}