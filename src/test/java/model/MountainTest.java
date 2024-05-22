package model;

import org.carbonIT.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MountainTest {

    @Test
    public void testMountainCreation() {
        Position position = new Position(1, 1);
        Mountain mountain = new Mountain(position);
        assertEquals(position, mountain.getPosition());
    }
}
