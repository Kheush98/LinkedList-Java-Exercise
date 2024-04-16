public class Main {
    public static void main(String[] args) {
        float[] t = {0, 0, 9, 5, 0, 7, 0, 3, 0, 0};
        float[] f = {0, 2, 4, 6, 8, 0};

        VecteurCreux profTest = new VecteurCreux(t);
        VecteurCreux profTest2 = new VecteurCreux(f);

        System.out.println("Vecteur creux 1 :");
        profTest.afficher();

        System.out.println("\nVecteur creux 2 :");
        profTest2.afficher();

        VecteurCreux sum = VecteurCreux.somme(profTest, profTest2);

        System.out.println("\nSomme des vecteurs creux :");
        sum.afficher();
    }
}