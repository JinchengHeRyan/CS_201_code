import java.util.Arrays;

public class Problem_1_4_15 {
    public static void main(String[] args) {
        int a[][];
        System.out.println("Please enter an integer of size");
        int size = StdIn.readInt();
        a = new int[size][size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("You have " + (size*size - count) + " integers to enter, press enter button after input one integer");
                count++;
                a[i][j] = StdIn.readInt();
            }
        }
        
        System.out.println("The original array looks like this: ");
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

        // Transpose
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        System.out.println("The transposed array looks like this: ");
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}