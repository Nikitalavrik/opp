import java.util.Arrays;

class Matrix {

    // ?????? ???????
    private static Integer Size = Lab2.N;

    // ?????????? ???????, ?????????? ?????????? ???????
    public double[][] Random_Matrix() {
        double[][] Result = new double[Size][Size];
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                Result[i][j] = Math.random() * 20.0;
            }
        }
        return Result;
    }

    // ?????????? ???????, ???????? ??????
    public double[][] Fill_Matrix(double number) {

        double[][] Result = new double[Size][Size];

        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                Result[i][j] = number;
            }
        }
        return Result;
    }

    // ??????????? ???????
    public double[][] Add_Matr(double[][] Matr1, double[][] Matr2) {
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                Matr1[i][j] = Matr1[i][j] + Matr2[i][j];
            }
        }
        return Matr1;
    }

    // ????????? ??????
    public double[][] Mull_Matr(double[][] MA, double[][] MB) {

        double[][] ResultMatrix = new double[Size][Size];

        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                for (int k = 0; k < Size; k++) {

                    ResultMatrix[i][j] += MA[i][k] * MB[k][j];

                }
            }
        }
        return ResultMatrix;
    }

    // ????????? ??????? ?? ?????
    public double[][] Mull_MatrxNum(double a, double[][] MB) {

        double[][] ResultMatrix = new double[Size][Size];

        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {

                ResultMatrix[i][j] = a * MB[i][j];

            }
        }
        return ResultMatrix;
    }

    // ???????????????? ???????
    public double[][] Tranc_Matr(double[][] Matr){

        double[][] ResMatr = new double[Size][Size];

        for (int i = 0; i < Size; i++){
            for (int j = 0; j < Size; j++){

                ResMatr[i][j] = Matr[j][i];

            }        
        }
        return ResMatr;
    }

    // ????? ???????
    public void Print_Matrix(double[][] matrix) {
        System.out.println("Result:");
        for (int i = 0; i < matrix.length; i++) {

            System.out.println(Arrays.toString(matrix[i]));

        }
    }
}