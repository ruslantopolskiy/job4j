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

    public void ServerTest(String input,String output) throws Exception{
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(),is(output));
    }

    @Test
    public void a1() throws Exception{
        this.ServerTest("Exit","");
    }

    @Test
    public void a2() throws Exception{
    this.ServerTest("hello", String.join(LN,"Hello, dear friend, I'm a oracle.","",""));
    }

    @Test
    public void a3() throws Exception {
        this.ServerTest("1", String.join(LN,"It's an Oracle, you said : 1","",""));
    }

    @Test
    public void a4() throws Exception {
        this.ServerTest(String.join(LN,"hello","exit"),
                String.join(LN,"Hello, dear friend, I'm a oracle.","",""));
    }

}