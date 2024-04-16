/**
 * Classe représentant une liste doublement chaînée.
 */
public class ListeDoublementChainee {
    private Maillon premier;    
    private Maillon dernier;    

    /**
     * Constructeur pour initialiser une liste doublement chaînée vide.
     */
    public ListeDoublementChainee() {
        this.premier = null;
        this.dernier = null;
    }

    /**
     * Méthode pour ajouter un nouveau maillon contenant une information au début de la liste.
     * @param s L'information à stocker dans le nouveau maillon.
     */
    public void ajouterDevant(String s) {
        Maillon nouveauMaillon = new Maillon(s);

        if (premier == null) {
            // Si la liste est vide, le nouveau maillon devient à la fois le premier et le dernier
            premier = nouveauMaillon;
            dernier = nouveauMaillon;
        } else {
            // Sinon, insérer le nouveau maillon au début de la liste
            nouveauMaillon.setSuivant(premier);
            premier.setPrecedent(nouveauMaillon);
            premier = nouveauMaillon;
        }
    }

    /**
     * Méthode pour supprimer un maillon contenant une information spécifique de la liste.
     * @param s L'information à rechercher et supprimer.
     */
    public void supprimer(String s) {
        Maillon courant = premier;

        // Parcourir la liste pour trouver le maillon à supprimer
        while (courant != null && !courant.getInfo().equals(s)) {
            courant = courant.getSuivant();
        }

        if (courant == null) {
            // Le maillon n'a pas été trouvé dans la liste
            System.out.println("Le maillon avec l'information '" + s + "' n'a pas été trouvé");
            return;
        }

        // Mettre à jour les références pour supprimer le maillon de la liste
        if (courant == premier) {
            premier = courant.getSuivant();
        } else {
            courant.getPrecedent().setSuivant(courant.getSuivant());
        }

        if (courant == dernier) {
            dernier = courant.getPrecedent();
        } else {
            courant.getSuivant().setPrecedent(courant.getPrecedent());
        }
    }

    /**
     * Méthode pour afficher les informations dans l'ordre et dans l'ordre inverse.
     */
    public void afficherDansOrdre() {
        System.out.println("Affichage en commençant par le premier");
        Maillon courant = premier;
        while (courant != null) {
            System.out.println(courant.getInfo());
            courant = courant.getSuivant();
        }

        System.out.println("\nAffichage en commençant par le dernier");
        courant = dernier;
        while (courant != null) {
            System.out.println(courant.getInfo());
            courant = courant.getPrecedent();
        }
    }

    /**
     * Méthode principale pour tester les opérations sur la liste doublement chaînée.
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
        ListeDoublementChainee liste = new ListeDoublementChainee();

        liste.ajouterDevant("Premier");
        liste.ajouterDevant("Deuxième");
        liste.ajouterDevant("Troisième");
        liste.ajouterDevant("Quatrième");
        liste.ajouterDevant("Cinquième");
        liste.ajouterDevant("Sixième");
        liste.ajouterDevant("Septième");
        liste.ajouterDevant("Huitième");

        liste.supprimer("Deuxième");

        liste.afficherDansOrdre();
    }
}