public class Minesweeper {
    public static void main(String[] args){
        int size = 9;
        boolean[][] mines = new boolean[size][size];

        int numberOfMines = 10;
        for (int i = 0; i < numberOfMines; i++) {
            while (true) {
                int x = (int) Math.floor(Math.random() * size);
                int y = (int) Math.floor(Math.random() * size);

                if (!mines[x][y]) {
                    mines[x][y] = true;
                    break;
                }
            }
        }

        int[][] counts = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (mines[x][y]) {
                    for (int x1 = Math.max(0, x - 1); x1 <= Math.min(size - 1, x + 1); x1++) {
                        for (int y1 = Math.max(0, y - 1); y1 <= Math.min(size - 1, y + 1); y1++) {
                            ++counts[x1][y1];
                        }
                    }
                }
            }
        }

        // int squareSize = 20;
        // StdDraw.setCanvasSize(size * squareSize, size * squareSize);
        // StdDraw.setXscale(0, size * squareSize);
        // StdDraw.setYscale(-size * squareSize, 0);
        // for (int x = 0; x < size; x++) {
        //     for (int y = 0; y < size; y++) {
        //         if (mines[x][y]) {
        //             StdDraw.filledEllipse(x * squareSize + squareSize / 2, -y * squareSize - squareSize / 2, squareSize / 2, squareSize / 2);
        //         } else if (counts[x][y] > 0) {
        //             StdDraw.text(x * squareSize + squareSize / 2, -y * squareSize - squareSize / 2, "" + counts[x][y]);
        //         }
        //     }
        // }

        int xCursor = 0;
        int yCursor = 0;
        boolean[][] revealed = new boolean[size][size];
        while (true) {
            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    System.out.print(xCursor == x && yCursor == y ? ">" : " ");
                    System.out.print(revealed[x][y] ? (counts[x][y] == 0 ? "_" : counts[x][y]) : "X");
                }
                System.out.println();
            }
    
            System.out.print("(u)p, (d)own, (l)eft, (r)ight, (s)tep? ");
            // char ch = StdIn.readChar();
            char ch = StdIn.readLine().charAt(0);
            System.out.println();
            if (ch == 'u') {
                --yCursor;
            } else if (ch == 'd') {
                ++yCursor;
            } else if (ch == 'l') {
                --xCursor;
            } else if (ch == 'r') {
                ++xCursor;
            } else if (ch == 's') {
                if (mines[xCursor][yCursor]) {
                    System.out.println("Sorry.. you stepped on a mine");
                    break;
                }
                revealed[xCursor][yCursor] = true;
            }
        }

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                System.out.print(" ");
                System.out.print(mines[x][y] ? "*" : (counts[x][y] == 0 ? "_" : counts[x][y]));
            }
            System.out.println();
        }
    }
}