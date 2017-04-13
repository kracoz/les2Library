import org.hamcrest.collection.IsMapContaining;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


/**
 * Created by kracoz on 14.03.2017.
 */
public class StringLes2Test {
    private  StringLes2 les2;
    private  String data;
    Map<String,StringBuilder> expected;
    Map<String,StringBuilder> actual;

    @Before
    public void initTest(){
        les2 = new StringLes2();
        data = "sdfgsfd 34dfg411 ggssa Dfg4";
        expected = new HashMap<>();
        expected.put("gs",new StringBuilder("sdfgsfd ggssa "));
    }

    @After
    public void afterTest(){
        les2 = null;
        data = null;
        actual = null;
        expected = null;
        ArrayList<Integer> list = new ArrayList<>();
        List tm = list;
    }
    @Ignore
   // @Test
    public void testfilter() throws Exception {
        actual = les2.wordsContainsRequest(data,"gs", false);
        System.out.println("Into test");
      //  assertEquals(actual,expected);                  //This test will pass if the two Sets are the same size and contain the same elements.
                                                        // Works for Map too
        assertThat(actual, IsMapContaining.hasEntry("gs", "sdfgsfd ggssa "));
    }
   /* public static void main(String[] data) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(StringLes2Test.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }*/

}