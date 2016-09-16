package ua.epam;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Viktoriia_Marynchak on 9/16/2016.
 */
public class ModelTest {
    Model model = new Model();

    @Test
    public void testChangeLeftRange() throws Exception {
        int insertNumber = 25;
        model.setNumber(50);
        model.changeRange(insertNumber, model.getLeftRange(), model.getRightRange());
        Assert.assertTrue(model.getLeftRange() == insertNumber);

    }

    @Test
    public void testChangeRightRange() throws Exception {
        int insertNumber = 75;
        model.setNumber(50);
        model.changeRange(insertNumber, model.getLeftRange(), model.getRightRange());
        Assert.assertTrue(model.getRightRange() == insertNumber);

    }

    @Test
    public void testRand() throws Exception {
        int insertNumber = 75;
        boolean isPass = false;
        int[] a = new int[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = model.rand(model.getLeftRange(), model.getRightRange());
        }
        for ( int i = 0; i < a.length; i++ ) {
            if ( insertNumber == a[i] ) {
                isPass = true;
            }
        }

        Assert.assertTrue(isPass);
    }

}