// Основи Паралельного програмування
// Лабораторна робота №2
// Потоки в мові програмування Java
// F1: A  = B + C + D * (MD * ME)
// F2: MF = TRANS(MG) + MK * ML
// F3: T  = MO * P + (MR * MS) * S
// Лавріненко Нікіта Тарасович ІО-62
// дата: 12.10.2018

// функция F1, реализирующая интерфес Function
class F1 implements Function {

    private Vector vect = new Vector();
    private Matrix matr = new Matrix();
    private double[] A, B, C, D;
    private double[][] ME, MD;

    @Override
    public void Calc() {

        // заполнение данных
        B = vect.Fill_Vector(1.0);
        C = vect.Fill_Vector(1.0);
        D = vect.Fill_Vector(1.0);
        MD = matr.Fill_Matrix(1.0);
        ME = matr.Fill_Matrix(1.0);
        // вычисление результата
        A = vect.Add_Vec(vect.Add_Vec(B, C), 
        vect.Mull_VecxMatr(D, matr.Mull_Matr(MD, ME)));
        // вывод результата
        System.out.println("T1 Result: \n");
        vect.Print_Vector(A);
    }
}

// функция F2, реализирующая интерфес Function
class F2 implements Function {

    private Matrix matr = new Matrix();
    private double[][] MK, MF, MG, ML;

    @Override
    public void Calc() {

        // заполнение данных
        MG = matr.Fill_Matrix(2.0);
        MK = matr.Fill_Matrix(2.0);
        ML = matr.Fill_Matrix(2.0);
        // вычисление результата
        MF = matr.Add_Matr(matr.Tranc_Matr(MG), matr.Mull_Matr(MK, ML));
        // вывод результата
        System.out.println("T2 Result: \n");
        matr.Print_Matrix(MF);
    }
}

// функция F3, реализирующая интерфес Function
class F3 implements Function {

    private Vector vect = new Vector();
    private Matrix matr = new Matrix();
    private double[] P, S, T;
    private double[][] MR, MO, MS;

    @Override
    public void Calc() {

        // заполнение данных
        P = vect.Fill_Vector(3.0);
        S = vect.Fill_Vector(3.0);
        MR = matr.Fill_Matrix(3.0);
        MO = matr.Fill_Matrix(3.0);
        MS = matr.Fill_Matrix(3.0);
        // вычисление результата
        T = vect.Add_Vec(vect.Mull_VecxMatr(P, MO), 
        vect.Mull_VecxMatr(S, matr.Mull_Matr(MR, MS)));
        // вывод результата
        System.out.println("T3 Result: \n");
        vect.Print_Vector(T);
    }
}

public class Lab2 {
    public static final int N = 4;

    public static void main(String[] args) {
        
        System.out.println("Main starts");
        // объекты функций 
        F1 Func1 = new F1();
        F2 Func2 = new F2();
        F3 Func3 = new F3();

        // объекты реализирующие интерфейс Runnable 
        // с соответствующими функциями
        Task Ts1 = new Task("T1", Func1, 0);
        Task Ts2 = new Task("T2", Func2, 500);
        Task Ts3 = new Task("T3", Func3, 1000);

        // Создание потоков
        Thread T1 = new Thread(Ts1); 
        Thread T2 = new Thread(Ts2); 
        Thread T3 = new Thread(Ts3); 

        // указывание приоритета
        T1.setPriority(4);
        T2.setPriority(1);
        T3.setPriority(5);

        // запуск потоков
        T1.start();
        T2.start();
        T3.start(); 

        // для использования join
        // прописано исключение InterruptedException 
        try 
        {
            T1.join();
            T2.join();
            T3.join();
        } 
        catch(InterruptedException e)
        {
            System.out.println("InterruptedException");
        }
        System.out.println("Main end");
    }
}