import org.junit.*;
import static org.junit.Assert.*;

//Test Unitaires

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int[] a = new int[]{ 2,3,4,5,1 };
        int[] b = new int[]{ 3,3,4,5,1 };
        int[] c = new int[]{ 2,3,4,5,1 };

        
        int actual = Yatzy.chance(a);
        assertEquals(expected, actual);
        assertEquals(16, Yatzy.chance(b));
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int[] a = new int[]{4,4,4,4,4 };
        int[] b = new int[]{ 6,6,6,6,6 };
        int[] c = new int[]{ 6,6,6,6,3 };
        int actual = Yatzy.yatzy(a);
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.yatzy(b));
        assertEquals(0, Yatzy.yatzy(c));
    }

    @Test public void test_1s() {
    	 int[] premier = new int[]{ 1,2,5,4,5 };
    	 int[] a = new int[]{ 1,2,1,4,5 };
         int[] b = new int[]{ 6,2,2,4,5 };
         int[] c = new int[]{ 1,2,1,1,1 };
        assertTrue(Yatzy.ones(premier) == 1);
        assertEquals(2, Yatzy.ones(a));
        assertEquals(0, Yatzy.ones(b));
        assertEquals(4, Yatzy.ones(c));
    }

    @Test
    public void test_2s() {
    	
    	 int[] a = new int[]{ 1,2,3,2,6 };
         int[] b = new int[]{ 2,2,2,2,2 };
         int[] c = new int[]{ 2,3,4,5,1 };
        assertEquals(4, Yatzy.twos(a));
        assertEquals(10, Yatzy.twos(b));
    }

    @Test
    public void test_threes() {
    	int[] a = new int[]{ 1,2,3,2,3 };
        int[] b = new int[]{ 2,3,3,3,3 };
        int[] c = new int[]{ 2,3,4,5,1 };
        assertEquals(6, Yatzy.threes(a));
        assertEquals(12, Yatzy.threes(b));
    }

    @Test
    public void fours_test() 
    {
    	int[] a = new int[]{ 4,4,4,5,5 };
        int[] b = new int[]{ 4,4,5,5,5 };
        int[] c = new int[]{ 4,5,5,5,5 };
        assertEquals(12, new Yatzy(a).fours());
        assertEquals(8, new Yatzy(b).fours());
        assertEquals(4, new Yatzy(c).fours());
    }

    @Test
    public void fives() {
    	int[] a = new int[]{ 4,4,4,5,5 };
        int[] b = new int[]{ 4,4,5,5,5 };
        int[] c = new int[]{ 4,5,5,5,5 };
        assertEquals(10, new Yatzy(a).fives());
        assertEquals(15, new Yatzy(b).fives());
        assertEquals(20, new Yatzy(c).fives());
    }

    @Test
    public void sixes_test() {
    	int[] a = new int[]{ 4,4,4,5,5 };
        int[] b = new int[]{ 4,4,6,5,5 };
        int[] c = new int[]{ 4,5,6,6,6 };
        assertEquals(0, new Yatzy(a).sixes());
        assertEquals(6, new Yatzy(b).sixes());
        assertEquals(18, new Yatzy(c).sixes());
    }

    @Test
    public void one_pair() {
    	int[] a = new int[]{ 3,4,3,5,6 };
        int[] b = new int[]{ 5,3,3,3,5 };
        int[] c = new int[]{ 5,3,6,6,5 };
        assertEquals(6, Yatzy.score_pair(a));
        assertEquals(10, Yatzy.score_pair(b));
        assertEquals(12, Yatzy.score_pair(c));
    }

    @Test
    public void two_Pair() {
    	int[] a = new int[]{ 3,3,5,4,5 };
        int[] b = new int[]{ 3,3,5,5,5 };
        int[] c = new int[]{ 5,3,6,6,5 };
        assertEquals(16, Yatzy.two_pair(a));
        assertEquals(16, Yatzy.two_pair(b));
    }

    @Test
    public void three_of_a_kind() 
    {
    	int[] a = new int[]{ 3,3,3,4,5 };
        int[] b = new int[]{ 5,3,5,4,5 };
        int[] c = new int[]{ 3,3,3,3,5 };
        assertEquals(9, Yatzy.three_of_a_kind(a));
        assertEquals(15, Yatzy.three_of_a_kind(b));
        assertEquals(9, Yatzy.three_of_a_kind(c));
    }

    @Test
    public void four_of_a_knd() {
    	int[] a = new int[]{ 3,3,3,3,5 };
        int[] b = new int[]{ 5,5,5,4,5 };
        int[] c = new int[]{ 3,3,3,3,3 };
        assertEquals(12, Yatzy.four_of_a_kind(a));
        assertEquals(20, Yatzy.four_of_a_kind(b));
        assertEquals(9, Yatzy.three_of_a_kind(c));
    }

    @Test
    public void smallStraight() {
    	int[] a = new int[]{ 1,2,3,4,5 };
        int[] b = new int[]{ 2,3,4,5,1 };
        int[] c = new int[]{ 1,2,2,4,5 };
        assertEquals(15, Yatzy.smallStraight(a));
        assertEquals(15, Yatzy.smallStraight(b));
        assertEquals(0, Yatzy.smallStraight(c));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
    	int[] a = new int[]{ 6,2,2,2,6 };
        int[] b = new int[]{2,3,4,5,6 };
        int[] c = new int[]{ 5,3,6,6,5 };
        assertEquals(18, Yatzy.fullHouse(a));
        assertEquals(0, Yatzy.fullHouse(b));
    }
}


