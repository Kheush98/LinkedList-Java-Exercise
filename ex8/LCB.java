/**
 * Classe représentant une liste chaînée de numéros.
 */
class LCB {
    Maillon tete, queue;

    /**
     * Constructeur pour initialiser une liste chaînée vide.
     */
    LCB() {
        this.tete = null;
        this.queue = null;
    }

    /**
     * Méthode pour ajouter un numéro dans la liste chaînée, en maintenant l'ordre croissant.
     * @param num Le numéro à ajouter.
     * @return La liste chaînée mise à jour.
     */
    LCB ajoutNumero(int num) {
        Maillon nouveau = new Maillon(num);

        // Cas où la liste est vide
        if (this.tete == null) {
            this.tete = nouveau;
            this.queue = nouveau;
            return this;
        }

        // Parcourir la liste pour trouver la bonne position d'insertion
        Maillon current = this.tete;
        Maillon prec = null;
        while (current != null && num > current.numero) {
            prec = current;
            current = current.suiv;
        }

        if (current == null) {
            // Ajout en fin de liste
            this.queue.suiv = nouveau;
            nouveau.prec = this.queue;
            this.queue = nouveau;
        } else if (prec == null) {
            // Ajout en tête de liste
            nouveau.suiv = this.tete;
            this.tete.prec = nouveau;
            this.tete = nouveau;
        } else {
            // Ajout au milieu de la liste
            prec.suiv = nouveau;
            nouveau.prec = prec;
            nouveau.suiv = current;
            current.prec = nouveau;
        }

        return this;
    }

    /**
     * Méthode pour supprimer un numéro de la liste chaînée.
     * @param num Le numéro à supprimer.
     * @return La liste chaînée mise à jour.
     */
    LCB supprimerNumero(int num) {
        if (this.tete == null) {
            // Liste vide, rien à supprimer
            return this;
        }

        Maillon current = this.tete;
        while (current != null && current.numero != num) {
            current = current.suiv;
        }

        if (current == null) {
            // Numéro non trouvé dans la liste
            return this;
        }

        // Cas où le numéro est en tête de liste
        if (current == this.tete) {
            this.tete = current.suiv;
            if (this.tete != null) {
                this.tete.prec = null;
            }
            return this;
        }

        // Cas où le numéro est en fin de liste
        if (current == this.queue) {
            this.queue = current.prec;
            this.queue.suiv = null;
            return this;
        }

        // Cas où le numéro est au milieu de la liste
        current.prec.suiv = current.suiv;
        current.suiv.prec = current.prec;
        return this;
    }
}



