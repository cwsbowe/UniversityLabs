import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class DAGSortTest {

    DAGSort dag;

    @BeforeEach
    public void setUp() {
        dag = new DAGSort();
    }

    @AfterEach
    public void tearDown() {
        dag = null;
    }

    @DisplayName("Valid inputs")
    @Test
    void testSortDAGValid() {
        int[][] testArray0 = {{1}, {}};
        int[][] testArray1 = {{}, {}, {}, {}};
        int[][] testArray2 = {{4}, {2}, {3}, {0}, {}};
        int[][] testArray3 = {};
        int[][] testArray4 = {{2, 3, 7}, {2, 8}, {6, 4}, {4}, {}, {8, 9}, {3, 4, 5, 7, 8, 9}, {}, {9}, {7}};
        possibleAnswers(testArray0);
        possibleAnswers(testArray1);
        possibleAnswers(testArray2);
        possibleAnswers(testArray3);
        possibleAnswers(testArray4);
    }

    @DisplayName("Invalid node")
    @Test
    void testSortDAGInvalidNode() {
        int[][] testArray0 = {{7}};
        int[][] testArray1 = {{1, 2}, {}};
        int[][] testArray2 = {{}, {}, {-1}};
        int[][] testArray3 = {{1}, {2, 3}, {3}, {4}};
        int[][] testArray4 = {null};
        try {
            invalidInput(testArray0);
            fail();
        } catch (Exception e) {
        }
        try {
            invalidInput(testArray1);
            fail();
        } catch (Exception e) {
        }
        try {
            invalidInput(testArray2);
            fail();
        } catch (Exception e) {
        }
        try {
            invalidInput(testArray3);
            fail();
        } catch (Exception e) {
        }
        try {
            invalidInput(testArray4);
            fail();
        } catch (Exception e) {
        }
    }

    @DisplayName("Cycle")
    @Test
    void testSortDAGCycle() {
        int[][] testArray0 = {{0}};
        int[][] testArray1 = {{1}, {0}};
        int[][] testArray2 = {{2}, {2}, {3}, {4}, {1}};
        int[][] testArray3 = {{1}, {2, 3}, {3}, {4}, {1}};
        int[][] testArray4 = {{5}, {4}, {1}, {0}, {3}, {2}};
        try {
            invalidInput(testArray0);
            fail();
        } catch (Exception e) {
        }
        try {
            invalidInput(testArray1);
            fail();
        } catch (Exception e) {
        }
        try {
            invalidInput(testArray2);
            fail();
        } catch (Exception e) {
        }
        try {
            invalidInput(testArray3);
            fail();
        } catch (Exception e) {
        }
        try {
            invalidInput(testArray4);
            fail();
        } catch (Exception e) {
        }
    }

    void possibleAnswers(int[][] array) {
        try {
            int[] topOrdArray = dag.sortDAG(array);
            ArrayList<Integer> topOrd = new ArrayList<Integer>();
            for (int i : topOrdArray) {
                topOrd.add(i);
            }
            for (int i = 0; i < array.length; i++) {
                for (int j : array[i]) {
                    if (topOrd.indexOf(i) >= topOrd.indexOf(j)) {
                        fail();
                    }
                }
            }
        } catch (Exception e) {
            fail();
        }
    }

    void invalidInput(int[][] array) throws Exception{
        try {
            dag.sortDAG(array);
        } catch (Exception e) {
            throw(e);
        }
    }
}