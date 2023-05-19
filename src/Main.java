import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        /*
        double[] a = new double[]{19,7,60,90,1005,200,3,2,9,30,27,7,8};
        MinMaxHeap minMaxHeap = new MinMaxHeap(a);
        minMaxHeap.buildHeap(a);
        System.out.println(Arrays.toString(a));
        a = minMaxHeap.heapInsert(a,250);
        System.out.println(Arrays.toString(a));
*/

        String[] options = {"1- Build Heap",
                "2- Exit",

        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=2){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: makeHeap(); break;
                    case 2: exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }
    public static double[] readFileToArray(String dir) {
        try {
            String fileContent = Files.readString(Path.of(dir));
            String[] numbers = fileContent.trim().split("\\s+");

            double[] array = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                array[i] = Double.parseDouble(numbers[i]);
            }
            return array;
        }
            catch(IOException e){
                e.printStackTrace();
            }
        return null;


    }


    public static void makeHeap() throws IOException {
        String dir = "";
        System.out.println("Please provide the directory of the input file:");
        Scanner scanner = new Scanner(System.in);
        dir = scanner.next();
        if (readFileToArray(dir) != null) {
            double[] array = readFileToArray(dir);
            MinMaxHeap mmh = new MinMaxHeap(array);
            mmh.buildHeap(array);
            menu(mmh, array);
        }
    }

    public static void menu(MinMaxHeap mmh, double[] array) {
        String[] options = {"1- Print Heap",
                "2- Extract Max",
                "3- Extract Min",
                "4- Insert Number",
                "5- Delete Number",
                "6- Heap Sort",
                "7- Exit"
        };

        Scanner menuScanner = new Scanner(System.in);
        int option = 0;
        while (option != 7) {
            printMenu(options);
            option = menuScanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println(Arrays.toString(array));
                    break;
                case 2:
                    array = mmh.heapExtractMax(array);
                    break;
                case 3:
                    array = mmh.heapExtractMin(array);
                    break;
                case 4:
                    array = insert(mmh, array);
                    break;
                case 5:
                    array = delete(mmh, array);
                    break;
                case 6:
                    heapSort();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    public static double[] insert(MinMaxHeap mmh,double[] array){
        System.out.println("Please enter a number to insert: ");
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
       return mmh.heapInsert(array,num);




    }
    public static double[] delete(MinMaxHeap mmh, double[] array){
        System.out.println("Please enter an Integer index between 0" +" and "+ (array.length-1) + "to delete: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num > array.length-1) {
            delete(mmh,array);

        }

        return mmh.heapDelete(array,num);

    }
    public static void heapSort(){

    }
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
}