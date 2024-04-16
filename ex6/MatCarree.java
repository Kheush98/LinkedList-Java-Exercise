class MatCarree {
    int len; // len * len
    double[][] mat;

    /**
     * Constructeur pour initialiser une matrice carrée.
     * @param mat La matrice représentant la structure de la matrice carrée.
     * @param len La taille de la matrice carrée (nombre de lignes/colonnes).
     */
    MatCarree(double[][] mat, int len) {
        this.mat = mat;
        this.len = len;
    }

    /**
     * Vérifie si la matrice carrée est symétrique.
     * @return true si la matrice est symétrique, false sinon.
     */
    boolean isSymetric() {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (mat[i][j] != mat[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Construit et renvoie la représentation compacte de la matrice symétrique.
     * @return Un tableau dynamiquement alloué représentant la matrice compacte,
     *         ou null si la matrice n'est pas symétrique.
     */
    double[] symCompacte() {
        if (!isSymetric()) {
            return null;
        }

        int compactSize = len + (len * len - len) / 2;
        double[] tab = new double[compactSize];
        int index = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                tab[index++] = mat[i][j];
            }
        }

        return tab;
    }

    /**
     * Accède au coefficient mi,j de la matrice représentée par la version compacte.
     * @param c La représentation compacte de la matrice symétrique.
     * @param i L'indice de ligne.
     * @param j L'indice de colonne.
     * @return Le coefficient mi,j de la matrice.
     */
    static double acces(double[] c, int i, int j) {
        int index = i * (2 * c.length - i - 1) / 2 + j - i;
        return c[index];
    }
}