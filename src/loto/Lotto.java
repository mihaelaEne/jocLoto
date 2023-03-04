package loto;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Scanner;

public class Lotto {


    //todo: functie care imi af vect

    public static void afisare(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
    }

    //todo:functice ce verifica daca un vector contine un anumit numar

    public static boolean verificareNumarInclus(int[] v, int numar) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == numar) {
                return true;
            }
        }
        return false;
    }


    //todo:functie ce returneaza un vector cu 6 numere random distincte  cuprinse intre 1 si 49

    public static int[] vectorLotto() {

        int[] vectorLoto = new int[6];
        int poz = 0;
        while (poz < 6) {
            int number = (int) (Math.random() * 49 + 1);
            if (verificareNumarInclus(vectorLoto, number) == false) {
                vectorLoto[poz] = number;
                poz++;
            }
        }
        return vectorLoto;
    }


    //todo: sa introduca utilizatorul numerele

    public static int[] vectorIntrodus() {
        Scanner scanner = new Scanner(System.in);
        int[] numereIntroduse = new int[6];
        int ct = 0;


        while (ct < 6) {

            System.out.println("Introduceti un numar intre 1 si 49. Mai aveti de introdus " + (6 - ct) + " numere");

            int numar = Integer.parseInt(scanner.nextLine());

            boolean status = numar <= 49 && numar >= 1 && verificareNumarInclus(numereIntroduse, numar) == false;
            if (status == true) {
                numereIntroduse[ct] = numar;
                ct++;
            } else {

                System.out.println("numar invalid");
            }
        }


        return numereIntroduse;
    }



    //todo : ce  returneaza numarul de elemnte comune dintre doi vectori

    public static int contorNumereComune(int[] v1, int[] v2) {
        int ct = 0;
        for (int i = 0; i < v1.length; i++) {
            if (verificareNumarInclus(v2, v1[i]) == true) {
                ct++;
            }
        }
        // System.out.println("Numarul de elemente in comun: ");
        return ct;
    }


    //todo:functie ce returneaza un vector cu elementele comune
    public static int[] vectorElemnteComunee(int v1[], int v2[]) {
        int[] comune = new int[contorNumereComune(v1, v2)];
        int ct = 0;
        for (int i = 0; i < v1.length; i++)
            if (verificareNumarInclus(v2, v1[i]) == true) {
                {
                    comune[ct] = v1[i];
                    ct++;
                }
            }
        return comune;
    }


    public static void menu(){

        System.out.println("\nApasati tasta 1 pentru a juca");
        System.out.println("Apasati tasat 2 pentru a iesi");

    }

    public  static  void playLotto(){
        boolean running=true;
        Scanner scanner= new Scanner(System.in);
        while (running==true){
            menu();
            int algere=Integer.parseInt(scanner.nextLine());

            switch (algere){
                case  1:
                    int []numreExtrase=vectorLotto();
                    int []numereAlese=vectorIntrodus();
                    int []comune=vectorElemnteComunee(numreExtrase,numereAlese);
                    System.out.println("\nAi ales "+comune.length+" numere corecte.");
                    System.out.println("\nNumere extrase sunt");
                    afisare(numereAlese);
                    System.out.println("\nNumerele  gasite sunt: ");
                    afisare(comune);
                    break;
                case 2:
                    running=false;

            }

        }
    }






}




