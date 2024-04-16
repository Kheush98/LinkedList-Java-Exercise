/**
 * Classe représentant une liste chaînée de mots.
 */
class Liste {
    Maillon tete; 

    Liste() {
        this.tete = null;
    }

    /**
     * Ajoute un nouveau maillon contenant le mot au début de la liste.
     * @param mot Le caractère représentant le mot à ajouter.
     */
    void ajouteDebut(char mot) {
        Maillon nouveau = new Maillon(mot);
        nouveau.suiv = this.tete;
        this.tete = nouveau;
    }

    /**
     * Ajoute un nouveau maillon contenant le mot à la fin de la liste.
     * @param mot Le caractère représentant le mot à ajouter.
     */
    void ajouteFin(char mot) {
        Maillon nouveau = new Maillon(mot);
        if (this.tete == null) {
            this.tete = nouveau;
            return;
        }
        Maillon dernier = this.tete;
        while (dernier.suiv != null) {
            dernier = dernier.suiv;
        }
        dernier.suiv = nouveau;
    }

    /**
     * Supprime les doublons consécutifs dans la liste.
     */
    void purifie() {
        Maillon courant = this.tete;
        while (courant != null && courant.suiv != null) {
            Maillon suivant = courant.suiv;
            if (courant.mot == suivant.mot) {
                courant.suiv = suivant.suiv;
            } else {
                courant = courant.suiv;
            }
        }
    }

    /**
     * Affiche les premiers n mots de la liste.
     * @param n Le nombre de mots à afficher.
     */
    void afficherPremiers(int n) {
        System.out.println("Nous allons afficher les " + n + " premiers éléments :");
        Maillon courant = this.tete;
        int compteur = 0;
        while (courant != null && compteur < n) {
            System.out.println(courant.mot);
            courant = courant.suiv;
            compteur++;
        }
    }

    /**
     * Supprime le maillon contenant le mot spécifié de la liste.
     * @param mot Le caractère représentant le mot à supprimer.
     */
    void supprimer(char mot) {
        Maillon prec = null;
        Maillon courant = this.tete;
        while (courant != null) {
            if (courant.mot == mot) {
                if (prec == null) {
                    this.tete = courant.suiv;
                } else {
                    prec.suiv = courant.suiv;
                }
                break; // On a trouvé et supprimé le mot, donc on arrête la recherche
            }
            prec = courant;
            courant = courant.suiv;
        }
    }
}

