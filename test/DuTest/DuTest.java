package DuTest;

import javas.Du;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DuTest {


    private ByteArrayOutputStream op = new ByteArrayOutputStream();

    @Before
    public void sus() {
        System.setOut(new PrintStream(op));
    }

    void afc(String exp) {
        String bo = op.toString();
        assertEquals(exp, bo);
    }

    @Test
    public void one() {
        Du hi = new Du(false, false, false);
        hi.du(Arrays.asList("files\\test.txt", "files\\file1.txt"));
        afc("""
                109\r
                77297\r
                """);
    }

    @Test
    public void two() {
        Du hi = new Du(true, false, false);
        hi.du(Arrays.asList("files\\file1.txt", "files\\test.txt"));
        afc("""
                75 MB\r
                109 KB\r
                """);
    }

    @Test
    public void three() {
        Du hi = new Du(false, true, false);
        hi.du(Arrays.asList("files\\file1.txt", "files\\test.txt"));
        afc("""
                77406\r
                """);
    }

    @Test
    public void four() {
        Du hi = new Du(false, false, true);
        hi.du(Arrays.asList("files\\file1.txt", "files\\test.txt"));
        afc("""
                79152\r
                111\r
                """);
    }

    @Test
    public void five() {
        Du hi = new Du(true, true, false);
        hi.du(Arrays.asList("files\\file1.txt", "files\\test.txt"));
        afc("""
                75 MB\r
                """);
    }

    @Test
    public void six() {
        Du hi = new Du(true, false, true);
        hi.du(Arrays.asList("files\\file1.txt", "files\\test.txt"));
        afc("""
                79 MB\r
                111 KB\r
                """);
    }

    @Test
    public void seven() {
        Du hi = new Du(false, true, true);
        hi.du(Arrays.asList("files\\file1.txt", "files\\test.txt"));
        afc("""
                79264\r
                """);
    }

    @Test
    public void eight() {
        Du hi = new Du(true, true, true);
        hi.du(Arrays.asList("files\\file1.txt", "files\\test.txt"));
        afc("""
                79 MB\r
                """);
    }

    @Test
    public void nine(){
        Du hi = new Du(false, false, false);
        hi.du(Arrays.asList("files\\dir"));
        afc("""
                1406\r
                """);
    }

    @Test
    public  void ten(){
        Du hi = new Du(false, false, true);
        hi.du(Arrays.asList("files\\dir"));
        afc("""
                1440\r
                """);
    }

    @Test
    public  void eleven(){
        Du hi = new Du(true, false, false);
        hi.du(Arrays.asList("files\\dir"));
        afc("""
                1 MB\r
                """);
    }

    @Test
    public  void eleven2(){
        Du hi = new Du(true, true, false);
        hi.du(Arrays.asList("files\\dir\\1.txt", "files\\dir\\2.txt", "files\\dir\\3.txt"));
        afc("""
                1 MB\r
                """);
    }

    @Test
    public  void twelve(){
        Du hi = new Du(false, false, false);
        hi.du(Arrays.asList("files\\void.txt"));
        afc("""
                """);
    }

    @After
    public void cus() {
        System.setOut(null);
    }

}

