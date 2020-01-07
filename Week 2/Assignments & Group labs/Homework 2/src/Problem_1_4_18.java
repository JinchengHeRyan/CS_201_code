import java.util.Arrays;
public class Problem_1_4_18 {
    public static void main(String[] args) {
        int a[][], b[][];
        int row_1, col_1, row_2, col_2;
        while (true) {
            System.out.println("Please enter an integer for the row number of matrix 1");
            row_1 = StdIn.readInt();
            System.out.println("Please enter an integer for the column number of matrix 1");
            col_1 = StdIn.readInt();
            System.out.println("Please enter an integer for the row number of matrix 2");
            row_2 = StdIn.readInt();
            System.out.println("Please enter an integer for the column number of matrix 2");
            col_2 = StdIn.readInt();
            if (col_1 == row_2) {
                break;
            }
            else {
                System.out.println("Error: Row_2 != Col_1, Please enter again");
            }
        }
        a = new int[row_1][col_1];
        b = new int[row_2][col_2];

        System.out.println("Please enter the entries for matrix 1");
        int count_1 = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.println("You have another " + (row_1 * col_1 - count_1) + " entries to enter for matrix 1");
                a[i][j] = StdIn.readInt();
                count_1++;
            }
        }
        

        System.out.println("Please enter the entries for matrix 2");
        int count_2 = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.println("You have another " + (row_2 * col_2 - count_2) + " entries to enter for matrix 2");
                b[i][j] = StdIn.readInt();
                count_2++;
            }
        }

        System.out.println("Here is the matrix 1: ");
        for (int i = 0; i < a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }
        
        System.out.println("Here is the matrix 2: ");
        for (int i = 0; i < b.length; i++){
            System.out.println(Arrays.toString(b[i]));
        }

        int c[][];
        c = new int[row_1][col_2];
        for (int i = 0; i < row_1; i++) {
            for (int j = 0; j < col_2; j++) {
                for (int x = 0; x < col_1; x++) {
                    c[i][j] += a[i][x] * b[x][j];
                }
            }
        }

        System.out.println("Here is the answer");
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
    }
}