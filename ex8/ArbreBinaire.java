/**
 * Classe représentant un arbre binaire.
 */
public class ArbreBinaire {
    Noeud tete, queue;

    /**
     * Constructeur pour initialiser un arbre binaire vide.
     */
    ArbreBinaire() {
        this.tete = null;
        this.queue = null;
    }

    /**
     * Méthode pour ajouter un nœud avec un nom donné et une liste de numéros associés à l'arbre.
     * @param nom Le nom associé au nœud.
     * @param numeros La liste des numéros à associer au nœud.
     * @return L'arbre binaire mis à jour.
     */
    ArbreBinaire ajouterNoeud(String nom, int[] numeros) {
        Noeud nouveauNoeud = new Noeud(nom);

        // Ajout des numéros dans la liste chaînée de l'index du nouveau nœud
        for (int num : numeros) {
            nouveauNoeud.index.ajoutNumero(num);
        }

        // Ajout du nouveau nœud dans l'arbre binaire
        if (this.tete == null) {
            this.tete = nouveauNoeud;
            this.queue = nouveauNoeud;
            return this;
        }

        Noeud current = this.tete;
        Noeud prec = null;
        while (current != null) {
            int cmp = current.nom.compareTo(nom);
            if (cmp == 0) {
                return this; // Nom déjà présent, rien à faire
            } else if (cmp > 0) {
                // Le nouveau nom doit être inséré avant le nom actuel
                if (prec == null) {
                    nouveauNoeud.suiv = current;
                    current.prec = nouveauNoeud;
                    this.tete = nouveauNoeud;
                    return this;
                } else {
                    prec.suiv = nouveauNoeud;
                    nouveauNoeud.prec = prec;
                    nouveauNoeud.suiv = current;
                    current.prec = nouveauNoeud;
                    return this;
                }
            }
            prec = current;
            current = current.suiv;
        }

        // Ajout en fin de liste
        prec.suiv = nouveauNoeud;
        nouveauNoeud.prec = prec;
        this.queue = nouveauNoeud;
        return this;
    }

    /**
     * Méthode pour supprimer un numéro associé à un nom donné dans l'arbre binaire.
     * @param nom Le nom associé au nœud.
     * @param numero Le numéro à supprimer.
     * @return L'arbre binaire mis à jour.
     */
    ArbreBinaire supprimerNumero(String nom, int numero) {
        Noeud current = this.tete;
        while (current != null && !current.nom.equals(nom)) {
            if (current.nom.compareTo(nom) < 0) {
                current = current.prec;
            } else {
                current = current.suiv;
            }
        }

        if (current == null) {
            // Nom non trouvé dans l'arbre
            return this;
        }

        // Supprimer le numéro de la liste associée au nom
        current.index.supprimerNumero(numero);
        return this;
    }

    /**
     * Méthode pour afficher l'arbre binaire avec les noms et les numéros associés.
     */
    void afficherArbre() {
        Noeud current = this.tete;
        while (current != null) {
            System.out.print(current.nom + " : ");
            Maillon currentMaillon = current.index.tete;
            while (currentMaillon != null) {
                System.out.print(currentMaillon.numero + " ");
                currentMaillon = currentMaillon.suiv;
            }
            System.out.println();
            current = current.suiv;
        }
    }

    public static void main(String[] args) {
        // Création de l'arbre binaire
        ArbreBinaire arbre = new ArbreBinaire();
        int[] pagesFatou = {110, 250, 300};
        int[] pagesMamadou = {3, 14, 101};
        int[] pagesPierre = {3, 7, 100, 287};
        int[] pagesOusseynou = {1, 50};
        int[] pagesSoda = {6, 10, 34, 66, 98};

        arbre.ajouterNoeud("Fatou", pagesFatou);
        arbre.ajouterNoeud("Mamadou", pagesMamadou);
        arbre.ajouterNoeud("Pierre", pagesPierre);
        arbre.ajouterNoeud("Ousseynou", pagesOusseynou);
        arbre.ajouterNoeud("Soda", pagesSoda);

        // Suppression du numéro 110 associé au nom "Fatou"
        arbre.supprimerNumero("Fatou", 110);

        // Affichage de l'arbre binaire
        System.out.println("Arbre Binaire :");
        arbre.afficherArbre();
    }
}