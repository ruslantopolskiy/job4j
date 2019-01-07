package ru.job4j.lambda;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;


public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadroResults() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(5, 8, x -> x*x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLogResults() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(1, 4, x -> Math.log(x) + 1);
        List<Double> expected = Arrays.asList(1D, 1.6931471805599454D, 2.09861228866811D);
        assertThat(result, is(expected));
    }

}
