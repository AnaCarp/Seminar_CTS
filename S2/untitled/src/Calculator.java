import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    /**
     * Aceasta metoda calculeaza suma dintre x ridicat la puterea a-5a si y ridicat la putearea a-7a.
     * @return Returneaza rezultatul calculat.
     * @throws IOException Arunca exceptie daca datele introduse nu au formatul corect.
     */
    public double calculateSumOfPow() throws NumberFormatException, IOException {
        double result = 0.0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        double x = 0, y = 0;


        try {
            System.out.println("Tastati valoarea pentru X:");
            x = Double.parseDouble(reader.readLine());
            System.out.println("Tastati valoarea pentru Y:");
            y = Double.parseDouble(reader.readLine());
            double x5=calculatePow(x,5);

            double y7 =calculatePow(y,7);
            result = x5 + y7;
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormat Exception: invalid input string");
//            reader = new BufferedReader(new InputStreamReader(System.in));
//
//            System.out.println("Tastati valoarea pentru X:");
//            x = Double.parseDouble(reader.readLine());
//            System.out.println("Tastati valoarea pentru Y:");
//            y = Double.parseDouble(reader.readLine());
//            double xPow5 = calculatePow(x,5);
//            double yPow7 = calculatePow(y,7);
//
//            result=xPow5+yPow7;
            calculateSumOfPow();

        }


        return result;
    }

    public double calculatePow(double x,int n){
        double result = x;
        for (int i = 1; i < n; i++) {
           result *= x;
        }
        return result;
    }
}

/*
* Modificari:
* -exceptia aruncata tb schimbata
* -separare cu metoda de calcul putere
* -in cazul valorilor non-numerice, se reia procesul de citire
* */