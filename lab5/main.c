/*************************************/
/* Основи Паралельного програмування */
/* Лабораторна робота №4             */
/* Потоки в мові програмування C     */
/* F1: A  = B + C + D * (MD * ME)    */
/* F2: MF = TRANS(MG) + MK * ML      */
/* F3: T  = MO * P + (MR * MS) * S   */
/* Лавріненко Нікіта Тарасович ІО-62 */
/* дата: 08.11.2018                  */
/*************************************/

#include "opp.h"
const int N = 4;

int     main(void)
{
    omp_set_num_threads(3);
    #pragma omp parallel
    if (omp_get_thread_num() == 0)
        Task1("Task1 start\n");
    else if (omp_get_thread_num() == 1)
        Task2("Task2 start\n");
    else if (omp_get_thread_num() == 2)
        Task3("Task3 start\n");
    return (0);
}