import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class Ex2_1 {

    public static String[] createTextFiles(int n, int seed, int bound){
        String [] AllFiles  = new String[n];
        Random random = new Random(seed);
        try{
            for (int k = 0; k < n; k++) {
                int N_Lines = random.nextInt(bound);
                File file = new File("file_Number:" + (k + 1) + ".txt");
                file.createNewFile();
                AllFiles[k] = file.getName();
                FileWriter w = new FileWriter(file);
                int j = 0;
                while(j < N_Lines){
                    w.write("Hello World\n");
                    j++;
                }
                w.close();
            }
        }
        catch (IOException TypeE){
            TypeE.printStackTrace();
        }
        return AllFiles;
    }

    public static int getNumOfLines(String[] fileNames) {
        String s = "";
        int sum = 0;
        try {
            for (int k = 0; k < fileNames.length; k++) {
                FileReader FileReader = new FileReader(fileNames[k]);
                BufferedReader BufferedReader = new BufferedReader(FileReader);
                while (!((s = BufferedReader.readLine())==null)) {
                    sum++;
                }
                BufferedReader.close();
            }
        }
        catch (IOException TypeE) {
            TypeE.printStackTrace();
        }
        return sum;
    }

    public static int getNumOfLinesThreads(String[] fileNames)  {
        int CLines = 0;
        ThreadToRun[] ThreadToRun = new ThreadToRun[fileNames.length];
        int ThreadToRunLen = ThreadToRun.length;
        for (int k = 0; k < ThreadToRunLen; k++) {
            ThreadToRun[k] = new ThreadToRun(fileNames[k]);
            ThreadToRun[k].start();}
        int k = 0;
        while(k < ThreadToRunLen) {
            try {
                ThreadToRun[k].join(); }
            catch (InterruptedException TypeEE){
                TypeEE.printStackTrace(); }
            CLines = CLines + ThreadToRun[k].getNum_lines();
            k++;
        }
        return CLines;
    }

    public static int getNumOfLinesThreadPool(String[] fileNames) {
        int AllLines = 0;
        ExecutorService AllOfFileInFN = Executors.newFixedThreadPool(fileNames.length);
        ArrayList<Future<Integer>> ArrayListOfFactory  = new ArrayList<Future<Integer>>();
        for (int i = 0; i < fileNames.length; i++) {
            ThreadToCall task = new ThreadToCall(fileNames[i]);
            ArrayListOfFactory.add(AllOfFileInFN.submit(task)); }
        for (Future<Integer> Futuref : ArrayListOfFactory) {
            try {
                AllLines =AllLines +  Futuref.get(); }
            catch (InterruptedException | ExecutionException TypeEE) {
                TypeEE.printStackTrace();
            }
        }

        return AllLines;

    }


}
