/*
  Name: Your Name
  PID:  A12345678
 */
import java.util.ArrayList;

import org.junit.*;

import java.util.AbstractList;
import static org.junit.Assert.*;

/**
 * DLL Application Test
 * @author Ezhil Thaenraj
 * @since  02/4/2021
 */
public class DoublyLinkedListTest {
    DoublyLinkedList<Integer> testList;

    @Before
    public void setup() {
        testList = new DoublyLinkedList<Integer>();
    }

    /*
      Recap: Assert exception without message
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void DLLAddThrowsIOB() {
        testList.add(-1,1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void DLLGetThrowsIOB() {
        testList.get(-1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void DLLRemoveThrowsIOB() {
        testList.remove(-1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void DLLSetThrowsIOB() {
        testList.set(-1,2);
    }
    @Test (expected = NullPointerException.class)
    public void DLLAddThrowsNPE(){testList.add(null);}
    @Test (expected = NullPointerException.class)
    public void DLLSetThrowsNPE(){testList.set(1,null);}

    /*
      DLL Tests
     */
    @Test
    public void AddTest() {
        String expected = "[(head) -> 5 -> 4 -> 6 -> 1 -> 2 -> 3 -> (tail)]";
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(0,4);
        testList.add(0,5);
        testList.add(2,6);

        String check = testList.toString();
        if(!check.equals(expected)){fail();}
    }
    @Test
    public void ClearAndEmptyTest(){
        for(int i = 0; i < 10; i++){
            testList.add(i);
            testList.add(i,0);
        }
        testList.clear();
        if(testList.isEmpty() == false){fail();}
        for(int i = 0; i < 15; i++){
            testList.add(i);
        }
        testList.clear();
        if(testList.isEmpty() == false){fail();}
        for(int i = 0; i < 4; i++){
            testList.add(i);
        }
        testList.clear();
        if(testList.isEmpty() == false){fail();}
    }
    @Test
    public void containTest(){
        for(int i = 0; i < 10; i++){
            testList.add(i);
            testList.add(i,0);
        }
        if(testList.contains(0) == false){fail();}
        for(int i = 0; i < 15; i++){
            testList.add(i);
        }
        if(testList.contains(14) == false){fail();}
        for(int i = 0; i < 4; i++){
            testList.add(i);
        }
        if(testList.contains(2) == false){fail();}

    }
    @Test
    public void getTest(){
        for(int i = 0; i < 15; i++){
            testList.add(i);
        }
        if(testList.get(12) != 12){fail();}
        if(testList.get(11) != 11){fail();}
        if(testList.get(12) != 12){fail();}

    }
    @Test
    public void removeTest(){
        for(int i = 0; i < 15; i++){
            testList.add(i);
        }
        for(int i = 0; i < 15; i++){testList.remove(0);}
        if(testList.isEmpty() == false){fail();}
    }

    @Test
    public void setTest(){
        for(int i = 0; i < 3; i++){
            testList.add(i);
        }
        for(int i = 1; i < 4; i++){
            testList.set(i-1,i);
        }
        String expected = "[(head) -> 1 -> 2 -> 3 -> (tail)]";
        String actual = testList.toString();
        if(expected.equals(actual) == false){fail();}
    }

    @Test
    public void sizeTest(){
        for(int i = 0; i < 3; i++){
            testList.add(i);
        }
        if(testList.size() != 3){fail();}
        testList.remove(0);
        if(testList.size() != 2){fail();}
        testList.remove(0);
        if(testList.size() != 1){fail();}
        testList.remove(0);
        if(testList.size() != 0){fail();}
    }

    @Test
    public void toStringCheck(){
        if(testList.toString().equals("[(head) -> (tail)]") == false){fail();}
        testList.add(1);
        if(testList.toString().equals("[(head) -> 1 -> (tail)]") == false){fail();}
        testList.add(2);
        if(testList.toString().equals("[(head) -> 1 -> 2 -> (tail)]") == false){fail();}
    }
}
