/*********************************************/
/*                                           */
/*                                           */
/*          Lavrinenko Nikita IO-62          */
/*                                           */
/*                                           */
/*********************************************/

extern const int N;


#ifndef OPP_H
# define OPP_H

# include <stdlib.h>
# include <stdio.h>
# include <pthread.h>
# include <strings.h>
# include <unistd.h>

extern pthread_mutex_t mutex;

float   *Fill_Vector(float num);
float   **Fill_Matrix(float num);
float   *Add_Vec(float *V1, float *V2);
float   **Add_Matr(float **Matr1, float **Matr2);
float   *Mull_VecxMatr(float *Vect, float **Matr);
float   **Mull_MatrxNum(float a, float **MB);
float   **Tranc_Matr(float **Matr);
float   **Mull_Matr(float **Matr1, float **Matr2);

void    Print_Vec(float *Vect);
void    Print_Matr(float ** Matr);

void    *Task1(void *str);
void    *Task2(void *str);
void    *Task3(void *str);

#endif