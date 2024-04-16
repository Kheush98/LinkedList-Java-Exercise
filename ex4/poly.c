#include <stdio.h>

typedef struct Monome
{
    float coefficient;
    int exposant;
    struct Monome* suivant;
} Monome;

typedef Monome* Polynome;

Polynome DERIVEE(Polynome P) {
    Polynome derivee = NULL;
    Polynome current = P;

    while (current != NULL)
    {
        float new_coeff = current->coefficient * current->exposant;
        int new_exposant = current->exposant - 1;

        if (new_coeff != 0)
        {
            Polynome new_monome = (Polynome)malloc(sizeof(Monome));
            new_monome->coefficient = new_coeff;
            new_monome->exposant = new_exposant;
            new_monome->suivant = NULL;

            if (derivee == NULL)
            {
                derivee = new_monome;
            }
            else
            {
                Polynome tmp = derivee;
                while (tmp->suivant != NULL)
                {
                    tmp = tmp->suivant;
                }
                
            }
            
        }
        
    }
    
}
