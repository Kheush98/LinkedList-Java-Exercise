/**
 * Classe représentant un vecteur creux.
 */
class VecteurCreux {
    Maillon tete;

    /**
     * Constructeur pour initialiser un vecteur creux à partir d'un tableau de valeurs.
     * @param t Le tableau de valeurs.
     */
    VecteurCreux(float[] t) {
        this.tete = null;
        for (int i = 0; i < t.length; i++) {
            if (t[i] != 0) {
                if (this.tete == null) {
                    this.tete = new Maillon(i, t[i]);
                } else {
                    Maillon current = this.tete;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = new Maillon(i, t[i]);
                }
            }
        }
    }

    /**
     * Méthode pour effectuer la somme de deux vecteurs creux.
     * @param a Le premier vecteur creux.
     * @param b Le deuxième vecteur creux.
     * @return Le vecteur creux représentant la somme des deux vecteurs donnés.
     */
    static VecteurCreux somme(VecteurCreux a, VecteurCreux b) {
        VecteurCreux result = new VecteurCreux(new float[Math.max(size(a), size(b))]);
        Maillon currentA = a.tete;
        Maillon currentB = b.tete;

        while (currentA != null || currentB != null) {
            if (currentA != null && currentB != null) {
                if (currentA.idx == currentB.idx) {
                    float sum = currentA.value + currentB.value;
                    if (sum != 0) {
                        result.ajouterMaillon(currentA.idx, sum);
                    }
                    currentA = currentA.next;
                    currentB = currentB.next;
                } else if (currentA.idx < currentB.idx) {
                    result.ajouterMaillon(currentA.idx, currentA.value);
                    currentA = currentA.next;
                } else {
                    result.ajouterMaillon(currentB.idx, currentB.value);
                    currentB = currentB.next;
                }
            } else if (currentA != null) {
                result.ajouterMaillon(currentA.idx, currentA.value);
                currentA = currentA.next;
            } else {
                result.ajouterMaillon(currentB.idx, currentB.value);
                currentB = currentB.next;
            }
        }

        return result;
    }

    /**
     * Méthode utilitaire pour obtenir la taille d'un vecteur creux.
     * @param v Le vecteur creux.
     * @return La taille du vecteur creux.
     */
    private static int size(VecteurCreux v) {
        int size = 0;
        Maillon current = v.tete;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    /**
     * Méthode pour ajouter un maillon à la fin du vecteur creux.
     * @param idx L'index du maillon.
     * @param value La valeur du maillon.
     */
    private void ajouterMaillon(int idx, float value) {
        if (this.tete == null) {
            this.tete = new Maillon(idx, value);
        } else {
            Maillon current = this.tete;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Maillon(idx, value);
        }
    }

    /**
     * Méthode pour afficher le vecteur creux.
     */
    void afficher() {
        Maillon current = this.tete;
        while (current != null) {
            System.out.println("Composante " + current.idx + " = " + current.value);
            current = current.next;
        }
    }
}