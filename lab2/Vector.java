import java.util.Arrays;

public class Vector {

    // размер матрицы
    private static Integer size = Lab2.N;

    // генерируем вектор, заполненый случайными числами
    public double[] Random_Vector() {
        double[] vec = new double[size];
        for (int i = 0; i < size; i++) {
            vec[i] = Math.random() * 20.0;
        }
        return vec;
    }

    // заполняем вектора заданым числом
    public double[] Fill_Vector(double number) {
        double[] ResultVector = new double[size];
        for (int i = 0; i < size; i++) {
            ResultVector[i] = number;
        }
        return ResultVector;
    }

    // сумимруем вектора
    public double[] Add_Vec(double[] Vec1, double[] Vec2) {
        for (int i = 0; i < size; i++) {
                Vec1[i] = Vec1[i] + Vec2[i];
        }
        return Vec1;
    }

    // умножение вектора на матрицу
    public double[] Mull_VecxMatr(double[] Vect, double[][] Matr){
        
        double[] ResVector = new double[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ResVector[i] = ResVector[i] + Matr[i][j] * Vect[i];
            }
        }
        return ResVector;
    }

    //вывод вектора
    public void Print_Vector(double[] vec) {
        System.out.println("Result: " + Arrays.toString(vec));
    }
}