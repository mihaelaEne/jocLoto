package loto;

import javax.print.attribute.standard.RequestingUserName;
import java.sql.SQLOutput;
import java.util.Scanner;

public class JocMihaela {
    //un joc in care poti sa alegi daca joci cu litere sau numere
    //cazul 1:
    //jucatorul trebuie sa aleaga 10 numere intre 1 si 100, jucatorul care  a ghicit cele mai multe numere castiga
    //caz 2
    //jucatorul trebuie sa aleaga 10 litere intre A si Z, jucatorul care  a ghicit cele mai multe litere castiga


    //joc cu caractere
    public static void afisare(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
    }

    public static boolean verificareCaracterIntrodus(char[] v, char caracter) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == caracter) {
                return true;
            }
        }
        return false;
    }

    public static char[] vectorLitereRandom() {
        char[] vectorLiteree = new char[10];
        int poz = 0;


        while (poz < 10) {

            char caracter = (char) Math.floor(Math.random() * 65 + 67);
            if (caracter >= 65 && caracter <= 90 || caracter >= 97 && caracter <= 122) {
                if (verificareCaracterIntrodus(vectorLiteree, caracter) == false) {
                    vectorLiteree[poz] = caracter;
                    poz++;
                }
            }
        }


        return vectorLiteree;

    }


    public static char[] vectorLitereIntrodus() {
        Scanner scanner = new Scanner(System.in);
        char[] litereIntroduse = new char[10];
        int poz = 0;

        while (poz < 10) {
            System.out.println("Introduceti o litera din alfabet: ");
            char caracter = scanner.nextLine().charAt(0);
            boolean stat = caracter >= 65 && caracter <= 90 || caracter >= 97 && caracter <= 122 && verificareCaracterIntrodus(litereIntroduse, caracter) == false;
            if (stat == true) {
                litereIntroduse[poz] = caracter;
                poz++;
            } else {
                System.out.println("incorect");
            }
        }

        return litereIntroduse;
    }


    public static int contorLitere(char[] v1, char[] v2) {
        int ct = 0;
        for (int i = 0; i < v1.length; i++) {
            if (verificareCaracterIntrodus(v2, v1[i]) == true) {
                ct++;
            }
        }
        return ct;
    }

    public static char[] vectorLitereComune(char[] v1, char[] v2) {
        char[] comune = new char[contorLitere(v1, v2)];
        int ct = 0;
        for (int i = 0; i < v1.length; i++) {
            if (verificareCaracterIntrodus(v2, v1[i]) == true) {
                comune[ct] = v1[i];
                ct++;
            }
        }
        return comune;
    }

    public static void meniuCaractere() {
        System.out.println("\n Apasa tasta 1 pentru a juca");
        System.out.println("\n Apasa tasta 2 pentru a iesi");
    }


    //aici trebuie sa fac playCaractere
    public static void playCaractere() {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running == true) {
            meniuCaractere();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    char[] caractereRandom = vectorLitereRandom();
                    char[] caractereAlese = vectorLitereIntrodus();
                    char[] commune = vectorLitereComune(caractereRandom, caractereAlese);
                    System.out.println("\nAi ales " + commune.length + " caractere corecte");
                    System.out.println("\n Caracterele extrase sunt: ");
                    System.out.println(caractereAlese);
                    System.out.println("\n Carecterele gasite sunt: ");
                    System.out.println(commune);
                    break;
                case 2:
                    running = false;
            }
        }
    }


    //joc cu cifre

    public static boolean verificareNumar(int[] v, int numar) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == numar) {
                return true;
            }
        }
        return false;
    }

    public static int[] vectorNumereRandom() {
        int[] vectorNumereRandomm = new int[10];
        int poz = 0;
        while (poz < 10) {
            int numar = (int) Math.floor(Math.random() * 100 + 1);
            if (verificareNumar(vectorNumereRandomm, numar) == false) {
                vectorNumereRandomm[poz] = numar;
                poz++;
            }
        }
        return vectorNumereRandomm;
    }


    public static int[] vectorNumereIntroduse() {
        Scanner scanner = new Scanner(System.in);
        int[] vectorNumereIntrodusee = new int[10];
        int ct = 0;

        while (ct < 10) {
            System.out.println("Introduceti un numar intre 1 si 100.");
            System.out.println("Mai aveti de introdus " + (10 - ct) + " numere");
            int numar = Integer.parseInt(scanner.nextLine());

            boolean stat = numar > 0 && numar < 101 && verificareNumar(vectorNumereIntrodusee, numar) == false;
            if (stat == true) {
                vectorNumereIntrodusee[ct] = numar;
                ct++;
            } else {
                System.out.println("Numarul nu se afla in intervalul 1-100");
            }
        }
        return vectorNumereIntrodusee;
    }


    public static int contorNumereComune(int[] v1, int[] v2) {
        int ct = 0;
        for (int i = 0; i < v1.length; i++) {
            if (verificareNumar(v2, v1[i]) == true) {
                ct++;
            }
        }
        return ct;
    }


    public static int[] vectorNumereComune(int[] v1, int[] v2) {
        int[] comune = new int[contorNumereComune(v1, v2)];
        int ct = 0;
        for (int i = 0; i < v1.length; i++) {
            if (verificareNumar(v2, v1[i]) == true) {
                comune[ct] = v1[i];
                ct++;
            }
        }
        return comune;
    }


    public static void meniuNumere() {
        System.out.println("\n Apasa tasta 1 pentru a juca");
        System.out.println("\n Apasa tasta 2 pentru a iesi");
    }

//aici un playRandon

    public static void playNumere() {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running == true) {
            meniuNumere();
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    int[] numereRandom = vectorNumereRandom();
                    int[] numereAlese = vectorNumereIntroduse();
                    int[] comune = vectorNumereComune(numereRandom, numereAlese);
                    System.out.println("\n Ai ales " + comune.length + " numere corecte");
                    System.out.println("\n Numerele extrase sunt: ");
                    afisare(numereRandom);
                    System.out.println("\n Numerele gasite in comun sunt : ");
                    afisare(comune);
                    break;

                case 2:
                    running = false;
            }
        }
    }


    public static void alegeJocul() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Apasati tasta care corespunde jocului dorit: ");
        System.out.println("1-Joc cu caractere ");
        System.out.println("2-joc cu numere");
        boolean running = true;
        while (running == true) {
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    playCaractere();
                    break;


                case 2:
                    playNumere();
                    break;
                case 3:
                    running = false;
            }

        }

    }


}







