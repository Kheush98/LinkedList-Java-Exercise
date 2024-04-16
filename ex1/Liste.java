public class Liste {
    Maillon head;

    public Liste() {
        this.head = null;
    }

    public Liste ajouteDebut(String mot) {
        Maillon newMaillon = new Maillon(mot);

        newMaillon.suivant = this.head;
        this.head = newMaillon;

        return this;
    }

    public Liste ajoutFin(String mot) {
        Maillon newMaillon = new Maillon(mot);
        Maillon tmp = this.head;

        while (tmp.suivant != null) {
            tmp = tmp.suivant;
        }

        tmp.suivant = newMaillon;
        return this;
    }

    public Liste supprimer(String mot) {
        Maillon tmp = this.head;
        Maillon precedent = null;

        while (tmp != null) {
            if (tmp.mot.equals(mot)) {
                if (precedent == null) {
                    this.head = tmp.suivant;
                } else {
                    precedent.suivant = tmp.suivant;
                }

                return this;
            }
            tmp = tmp.suivant;
        }

        System.out.println("Le mot n'est pas trouvé");
        return this;
    }

    void premiers(int n) {
        
    }
}
