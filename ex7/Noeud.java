/**
 * Classe pour représenter un nœud dans un arbre binaire d'entiers.
 */
class Noeud {
    int valeur;
    Noeud gauche;
    Noeud droite;

    /**
     * Constructeur pour créer un nouveau nœud avec une valeur spécifiée.
     * @param valeur La valeur du nœud.
     */
    public Noeud(int valeur) {
        this.valeur = valeur;
        this.gauche = null;
        this.droite = null;
    }
}