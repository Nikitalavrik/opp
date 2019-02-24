/*********************************************/
/*                                           */
/*                                           */
/*          Lavrinenko Nikita IO-62          */
/*                                           */
/*                                           */
/*********************************************/

#include "opp.h"

float   **Fill_Matrix(float num)
{
    float   **matr;

    if (!(matr = (float **)malloc(sizeof(float *) * (N + 1))))
        return (NULL);
    for (int i = 0; i < N; i++)
        matr[i] = Fill_Vector(num);
    matr[N] = NULL;
    return (matr);
}

float   **Add_Matr(float **Matr1, float **Matr2)
{
    for (int i = 0; i < N; i++)
        Matr1[i] = Add_Vec(Matr1[i], Matr2[i]);
    return (Matr1);
}

float **Mull_Matr(float **Matr1, float **Matr2)
{
    float **matr;

    matr = Fill_Matrix(0.0);
    for (int i = 0; i < N; i ++)
        for (int j = 0; j < N; j++)
            for (int k = 0; k < N; k++)
                matr[i][j] += Matr1[i][k] * Matr2[k][j];
    return (matr);
}

float   **Mull_MatrxNum(float a, float **MB)
{
    float **matr;

    matr = Fill_Matrix(0.0);
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            matr[i][j] = a * MB[i][j];
    return (matr);
}

float   **Tranc_Matr(float **Matr)
{
    float **ResMatr;

    ResMatr = Fill_Matrix(0.0);
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            ResMatr[i][j] = Matr[j][i];
    return (Matr);
}

void    Print_Matr(float ** Matr)
{
    for (int i = 0; i < N; i++)
        Print_Vec(Matr[i]);
    printf("\n");
}