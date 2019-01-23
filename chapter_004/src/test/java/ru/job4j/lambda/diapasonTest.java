package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapasons diapasons = new Diapasons();
        List<Double> result = diapasons.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadroResults() {
        Diapasons diapasons = new Diapasons();
        List<Double> result = diapasons.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLogResults() {
        Diapasons diapasons = new Diapasons();
        List<Double> result = diapasons.diapason(1, 4, x -> Math.log(x) + 1);
        List<Double> expected = Arrays.asList(1D, 1.6931471805599454D, 2.09861228866811D);
        assertThat(result, is(expected));
    }

}
