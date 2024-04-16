/**
 * Classe représentant un maillon d'une liste chaînée de numéros.
 */
class Maillon {
    int numero;
    Maillon suiv, prec;

    /**
     * Constructeur pour initialiser un maillon avec un numéro donné.
     * @param numero Le numéro à associer au maillon.
     */
    Maillon(int numero) {
        this.numero = numero;
        this.suiv = null;
        this.prec = null;
    }
}