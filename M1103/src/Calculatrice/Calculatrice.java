package Calculatrice;

import Pile.*;
public class Calculatrice {

    public static void main(String[] args) {
        int a, b;
        String v;
        int total;
        Pile pileCalcul = new PileParTableau();
        char x;
        do {
            System.out.println("\n Donnez un nombre de 0 à 9 ou un caractère comme + - / * finissant par un =");
            v=Clavier.lireString();
            x= v.charAt(0);
            switch(x) {
                case('-'):
                    a = (int)pileCalcul.depiler();
                    b = (int)pileCalcul.depiler();
                    pileCalcul.empiler(a-b);
                    break;
                case('+'):
                    a = (int)pileCalcul.depiler();
                    b = (int)pileCalcul.depiler();
                    pileCalcul.empiler(a+b);
                    break;
                case('*'):
                    a = (int)pileCalcul.depiler();
                    b = (int)pileCalcul.depiler();
                    pileCalcul.empiler(a*b);
                    break;
                case('/'):
                    a = (int)pileCalcul.depiler();
                    b = (int)pileCalcul.depiler();
                    pileCalcul.empiler(a/b);
                    break;
                case('='):
                    System.out.println("Le resultat est: ");
                    break;
                default:
                    total = Integer.parseInt(v);
                    pileCalcul.empiler(total);
                    break;
                }

            }while (x != '=');
            System.out.println(pileCalcul.depiler());
    }

}
