public class Maillon {
    public String mot;
    public Maillon suivant;
    
    public Maillon(String mot) {
        this.mot = mot;
        this.suivant = null;
    }
}