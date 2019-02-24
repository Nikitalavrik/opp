
// класс Task, реализирующий интерфейс Runnable
public class Task implements Runnable {

    private Thread T;
    private String T_Name;
    private Function Func;
    private int Block_Time;

    // сохранение параметров потока в переменные
    public Task(String name, Function exec_func, int sleep_time) {

        T_Name = name;
        Func  = exec_func;
        Block_Time = sleep_time;
    }

    // метод, который исполняется при старте потока
    public void run() {
        System.out.println(T_Name + " started\n");

         try {
            // Блокирование потока на Block_Time времени
            Thread.sleep(Block_Time);

        } catch (InterruptedException e) {

             e.printStackTrace();

        }
        // вызов соответствующей функиции F1-F3
        Func.Calc();

        System.out.println(T_Name + " finished\n");
    }


}