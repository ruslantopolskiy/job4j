package ru.job4j.socket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTest {
    public final static String LN = System.getProperty("line.separator");
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    ByteArrayInputStream ketIn;
    ByteArrayOutputStream keyOut;

    @Before
    public void before(){
        keyOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(keyOut));
    }

    private void setSetIn(String console){
        ketIn = new ByteArrayInputStream(console.getBytes());
       System.setIn(ketIn);
    }

    @After
    public void after(){
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    public void clientTest(String console,String input,String expected )throws Exception{
        Socket socket = mock(Socket.class);
        setSetIn(console);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getOutputStream()).thenReturn(out);
        when(socket.getInputStream()).thenReturn(in);
        Client client = new Client(socket);
        client.start();
        assertThat(keyOut.toString(),is(expected));
    }

    @Test
    public void WhenExitThenExit() throws Exception{
    clientTest(String.join(LN,"exit"),String.join(LN,"Privet client","",""),String.join(LN,"Hello.","Enter your message: ","Privet client",""));
    }

}