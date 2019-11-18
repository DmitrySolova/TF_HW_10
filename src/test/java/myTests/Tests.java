package myTests;

import my.Sort;
import org.hamcrest.*;
import org.junit.*;


public class Tests {


//  Проверяет правильность сортировки массива
    @Test
    public void Test1() {

        int[] array1 = {53, 6, 1, 1, 53, 42, 7, 9, 0, 8, 12, 43, 12, 33, 51, 56, 551, 42, 10002, 100, 5, 1, 3, 42};

        int[] sortArray1 = new Sort(array1).startSort();

        boolean sorted = true;
        for(int i = 1; i < sortArray1.length; i++) {
            if(sortArray1[i-1] > sortArray1[i]){
                sorted = false;
                break;
            }
        }

        MatcherAssert.assertThat("Массив отсортирован неправильно!", sorted);

    }

//   Проверяет длину отсортированного и обычного массива
    @Test
    public void Test2() {
        int[] array2 = {53, 6, 1, 1, 53, 42, 7, 9, 0, 8, 12, 43, 12, 33, 51, 56, 551, 42, 10002, 100, 5, 1, 3, 42};
        int len1 = array2.length;

        int[] sortArray2 = new Sort(array2).startSort();
        int len2 = sortArray2.length;

        Assert.assertEquals("Длина массивов не совпадает! Возмодно сортировщик выкинул повторяющиеся элементы!", len1, len2);
    }

//   Проверяет несовпадение последних элементов массивов
    @Test
    public void Test3() {
        int[] array3 = {53, 6, 1, 1, 53, 42, 7, 9, 0, 8, 12, 43, 12, 33, 51, 56, 551, 42, 10002, 100, 5, 1, 3, 42};

        Assert.assertNotEquals("Последние элементы в отсортированном и в неотсортированном массивах одинаковые!",
                array3[array3.length - 1],
                new Sort(array3).startSort()[new Sort(array3).startSort().length - 1]);
    }

}
