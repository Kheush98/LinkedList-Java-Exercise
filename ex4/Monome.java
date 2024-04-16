/**
 * Représente un monôme dans un polynôme.
 */
class Monome {
    int coefficient;    
    int exposant;       
    Monome suivant;     

    /**
     * Constructeur pour initialiser un monôme avec un coefficient et un exposant.
     * @param coefficient le coefficient du monôme
     * @param exposant l'exposant du monôme
     */
    public Monome(int coefficient, int exposant) {
        this.coefficient = coefficient;
        this.exposant = exposant;
        this.suivant = null;
    }
}