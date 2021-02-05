import java.util.ArrayList;

import org.junit.*;

import java.util.AbstractList;
import static org.junit.Assert.*;

/**
 * DLL Stack Test
 * @author Ezhil Thaenraj
 * @since  02/04/2021
 */
public class DLLStackTest {
    DLLStack<Integer> testStack;

    @Before
    public void setup() {
        testStack = new DLLStack<Integer>();
    }

    /*
      Recap: Assert exception without message
     */
    @Test
    public void sizePushTest() {
        if (testStack.size() != 0) {
            fail();
        }
        testStack.push(1);
        if (testStack.size() != 1) {
            fail();
        }
        testStack.push(2);
        if (testStack.size() != 2) {
            fail();
        }
        testStack.push(3);
        if (testStack.size() != 3) {
            fail();
        }
    }
    @Test
    public void popEmptyTest(){
        for(int i = 0; i < 3; i++){
            testStack.push(i);
        }
        for(int i = 0; i < 3; i++){
            testStack.pop();
        }
        if(testStack.isEmpty() == false){fail();}
        testStack.push(1);
        if(testStack.isEmpty() == true){fail();}
        testStack.pop();
        if(testStack.isEmpty() == false){fail();}
    }

    @Test
    public void peekTest(){
        for(int i = 1; i < 4; i++){
            testStack.push(i);
        }
        if(testStack.peek() != 3){fail();}
        testStack.pop();
        if(testStack.peek() != 2){fail();}
        testStack.pop();
        if(testStack.peek()!= 1){fail();}
    }
}
