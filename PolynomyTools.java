/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zaverecnaprace;

/**
 * 6. Program načte od uživatele dva polynomy, vypíše je a vypíše jejich součet
 * a součin
 *
 * @author JanSodomka
 * @version 19.12.2022
 */
public final class PolynomyTools {

    private PolynomyTools() {
    }

    public static String vypisPolynomu(int[] a) {
        String vypis = "";
        int j = 2;
        for (int i = a.length - 1; i >= 0; i--) { //prochazi jednotlive stupne polynomu do 0 po nejvyssi
            if (i == a.length - 1) { //nulty stupen polynomu
                if (a[i] > 0) { //kdyz se nejedna o nulu, vypise zadanou hodnotu kladneho cisla
                    vypis = String.format("%s", "+" + a[i]) + vypis;
                } else if (a[i] < 0) { //kdyz se nejedna o nulu, vypise zadanou hodnotu zaporneho cisla
                    vypis = String.format("%s", +a[i]) + vypis;
                }
            } else if (i == a.length - 2) { //prvni stupen polynomu
                if (a[i] > 1) { //pro hodnoty prvniho stupne vyssi nez 1 vypise zadanou kladnou hodnotu x
                    vypis = String.format("%s", "+" + a[i] + "x") + vypis;
                } else if (a[i] < -1) { //pro hodnoty prvniho stupne mensi nez 0 vypise zadanou zapornou hodnotu x
                    vypis = String.format("%s", +a[i] + "x") + vypis;
                } else if (a[i] == 1) { //v pripade hodnoty  prvniho stupne rovne 1 napise pouze +x
                    vypis = String.format("%s", "+x") + vypis;
                } else if (a[i] == -1) { //v pripade hodnoty  prvniho stupne rovne 1 napise pouze -x
                    vypis = String.format("%s", "-x") + vypis;
                }
            } else { //druhy a vyssi stupen polynomu
                if (a[i] > 1) { //pro hodnoty konkretniho stupne vyssi nez 1 vypise zadanou kladnou hodnotu x na prislusnou mocninu
                    vypis = String.format("%s", "+" + a[i] + "x^" + j) + vypis;
                } else if (a[i] < -1) { //pro hodnoty konkretniho stupne mensi nez 0 vypise zadanou zapornou hodnotu x na prislusnou mocninu
                    vypis = String.format("%s", a[i] + "x^" + j) + vypis;
                } else if (a[i] == 1) { //v pripade hodnoty  konkretniho stupne rovne 1 napise pouze x na prislusnou mocninu
                    vypis = String.format("%s", "+x^" + j) + vypis;
                } else if (a[i] == -1) { //v pripade hodnoty  konkretniho stupne rovne 1 napise pouze x na prislusnou mocninu
                    vypis = String.format("%s", "-x^" + j) + vypis;

                }
                j++;
            }
        }
        vypis = vypis.startsWith("+") ? vypis.substring(1) : vypis; //zajisti aby na zacatku vypisu nebylo +
        if ("".equals(vypis)) {
            vypis = "0"; //v pripade ze je koeficient kazdeho stupne polynomu roven nule, vypise nuluS
        }
        return vypis;
    }

    public static int[] soucetPolynomu(int[] a, int[] b) { //zavedeni promenne soucet
        int delsiPolynom = a.length;
        int kratsiPolynom = b.length;
        if (delsiPolynom < kratsiPolynom) { //potrebuji scitat stejne stupne, takze si nastavim promenne urcujici delsi a kratsi polynom
            int[] c = a; //pro jednotny vypocet si zajistim aby a byl vzdy delsi polynom
            a = b;
            b = c;
            delsiPolynom = a.length;
            kratsiPolynom = b.length;

        }
        int[] soucet = new int[delsiPolynom];
        while (kratsiPolynom > 0) { //dokud mam k dispozici stupne kratsiho polynomu, scitam prislusne stupne
            soucet[delsiPolynom - 1] = a[delsiPolynom - 1] + b[kratsiPolynom - 1]; //priklad: a[delsiPolynom-1]+b[kratsiPolynom-1]=soucet absolutnich clenu
            delsiPolynom--;
            kratsiPolynom--;
        }
        while (kratsiPolynom == 0 && delsiPolynom > 0) { //kdyz mi dojdou prvky kratsiho polynomu, dopisu jednotlive prvky delsiho
            soucet[delsiPolynom - 1] = a[delsiPolynom - 1];
            delsiPolynom--;
        }
        return soucet;
    }

    public static int[] soucinPolynomu(int[] a, int[] b) {
        int delkaSoucin = a.length + b.length - 1; //delka soucinu je soucet delek jednotlivych polynomu -1 
        int[] soucin = new int[delkaSoucin]; //zavedeni promenne soucin
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) { //kazdy prvek prvniho polynomu vynasobim prvkem druheho polynomu
                soucin[i + j] = soucin[i + j] + a[i] * b[j]; //prvek soucinu je roven soucinu koeficientu a ulozi se do prislusneho stupne (i+j)
            }
        }
        return soucin;
    }
}
