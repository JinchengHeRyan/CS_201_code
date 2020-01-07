class Password {
    private String password;

    public Password(String password) {
        this.password = password;
    }
    
    public boolean verify() {
        boolean ans1 = (this.password.length() >= 8);
        boolean ans2 = this.password.matches(".*\\d+.*");
        boolean ans3 = false;
        boolean ans4 = false;
        boolean ans5 = this.password.matches(".*[^a-zA-Z0-9]+.*");

        for (int i = 0; i < this.password.length(); i++) {
            char c = this.password.charAt(i);
            if (Character.isUpperCase(c)) {
                ans3 = true;
            }
            if (Character.isLowerCase(c)) {
                ans4 = true;
            }
        }
        return(ans1 & ans2 & ans3 & ans4 & ans5);
    }
}

public class Problem_3_1_32 {
    public static void main(String[] args) {
        String password = args[0];
        Password a = new Password(password);
        System.out.println(a.verify());
    }
}