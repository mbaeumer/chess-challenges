package se.mbaeumer.chesschallenges;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class QueenTest {

    @Test
    public void isHorizontalAllowed() {
        Queen queen = new Queen(new Position(0, 0));
        Assert.assertTrue(queen.isAllowed(new Position(5,0)));
        Assert.assertFalse(queen.isAllowed(new Position(2, 1)));
    }

    @Test
    public void isDiagonalAllowed() {
        Queen queen = new Queen(new Position(0, 0));
        Assert.assertTrue(queen.isAllowed(new Position(1,1)));
    }

    @Test
    public void isNotAllowed() {
        Queen queen = new Queen(new Position(0, 0));
        Assert.assertFalse(queen.isAllowed(new Position(2, 1)));
    }

    @Test
    public void getPotentialDestinations(){
        Queen queen = new Queen(new Position(5, 5));
        List<Position> positions = queen.getPotentialDestinations();
        Assert.assertEquals(positions.size(),25);
    }

    @Test
    public void get23PotentialDestinations(){
        Queen queen = new Queen(new Position(1, 1));
        List<Position> positions = queen.getPotentialDestinations();
        Assert.assertEquals(positions.size(),23);
    }
}