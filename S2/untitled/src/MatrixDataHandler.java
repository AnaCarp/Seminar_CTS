import java.io.*;

public class MatrixDataHandler {
    private int[][] matrix;
    private int h;
    private int w;
    private String filename;

    public void initializeMatrix(int h,int w, String filename){
        this.h = h;
        this.w = w;
        this.filename = filename;
        this.matrix = new int[h][];
        for (int i = 0; i < h; i++) {
            this.matrix[i] = new int[w];
        }
    }

    public void readMatrixFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line=br.readLine();

        for (int i = 0; i < h; i++) {
            line = br.readLine();
            for (int j = 0; j < w; j++) {
                matrix[i][j] = Integer.parseInt(line.split(" ")[j]);
            }
        }
        br.close();
    }

    public void writeMatrixToFile(){
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(h + " " + w + "\n");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    fw.write(matrix[i][j] + " ");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }
    public MatrixDataHandler(int h, int w, String filename) {

        //------metoda separata de initializare matrice
        initializeMatrix(h,w,filename);
        //---------metoda separata pentru scrierea in fisier a matricii
        writeMatrixToFile();

    }

    public int getValueFromPosition(String filename, int posH, int posW) {
        try {
            // !!!
            int valueFromPosition =-1;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            h = Integer.parseInt(line.split(" ")[0]);
            w = Integer.parseInt(line.split(" ")[1]);

            //metoda separata pt citire matrice din fisier
            readMatrixFromFile();
            //-----

            //verificare index posH<H-1 posW<W-1
            if(posH<h-1 && posW<w-1)
                valueFromPosition=matrix[posH][posW];

            return valueFromPosition;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }

    public void modifyValueAndUpdateFile(String filename, int posH, int posW, int val) {
        try {
            // !!!
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            h = Integer.parseInt(line.split(" ")[0]);
            w = Integer.parseInt(line.split(" ")[1]);


            //apelare metoda de reinitializare matrice
            initializeMatrix(h,w,filename);

            //metoda separata pt citire matrice din fisier
            readMatrixFromFile();
            //-----

            //verificare index posH<H-1 posW<W-1
            if(posH<h-1 && posW<w-1)
                matrix[posH][posW] = val;
            else
                val=-1;

            //metoda separata pentru scriere matrice in fisier
            writeMatrixToFile();
            //---------
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
