package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
        public void whenThen(){
        UserStore userStore = new UserStore();
        userStore.add(new User("10"));
        userStore.add(new User("20"));
        userStore.add(new User("30"));
        assertThat(userStore.ByObjectsIndex(2).getId(),is("30"));
    }

}