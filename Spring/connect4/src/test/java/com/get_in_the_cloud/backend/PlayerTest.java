package com.get_in_the_cloud.backend;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 12/01/2017.
 */
public class PlayerTest {

    @Test
    public void playerInstantiation() throws Exception {
        Player player1 = Player.of("player1", PlayerColours.RED);
        assertEquals(Player.of("player1", PlayerColours.RED), player1);
    }

}
