package exceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers(){
        list = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i += 1){
            list.add(i);
        }
    }

    public void readList(String fileName){
        String line = null;
        try{
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            while((line = raf.readLine()) != null){
                Integer i = new Integer(Integer.parseInt(line));
                System.out.println(i);
                list.add(i);
            }
        }catch (FileNotFoundException e){
            System.err.println("File: " + fileName + " not found.");

        }catch (IOException e){
            System.err.println(e.toString());
        }

    }

    public void writeList(){
        PrintWriter out = null;
        try{
            out = new PrintWriter( new FileWriter("OutFile.txt"));
            for (int i = 0;i < SIZE; i += 1){
                out.println("Value at: " + i + " = " + list.get(i));
            }
        }catch(IndexOutOfBoundsException e){
            System.err.println("IndextOutOfException: " + e.getMessage());
        }catch (IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }finally{
            if (out != null){
                System.out.println("Closing PrintWriter");
                out.close();
            }else{
                System.out.println("PrintWriter not open");
            }
        }
    }

    public void writeList2() throws IOException, IndexOutOfBoundsException {
        PrintWriter out = null;
        try{
            out = new PrintWriter( new FileWriter("OutFile.txt"));
            for (int i = 0;i < SIZE; i += 1){
                out.println("Value at: " + i + " = " + list.get(i));
            }
        }finally{
            if (out != null){
                System.out.println("Closing PrintWriter");
                out.close();
            }else{
                System.out.println("PrintWriter not open");
            }
        }
    }
}
