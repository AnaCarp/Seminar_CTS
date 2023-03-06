import java.io.*;

public class MatrixDataHandler {
    private int[][] matrix;
    private int height;
    private int width;
    private String filename;

    public void initializeMatrix(int h,int w, String filename){
        this.height = h;
        this.width = w;
        this.filename = filename;
        this.matrix = new int[h][];
        for (int i = 0; i < h; i++) {
            this.matrix[i] = new int[w];
        }
    }

    /**
     * Citeste din fisier datele pentru o matrice conform clasei curente
     * @return true daca s-a citit cu succes, false daca a aparut o exceptie
     * @throws IOException
     */
    public boolean readMatrixFromFile() throws IOException {
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            height = Integer.parseInt(line.split(" ")[0]);
            width = Integer.parseInt(line.split(" ")[1]);

            for (int i = 0; i < height; i++) {
                line = br.readLine();
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = Integer.parseInt(line.split(" ")[j]);
                }
            }
            br.close();
            return true;
        }catch(IOException exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    /**
     * Metoda scrie matricea in fisierul denumit <this.filename>
     * @return Se returneaza true daca scrierea s-a facut cu succes si false in caz contrar.
     */
    public boolean writeMatrixToFile(){
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(height + " " + width + "\n");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    fw.write(matrix[i][j] + " ");
                }
                fw.write("\n");
            }
            fw.close();
            return true;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());

            return false;
        }

    }

    /**
     * Constructorul care initializeaza matricea pe baza valorilor primite pentru dimensiuni.
     * Matricea initializata este scrisa in fisierul filename.
     * @param hight
     * @param width
     * @param filename
     */
    public MatrixDataHandler(int hight, int width, String filename) {

        //------metoda separata de initializare matrice
        initializeMatrix(hight,width,filename);
        //---------metoda separata pentru scrierea in fisier a matricii
        if(!writeMatrixToFile())
            System.out.println("Exceptie la scrierea in fisier");

    }

    /**
     * Returneaza valoarea de pe o anumita pozitie in matrice.
     * Inainte de a returna se va actualiza matricea cu datele din fisier
     * @param posHeight linia de pe care se citeste
     * @param posWidth coloana de pe care se citeste
     * @return valoarea de pe pozitia transmisa
     */
    public int getValueFromPosition(int posHeight, int posWidth) {
        try {
            // !!!
            int valueFromPosition =-1;

            //metoda separata pt citire matrice din fisier
            if(!readMatrixFromFile())
                System.out.println("Citirea din fisier a esuat, datele returnate sunt cele existente in <matrix> local");


            //verificare index posH<H-1 posW<W-1
            if(posHeight<height-1 && posWidth<width-1)
                valueFromPosition=matrix[posHeight][posWidth];

            return valueFromPosition;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }

    /**
     *Se citesc valorile din fisier, se modifica valoarea dorita si apoi se rescriu datele in fisier
     * @param posHeight linia pe care se scrie
     * @param posWeight coloana pe care se scrie
     * @param val noua valoare
     * @throws IOException
     */
    public void modifyValueAndUpdateFile( int posHeight, int posWeight, int val) throws IOException {
            //apelare metoda de reinitializare matrice
            initializeMatrix(height,width,filename);

            //metoda separata pt citire matrice din fisier
            readMatrixFromFile();
            //-----

            //verificare index posH<H-1 posW<W-1
            if(posHeight<height-1 && posWeight<width-1)
                matrix[posHeight][posWeight] = val;
            else
                val=-1;

            //metoda separata pentru scriere matrice in fisier
            if(!writeMatrixToFile())
                System.out.println("Exceptie la scrierea in fisier");
            //---------
    }
}
