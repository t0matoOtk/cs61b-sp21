package tester;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void MyFirstTest(){
        StudentArrayDeque<Integer> Test_Array = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> Correct_Array = new ArrayDequeSolution<>();
        String s = "";
        String operation = "";
        for (int i=0; i<10000;i++){
            int target = StdRandom.uniform(0,6);
            if (target == 0){
                int rand = StdRandom.uniform(0,100);
                operation = "addFirst(" + rand + ")\n";
                s += operation;
                Test_Array.addFirst(rand);
                Correct_Array.addFirst(rand);
            } else if (target == 1) {
                int rand = StdRandom.uniform(0,100);
                operation = "addLast(" + rand + ")\n";
                s += operation;
                Test_Array.addLast(rand);
                Correct_Array.addLast(rand);
            } else if (target == 2 && !Test_Array.isEmpty()) {
                Integer a = Correct_Array.removeFirst();
                Integer b = Test_Array.removeFirst();
                operation = "removeFirst(): "+ b +"\n";
                s += operation;
                Assert.assertEquals(s,a,b);
            } else if (target == 3 && !Test_Array.isEmpty()) {
                Integer a = Correct_Array.removeLast();
                Integer b = Test_Array.removeLast();
                operation = "removeLast(): "+ b +"\n";
                s += operation;
                Assert.assertEquals(s,a,b);
            } else if (target == 4) {
                boolean a = Correct_Array.isEmpty();
                boolean b = Test_Array.isEmpty();
//                operation = "isEmpty(): "+ b +"\n";
                s += operation;
                Assert.assertEquals(s,a,b);
            } else if (target == 5) {
                Integer a = Correct_Array.size();
                Integer b = Test_Array.size();
//                operation = "size(): "+ b +"\n";
                s += operation;
                Assert.assertEquals(s, Correct_Array.size(),Test_Array.size());
            }
        }


    }
}
