package my;

import java.util.Arrays;

public class Sort {

    //        Сортировка выбором :: Selection sort

    private int array[];
    private int curbest = 0; //current best - текущее максимальное (к примеру 0)
    private int lapl; // last place - последнее место (- 1)
    private int left = 0; // левый элемент
    private int right = 1; // правый элемент

    public Sort(int[] a) {
        this.array = a;
    }

    public int[] startSort() {

        lapl = (this.array != null ? array.length - 1 : 0); // находим последний индекс

        while (lapl != 0){
            //алгоритм нахождения максимума в массиве
            //right - позиция последнего элемента, начиная с 1-цы

            while (right < (lapl + 1)){
                if (array[left] > array[right]){
                    curbest = array[left];
                    right++;
                } else { // array[left] < array[right]
                    curbest = array[right];
                    left = right;
                    right++;
                }
            }

            //алгоритм подставновки максимума в конец неотсортированного массива
            array[left] = array[lapl]; //значение максимального и последнего значения меняются местами
            array[lapl] = curbest;
            lapl--;
            left = 0; // обнуляем левый элемент
            right = 1; // обнуляем правый элемент
        }

        return this.array;
    }

//        System.out.println(Arrays.toString(array)); //выводим отсортированный массив в консоль

}
