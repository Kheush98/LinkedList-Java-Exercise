import java.util.Scanner;

/**
 * Classe représentant un polynôme et contenant des méthodes pour manipuler les polynômes.
 */
public class Polynome {

    /**
     * Crée un nouveau monôme avec un coefficient et un exposant, et l'ajoute au polynôme.
     * @param coefficient le coefficient du monôme à ajouter
     * @param exposant l'exposant du monôme à ajouter
     * @param polynome le polynôme auquel ajouter le monôme
     * @return le polynôme mis à jour avec le nouveau monôme en tête
     */
    public static Monome creerMonome(int coefficient, int exposant, Monome polynome) {
        Monome nouveauMonome = new Monome(coefficient, exposant);
        nouveauMonome.suivant = polynome;
        return nouveauMonome;
    }

    /**
     * Calcule la dérivée première d'un polynôme.
     * @param polynome le polynôme dont calculer la dérivée première
     * @return le polynôme représentant la dérivée première du polynôme donné
     */
    public static Monome calculerDeriveePremiere(Monome polynome) {
        Monome derivee = null;
        Monome current = polynome;

        while (current != null) {
            if (current.exposant > 0) {
                derivee = creerMonome(current.coefficient * current.exposant, current.exposant - 1, derivee);
            }
            current = current.suivant;
        }

        return derivee;
    }

    /**
     * Calcule la dérivée k-ième d'un polynôme.
     * @param polynome le polynôme dont calculer la dérivée k-ième
     * @param k le degré de la dérivée à calculer
     * @return le polynôme représentant la dérivée k-ième du polynôme donné
     */
    public static Monome calculerDeriveeKiemme(Monome polynome, int k) {
        Monome derivee = polynome;

        for (int i = 0; i < k; i++) {
            derivee = calculerDeriveePremiere(derivee);
        }

        return derivee;
    }

    /**
     * Méthode principale pour tester les opérations sur les polynômes.
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exemple d'utilisation : création d'un polynôme P(x) = 3x^2 - 2x + 5
        Monome polynome = null;
        polynome = creerMonome(3, 2, polynome);   // 3x^2
        polynome = creerMonome(-2, 1, polynome);  // -2x
        polynome = creerMonome(5, 0, polynome);   // 5
        System.out.println("Polynôme P(x) = 3x^2 - 2x + 5");

        // Calcul de la dérivée première du polynôme
        Monome deriveePremiere = calculerDeriveePremiere(polynome);
        System.out.println("Dérivée première de P(x):");
        Monome current = deriveePremiere;
        while (current != null) {
            System.out.print(current.coefficient + "x^" + current.exposant + " ");
            current = current.suivant;
        }
        System.out.println();

        // Demander à l'utilisateur le degré de la dérivée k-ième à calculer
        System.out.print("Entrez le degré de la dérivée k-ième à calculer : ");
        int k = scanner.nextInt();
        Monome deriveeKiemme = calculerDeriveeKiemme(polynome, k);
        System.out.println("Dérivée " + k + "-ième de P(x):");
        current = deriveeKiemme;
        while (current != null) {
            System.out.print(current.coefficient + "x^" + current.exposant + " ");
            current = current.suivant;
        }
    }
}