/**
 * Classe représentant un maillon dans une liste doublement chaînée.
 */
class Maillon {
    private String info;        
    private Maillon suivant;    
    private Maillon precedent;  

    /**
     * Constructeur pour initialiser un maillon avec une information donnée.
     * @param info L'information à stocker dans le maillon.
     */
    public Maillon(String info) {
        this.info = info;
        this.suivant = null;
        this.precedent = null;
    }

    // Getters et setters pour accéder aux informations et aux références

    /**
     * Getter pour l'information stockée dans le maillon.
     * @return L'information stockée dans le maillon.
     */
    public String getInfo() {
        return info;
    }

    /**
     * Getter pour le maillon suivant dans la liste.
     * @return Le maillon suivant dans la liste.
     */
    public Maillon getSuivant() {
        return suivant;
    }

    /**
     * Setter pour définir le maillon suivant dans la liste.
     * @param suivant Le maillon suivant à définir.
     */
    public void setSuivant(Maillon suivant) {
        this.suivant = suivant;
    }

    /**
     * Getter pour le maillon précédent dans la liste.
     * @return Le maillon précédent dans la liste.
     */
    public Maillon getPrecedent() {
        return precedent;
    }

    /**
     * Setter pour définir le maillon précédent dans la liste.
     * @param precedent Le maillon précédent à définir.
     */
    public void setPrecedent(Maillon precedent) {
        this.precedent = precedent;
    }
}