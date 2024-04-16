/**
 * Représente un maillon d'un vecteur creux.
 */
class Maillon {
    int idx;
    float value;
    Maillon next;

    /**
     * Constructeur pour initialiser un maillon avec un index et une valeur donnés.
     * @param idx L'index du maillon.
     * @param value La valeur du maillon.
     */
    Maillon(int idx, float value) {
        this.idx = idx;
        this.value = value;
        this.next = null;
    }
}