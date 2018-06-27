package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Ruslan Topolskiy (ruslan.topolskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SquareTest {
    @Test
    public void whenSquareDraw() {
        Square triangle = new Square();
        assertThat(triangle.draw(), is(new StringBuilder()
                .append("++++")
                .append("+  +")
                .append("+  +")
                .append("++++")
                .toString()));
    }
}
