import java.io.*;

public class TestScope{
    public static void main(String args[]) {
        int i=0,k=0;
        for (i=1;i<20;i++) {
            int j=i*2;
            k=j*k;
            System.out.println(j);
        }
        for (int m=1;m<10;m++) {
            System.out.println(m);
        }
        System.out.println("Value is "+m);
    }
}
