package otus.homework.service;

public interface IOService {

    void println(String line);

    void print(String line);

    String readNextLine();

    String readNext();

    void closeInputStream();
}
