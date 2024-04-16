/**
 * Classe pour représenter un arbre binaire.
 */
public class ArbreBinaire {

    /**
     * Méthode pour afficher les étiquettes des feuilles de l'arbre.
     * @param A Le nœud racine de l'arbre.
     */
    public static void feuilles(Noeud A) {
        if (A == null)
            return;

        if (A.gauche == null && A.droite == null) {
            System.out.println(A.valeur);
            return;
        }

        feuilles(A.gauche);
        feuilles(A.droite);
    }

    /**
     * Méthode pour afficher tous les nœuds avec leurs degrés respectifs.
     * @param A Le nœud racine de l'arbre.
     */
    public static void degre(Noeud A) {
        if (A == null)
            return;

        int degree = 0;
        if (A.gauche != null) {
            degree++;
        }
        if (A.droite != null) {
            degree++;
        }
        System.out.println("Noeud = " + A.valeur + ", Degré = " + degree);

        degre(A.gauche);
        degre(A.droite);
    }

    /**
     * Méthode pour calculer la profondeur d'un nœud dans l'arbre.
     * @param A Le nœud racine de l'arbre.
     * @param x Le nœud dont on veut calculer la profondeur.
     * @param depth La profondeur actuelle du nœud A.
     * @return La profondeur du nœud x, ou -1 si le nœud n'est pas trouvé.
     */
    public static int profondeur(Noeud A, Noeud x, int depth) {
        if (A == null) {
            return -1;
        }

        if (A == x) {
            return depth;
        }

        int retour = profondeur(A.gauche, x, depth + 1);
        if (retour != -1) {
            return retour;
        }

        retour = profondeur(A.droite, x, depth + 1);
        if (retour != -1) {
            return retour;
        }

        return -1;
    }

    /**
     * Méthode pour calculer la hauteur de l'arbre.
     * @param A Le nœud racine de l'arbre.
     * @return La hauteur de l'arbre.
     */
    public static int hauteur(Noeud A) {
        if (A == null) {
            return 0;
        }

        return Math.max(hauteur(A.gauche), hauteur(A.droite)) + 1;
    }

    /**
     * Méthode pour calculer la somme des valeurs de tous les nœuds de l'arbre.
     * @param A Le nœud racine de l'arbre.
     * @return La somme des valeurs de tous les nœuds de l'arbre.
     */
    public static int sommeNoeuds(Noeud A) {
        if (A == null) {
            return 0;
        }

        return sommeNoeuds(A.gauche) + sommeNoeuds(A.droite) + A.valeur;
    }

    /**
     * Méthode principale pour tester les opérations sur l'arbre binaire.
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
        // Création de l'arbre binaire
        Noeud racine = new Noeud(1);
        racine.gauche = new Noeud(2);
        racine.droite = new Noeud(3);
        racine.gauche.gauche = new Noeud(4);
        racine.gauche.droite = new Noeud(5);
        racine.droite.gauche = new Noeud(6);
        racine.droite.droite = new Noeud(7);

        // Affichage des feuilles de l'arbre
        System.out.println("Feuilles de l'arbre :");
        feuilles(racine);

        // Affichage des nœuds avec leurs degrés respectifs
        System.out.println("Degrés des nœuds de l'arbre :");
        degre(racine);

        // Calcul de la profondeur d'un nœud spécifique (ici, nœud avec valeur 5)
        Noeud noeud5 = racine.gauche.droite;
        int profondeurNoeud5 = profondeur(racine, noeud5, 0);
        System.out.println("Profondeur du nœud avec valeur 5 : " + profondeurNoeud5);

        // Calcul de la hauteur de l'arbre
        int hauteurArbre = hauteur(racine);
        System.out.println("Hauteur de l'arbre : " + hauteurArbre);

        // Calcul de la somme des valeurs de tous les nœuds de l'arbre
        int somme = sommeNoeuds(racine);
        System.out.println("Somme des valeurs de tous les nœuds de l'arbre : " + somme);
    }
}