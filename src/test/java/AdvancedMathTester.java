import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AdvancedMathTester {

    @InjectMocks
    AdvancedMath advancedMath = new AdvancedMath();

    @Mock
    BasicMath basicMath;


    @Test // Test 1
    public void testMultiplyDifferenceBy5() {
        when(basicMath.subtract(80.0, 20.0)).thenReturn(60.0);
        Assert.assertEquals(advancedMath.multiplyDifferenceBy5(80.0, 20.0), 300.0, 0);
    }

    @Test // Test 2
    public void testMultiplySumBy5() {
        when(basicMath.multiply(basicMath.add(75.0, 25.0), 5)).thenReturn(500.0);
        Assert.assertEquals(advancedMath.multiplySumBy5(75.0, 25.0), 500.0, 0);
    }

    @Test // Test 3
    public void testSquareOfSum() {
        when(basicMath.add(20.0, 20.0)).thenReturn(40.0);
        Assert.assertEquals(advancedMath.squareOfSum(20.0, 20.0), 1600.0, 0);

        // Use verify to check if add method has been called at least twice
        verify(basicMath, atLeast(2)).add(20.0, 20.0);
        verify(basicMath, times(2)).add(20.0, 20.0);
    }

    @Test // Test 4
    public void testGetPercentage() {
        when(basicMath.divide(50.0, 100.0)).thenReturn(0.50);
        Assert.assertEquals(advancedMath.getPercentage(50.0, 100.0), 50, 0);

        reset(basicMath);
        Assert.assertEquals(advancedMath.getPercentage(50.0, 100.0), 00.0, 0);
    }

    // -----------------------Convert Test 1-4 using BDD---------------------------------

    @Test // Test 5: Test 1 BDD Format
    public void test1BDDFormat() {
        //Given
        given(basicMath.subtract(80.0, 20.0)).willReturn(60.0);

        //When
        double result = advancedMath.multiplyDifferenceBy5(80.0, 20.0);

        //Then
        Assert.assertEquals(result, 300.0, 0);
    }

    @Test // Test 6: Test 2 BDD Format
    public void test2BDDFormat() {
        //Given
        given(basicMath.multiply(basicMath.add(75.0, 25.0), 5)).willReturn(500.0);

        //When
        double result = advancedMath.multiplySumBy5(75.0, 25.0);

        //Then
        Assert.assertEquals(result, 500.0, 0);
    }

    @Test // Test 7: Test 3 BDD Format
    public void test3BDDFormat() {
        //Given
        given(basicMath.add(20.0, 20.0)).willReturn(40.0);

        //When
        Assert.assertEquals(advancedMath.squareOfSum(20.0, 20.0), 1600.0, 0);


        //Then
        verify(basicMath, atLeast(2)).add(20.0, 20.0);
        verify(basicMath, times(2)).add(20.0, 20.0);
    }

    @Test // Test 8: Test 4 BDD Format
    public void test4BDDFormat() {
        //Given
        given(basicMath.divide(50.0, 100.0)).willReturn(0.50);

        //When
        double result = advancedMath.getPercentage(50.0, 100.0);

        //Then
        Assert.assertEquals(result, 50, 0);

        // Reset the mock object
        reset(basicMath);

        //Test again the AdvancedMath's Percentage method
        Assert.assertEquals(advancedMath.getPercentage(50.0, 100.0), 00.0, 0);
    }

}
