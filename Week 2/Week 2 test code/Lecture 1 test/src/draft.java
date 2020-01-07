public class draft {
    public static void main(String[] args) {
        int secret = 1 + (int) (Math.random() * 10);
        StdOut.println("guess a number between 1 to 11");
        while (true) {
            int guess = StdIn.readInt();
            if (guess == secret) {
                break;
            }
            else if (guess > secret) {
                StdOut.println("It's too high");
            }
            else {
                StdOut.println("It's too low");
            }
        }
    }
}