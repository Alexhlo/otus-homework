package otus.homework.service;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleIOServiceImpl implements IOService {
    private final PrintStream out;
    private final Scanner scanner;

    public ConsoleIOServiceImpl() {
        this.out = System.out;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void println(String line) {
        out.println(line);
    }

    @Override
    public void print(String line) {
        out.print(line);
    }

    @Override
    public String readNextLine() {
        return scanner.nextLine();
    }

    @Override
    public String readNext() {
        return scanner.next();
    }

    @Override
    public void closeInputStream() {
        scanner.close();
    }
}
