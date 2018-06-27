package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Ruslan Topolskiy (ruslan.topolskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TriangleTest {
    @Test
    public void whenSquareDraw() {
        Triangle square = new Triangle();
        assertThat(square.draw(), is(new StringBuilder()
                .append("    +    ")
                .append("   + +   ")
                .append("  + + +  ")
                .append(" + + + + ")
                .append("+ + + + +")
                .toString()));
    }
}

