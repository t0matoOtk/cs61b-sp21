package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testOperations() {
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> BL = new BuggyAList<>();
      for (int i = 0; i < 5000; i++) {
          int operationNumber = StdRandom.uniform(0, 3);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              BL.addLast(randVal);
          } else if (operationNumber == 1) {
              // size
              assertEquals(L.size(), BL.size());
          } else if (operationNumber == 2 && L.size() > 0){
          assertEquals(L.getLast(), BL.getLast());
          } else if (operationNumber == 3 && L.size() > 0){
                assertEquals(L.removeLast(),BL.removeLast());
          }
      }
  }
}
