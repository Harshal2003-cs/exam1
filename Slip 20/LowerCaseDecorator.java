import java.io.*;

public class LowerCaseDecorator extends FilterReader {
    public LowerCaseDecorator(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1) ? c : Character.toLowerCase((char) c);
    }

    public static void main(String[] args) throws IOException {
        String text = "HELLO WORLD";
        try (Reader reader = new LowerCaseDecorator(new StringReader(text))) {
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        }
    }
}
