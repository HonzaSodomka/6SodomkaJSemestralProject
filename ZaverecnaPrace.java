/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zaverecnaprace;

import java.util.Scanner;

/**
 * 6. Program načte od uživatele dva polynomy, vypíše je a vypíše jejich součet
 * a součin
 *
 * @author JanSodomka
 * @version 19.12.2022
 */
public class ZaverecnaPrace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        boolean podminkaUlohy = true;
        OUTER:
        while (podminkaUlohy == true) {
            System.out.println("Napište 1 pro spuštění vánoční úlohy nebo 2 pro spuštění semestrální práce.");
            System.out.println("Při napsání 0 se program ukončí");
            int uloha = sc.nextInt();
            //UKONČENÍ PROGRAMU
            switch (uloha) {
                case 0:
                    podminkaUlohy = false;
                    break;
                case 2:
                    boolean podminka = true;
                    while (podminka == true) {
                        System.out.println("Zadejte stupeň prvního polynomu:");
                        System.out.println("Při zadání záporné hodnoty se úloha ukončí");
                        int prvniStupen = sc.nextInt();
                        if (prvniStupen < 0) {
                            podminka = false;
                            break;
                        }
                        int[] prvniPolynom = new int[prvniStupen + 1];
                        System.out.println("Zadejte prvky prvního polynomu:");
                        for (int i = 0; i <= prvniStupen; i++) {
                            prvniPolynom[i] = sc.nextInt();
                        }

                        System.out.println("Zadejte stupeň druhého polynomu:");
                        int druhyStupen = sc.nextInt();
                        while (druhyStupen < 0) {
                            System.out.println("Zadejte nezáporný stupeň druhého polynomu:");
                            druhyStupen = sc.nextInt();
                        }
                        int[] druhyPolynom = new int[druhyStupen + 1];
                        System.out.println("Zadejte prvky druhého polynomu:");
                        for (int i = 0; i <= druhyStupen; i++) {
                            druhyPolynom[i] = sc.nextInt();
                        }
                        String polynom1 = PolynomyTools.vypisPolynomu(prvniPolynom);
                        System.out.print("První polynom:");
                        System.out.println(polynom1);

                        String polynom2 = PolynomyTools.vypisPolynomu(druhyPolynom);
                        System.out.print("Druhý polynom:");
                        System.out.println(polynom2);

                        int[] soucet = PolynomyTools.soucetPolynomu(prvniPolynom, druhyPolynom);
                        String soucetPolynomu = PolynomyTools.vypisPolynomu(soucet);
                        System.out.print("Součet polynomů:");
                        System.out.println(soucetPolynomu);

                        int[] soucin = PolynomyTools.soucinPolynomu(prvniPolynom, druhyPolynom);
                        String soucinPolynomu = PolynomyTools.vypisPolynomu(soucin);
                        System.out.print("Součin polynomů:");
                        System.out.println(soucinPolynomu);
                        System.out.println("");
                    }
                    break;
                case 1:
                    boolean podminkaVanocni = true;
                    while (podminkaVanocni == true) {
                        System.out.println("Zadejte výšku sněhuláka. Dále napište 1 pro pokrývku hlavy ve tvaru klobouku nebo 2 pro tvar hrnce");
                        System.out.println("Záporná výška sněhuláka ukončí úlohu");
                        int vyska = sc.nextInt();
                        if (vyska < 0) {
                            podminkaVanocni = false;
                            break;
                        }
                        int sirka = (int) Math.floor(4 * vyska / 5);
                        int cepice = sc.nextInt();
                        int stred = sirka / 2;
                        for (int i = 1; i <= vyska; i++) {
                            //klobouk
                            if (i < Math.floor(10 * vyska / 100) && cepice == 1) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) || j > Math.floor(2 * sirka / 3)) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("■");
                                    }
                                }
                                System.out.println("");
                            }
                            if (i == Math.floor(10 * vyska / 100) && cepice == 1) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) - vyska / 10 || j > Math.floor(2 * sirka / 3) + vyska / 10) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("■");
                                    }
                                }
                                System.out.println("");
                            }

                            //hrnec
                            if (i < Math.floor(10 * vyska / 100) / 2 && cepice == 2) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) || j > Math.floor(2 * sirka / 3)) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("■");
                                    }
                                }
                                System.out.println("");
                            }
                            if (i == Math.floor(10 * vyska / 100 / 2) && cepice == 2) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) - vyska / 20 || j > Math.floor(2 * sirka / 3) + vyska / 20) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("■");
                                    }
                                }
                                System.out.println("");
                            }
                            if (i > Math.floor(10 * vyska / 100) / 2 && i < Math.floor(10 * vyska / 100) && cepice == 2) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) || j > Math.floor(2 * sirka / 3)) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("■");
                                    }
                                }
                                System.out.println("");
                            }

                            //hlava
                            if (i > Math.floor(10 * vyska / 100) && i <= Math.floor(20 * vyska / 100)) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) - Math.floor(i - vyska / 10 - 1) || (j > Math.floor(2 * sirka / 3) + Math.floor(i - vyska / 10 - 1))) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("▩");
                                    }
                                }
                                System.out.println("");
                            }
                            if (i > Math.floor(20 * vyska / 100) && i <= Math.floor(30 * vyska / 100)) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) - Math.floor(3 * vyska / 10 - i) || (j > Math.floor(2 * sirka / 3) + Math.floor(3 * vyska / 10 - i))) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("▩");
                                    }
                                }
                                System.out.println("");
                            }

                            //telo
                            if (i > Math.floor(30 * vyska / 100) && i <= Math.floor(45 * vyska / 100)) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) - Math.floor(i - 3 * vyska / 10 - 1) || (j > Math.floor(2 * sirka / 3) + Math.floor(i - 3 * vyska / 10 - 1))) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("▩");
                                    }
                                }
                                System.out.println("");
                            }
                            if (i > Math.floor(45 * vyska / 100) && i <= Math.floor(60 * vyska / 100)) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) - Math.floor(6 * vyska / 10 - i) || (j > Math.floor(2 * sirka / 3) + Math.floor(6 * vyska / 10 - i))) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("▩");
                                    }
                                }
                                System.out.println("");
                            }

                            //nohy
                            if (i > Math.floor(60 * vyska / 100) && i <= Math.floor(80 * vyska / 100)) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) - Math.floor(i - 6 * vyska / 10 - 1) || (j > Math.floor(2 * sirka / 3) + Math.floor(i - 6 * vyska / 10 - 1))) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("▩");
                                    }
                                }
                                System.out.println("");
                            }
                            if (i > Math.floor(80 * vyska / 100) && i <= Math.floor(100 * vyska / 100)) {
                                for (int j = 1; j <= sirka; j++) {
                                    if (j <= Math.floor(sirka / 3) - Math.floor(10 * vyska / 10 - i) || (j > Math.floor(2 * sirka / 3) + Math.floor(10 * vyska / 10 - i))) {
                                        System.out.print("□");
                                    } else {
                                        System.out.print("▩");
                                    }
                                }
                                System.out.println("");
                            }
                        }
                        System.out.println("");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
