/**
 * Classe représentant un nœud d'un arbre binaire.
 */
class Noeud {
    String nom;
    LCB index;
    Noeud suiv, prec;

    /**
     * Constructeur pour initialiser un nœud avec un nom donné et une liste chaînée vide.
     * @param nom Le nom associé au nœud.
     */
    Noeud(String nom) {
        this.nom = nom;
        this.index = new LCB();
        this.suiv = null;
        this.prec = null;
    }
}