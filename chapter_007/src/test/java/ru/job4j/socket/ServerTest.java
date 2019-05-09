package ru.job4j.socket;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.Socket;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    private static final String LN = System.getProperty("line.separator");

    public void serverTest(String input, String output) throws Exception {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(output));
    }

    @Test
    public void a1() throws Exception {
        this.serverTest("Exit", "");
    }

    @Test
    public void a2() throws Exception {
        this.serverTest("hello", String.join(LN, "Hello, dear friend, I'm a oracle.", "", ""));
    }

    @Test
    public void a3() throws Exception {
        this.serverTest("1", String.join(LN, "It's an Oracle, you said : 1", "", ""));
    }

    @Test
    public void a4() throws Exception {
        this.serverTest(String.join(LN, "hello", "exit"),
                String.join(LN, "Hello, dear friend, I'm a oracle.", "", ""));
    }

}