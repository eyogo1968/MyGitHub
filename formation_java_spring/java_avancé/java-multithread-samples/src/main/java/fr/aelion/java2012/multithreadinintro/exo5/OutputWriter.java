package fr.aelion.java2012.multithreadingintro.exo5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class OutputWriter {
    private File f;
    private PrintWriter writer;

    public OutputWriter(File f) throws FileNotFoundException, UnsupportedEncodingException {
        this.f = f;
        this.writer = new PrintWriter(f, "UTF-8");
        writer.flush();
    }

    public void writeLine(String s) {
        this.writer.println(s);
        this.writer.flush();
    }

    public synchronized void writeLineOld(String s) {
        this.writer.println(s);
    }

    public synchronized void flush() {
        this.writer.flush();
    }

    public void close() {
        this.writer.close();
    }

}