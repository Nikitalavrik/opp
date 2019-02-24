/*********************************************/
/*                                           */
/*                                           */
/*          Lavrinenko Nikita IO-62          */
/*                                           */
/*                                           */
/*********************************************/

#include "opp.h"

float   *Fill_Vector(float num)
{
    float   *vector;

    if(!(vector = (float *)malloc(sizeof(float) * (N + 1))))
        return (NULL);
    for (int i = 0; i < N; i++)
        vector[i] = num;
    return (vector);
}

float   *Add_Vec(float *V1, float *V2)
{
    for (int i = 0; i < N; i++)
        V1[i] += V2[i];
    return (V1);
}

float   *Mull_VecxMatr(float *Vect, float **Matr)
{
    float   *vector;

    if(!(vector = (float *)malloc(sizeof(float) * (N + 1))))
        return (NULL);
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            vector[i] = vector[i] + Matr[i][j] * Vect[i];
    return (vector);
}

void    Print_Vec(float *Vect)
{
    printf("| ");
    for (int i = 0; i < N; i++)
        printf("%f ", Vect[i]);
    printf("|\n");
}