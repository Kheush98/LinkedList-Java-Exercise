/**
 * Classe contenant des méthodes pour manipuler une liste chaînée.
 */
public class ListeChainee {

    /**
     * Fonction pour créer un maillon avec une valeur et l'ajouter à une liste.
     * @param valeur La valeur à stocker dans le nouveau maillon.
     * @param liste La liste à laquelle ajouter le nouveau maillon.
     * @return Le nouveau maillon créé.
     */
    public static Maillon creerMaillon(int valeur, Maillon liste) {
        Maillon nouveauMaillon = new Maillon(valeur);
        nouveauMaillon.suivant = liste;
        return nouveauMaillon;
    }

    /**
     * Procédure pour saisir dix valeurs au clavier et créer une liste.
     * @return La liste créée à partir des valeurs saisies.
     */
    public static Maillon creerListe() {
        Maillon liste = null;
        int valeur;
        System.out.println("Veuillez saisir dix valeurs pour créer la liste :");
        for (int i = 0; i < 2; i++) {
            System.out.print("Valeur " + (i + 1) + " : ");
            valeur = Integer.parseInt(System.console().readLine());
            liste = creerMaillon(valeur, liste);
        }
        return liste;
    }

    /**
     * Fonction pour tester l'égalité de deux listes chaînées.
     * @param liste1 La première liste à comparer.
     * @param liste2 La deuxième liste à comparer.
     * @return true si les listes sont égales, false sinon.
     */
    public static boolean testerEgalite(Maillon liste1, Maillon liste2) {
        while (liste1 != null && liste2 != null) {
            if (liste1.valeur != liste2.valeur) {
                return false;   // Les listes ne sont pas égales
            }
            liste1 = liste1.suivant;
            liste2 = liste2.suivant;
        }
        // Les deux listes doivent être terminées en même temps pour être égales
        return (liste1 == null && liste2 == null);
    }

    /**
     * Procédure pour concaténer deux listes chaînées sans créer une troisième liste.
     * @param liste1 La première liste à concaténer.
     * @param liste2 La deuxième liste à concaténer (sera ajoutée à liste1).
     */
    public static void concatenationSansTroisiemeListe(Maillon liste1, Maillon liste2) {
        while (liste1.suivant != null) {
            liste1 = liste1.suivant;
        }
        liste1.suivant = liste2;
    }

    public static void main(String[] args) {
        // Création des deux listes avec dix valeurs saisies au clavier
        System.out.println("Liste 1 :");
        Maillon liste1 = creerListe();
        System.out.println("Liste 2 :");
        Maillon liste2 = creerListe();

        // Test de l'égalité des deux listes
        if (testerEgalite(liste1, liste2)) {
            System.out.println("Les deux listes sont égales.");
        } else {
            System.out.println("Les deux listes ne sont pas égales.");
        }

        // Concaténation des deux listes sans créer une troisième liste
        System.out.println("Concaténation sans créer une troisième liste :");
        concatenationSansTroisiemeListe(liste1, liste2);

        // Affichage de la liste résultante après concaténation
        Maillon courant = liste1;
        while (courant != null) {
            System.out.print(courant.valeur + " ");
            courant = courant.suivant;
        }
        System.out.println();
    }
}