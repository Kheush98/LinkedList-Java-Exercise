import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] m1Array = {{1, 2, 3},
                              {2, 4, 5},
                              {3, 5, 6}};
        MatCarree m1 = new MatCarree(m1Array, 3);

        double[][] m2Array = {{1, 2, 3},
                              {-1, 4, 5},
                              {3, 5, 4}};
        MatCarree m2 = new MatCarree(m2Array, 3);

        if (m1.isSymetric()) {
            System.out.println("La matrice m1 est symétrique.");
        } else {
            System.out.println("La matrice m1 n'est pas symétrique.");
        }

        if (m2.isSymetric()) {
            System.out.println("La matrice m2 est symétrique.");
        } else {
            System.out.println("La matrice m2 n'est pas symétrique.");
        }

        double[] compacteM1 = m1.symCompacte();
        System.out.println("=======================");
        System.out.println("Matrice compacte m1 : " + Arrays.toString(compacteM1));

        // Accès à un coefficient dans la matrice compacte m1
        int i = 1;
        int j = 2;
        double coeff = MatCarree.acces(compacteM1, i, j);
        System.out.printf("Coefficient m1[%d][%d] : %.2f\n", i, j, coeff);
    }
}