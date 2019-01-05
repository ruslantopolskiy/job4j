package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenAdd1Until3() {
        UserConvert userConvert = new UserConvert();
        List<String> buffer = Arrays.asList("1D", "2D", "3D");
        List<UserConvert.User> result = new ArrayList<>();
        result.add(new UserConvert.User("1D"));
        result.add(new UserConvert.User("2D"));
        result.add(new UserConvert.User("3D"));
        assertThat(userConvert.convert(buffer, UserConvert.User::new), is(result));
    }
}
