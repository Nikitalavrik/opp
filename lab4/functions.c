/*********************************************/
/*                                           */
/*                                           */
/*          Lavrinenko Nikita IO-62          */
/*                                           */
/*                                           */
/*********************************************/

#include "opp.h"

void    *Task1(void *str)
{
    sleep(2);
    
    float **ME, **MD;
    float *D, *C, *B, *A;

    //printf("%s\n", str);
    D = Fill_Vector(1.0);
    C = Fill_Vector(1.0);
    B = Fill_Vector(1.0);
    MD = Fill_Matrix(1.0);
    ME = Fill_Matrix(1.0);
    A = Add_Vec(Add_Vec(B, C),
    Mull_VecxMatr(D, Mull_Matr(MD, ME)));
    pthread_mutex_lock(&mutex);
    printf("\nTask1 finish\nTask1 result:\n");
    Print_Vec(A);
    pthread_mutex_unlock(&mutex);
}

void    *Task2(void *str)
{
    sleep(1);
    float **MG, **MK, **ML, **MF;

    printf("%s\n", str);
    MG = Fill_Matrix(2.0);
    ML = Fill_Matrix(2.0);
    MK = Fill_Matrix(2.0);
    MF = Add_Matr(Tranc_Matr(MG),
    Mull_Matr(MK, ML));
    pthread_mutex_lock(&mutex);
    printf("\nTask2 finish\nTask2 result:\n");
    Print_Matr(MF);
    pthread_mutex_unlock(&mutex);
}

void    *Task3(void *str)
{
    sleep(3);

    float **MO, **MS, **MR;
    float *P, *S, *T;

    printf("%s\n", str);
    MO = Fill_Matrix(3.0);
    MS = Fill_Matrix(3.0);
    MR = Fill_Matrix(3.0);
    P = Fill_Vector(3.0);
    S = Fill_Vector(3.0);
    T = Add_Vec(Mull_VecxMatr(P, MO),
    Mull_VecxMatr(S, Mull_Matr(MS, MR)));
    pthread_mutex_lock(&mutex);
    printf("\nTask3 finish\nTask3 result:\n");
    Print_Vec(T);
    pthread_mutex_unlock(&mutex);
}