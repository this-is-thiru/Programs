package algos.sort;

import java.util.Arrays;

public class SelectionSort {
    private String name;

    private int age;

    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 4, 5, 6, 7, 8, 9, 10 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        SelectionSort s = new SelectionSort();
        s.setName("John");
        s.setAge(25);
        s.setSalary(50000.00);
        System.out.println(Arrays.toString(s.getClass().getFields()));
    }
}
