/**
 * Classe représentant un maillon dans une liste chaînée de mots.
 */
class Maillon {
    char mot; 
    Maillon suiv; 
    // Constructeur pour créer un nouveau maillon avec un mot donné
    Maillon(char mot) {
        this.mot = mot;
        this.suiv = null;
    }
}