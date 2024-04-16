/**
 * Classe représentant un maillon dans une liste chaînée.
 */
class Maillon {
    int valeur;         
    Maillon suivant;    
    /**
     * Constructeur pour initialiser un maillon avec une valeur donnée.
     * @param valeur La valeur à stocker dans le maillon.
     */
    public Maillon(int valeur) {
        this.valeur = valeur;
        this.suivant = null;
    }
}