public class Problem_1_2_16 {
    public static void main(String[] args) {
        double force, G, mass1, mass2 , r;
        // if the function is force = G * mass1 * mass2 / r * r, 
        // then the computer is actually calculating: (G * mass1 * mass2 / r) * r = G * mass1 * mass2, 
        // however the true function should be: force = ( G * mass1 * mass2 ) / ( r * r )
        // let us have a try:
        G = 1 ; mass1 = 2 ; mass2 = 3 ; r = 4;
        force = G * mass1 * mass2 / r * r;
        System.out.print("force = G * mass1 * mass2 / r * r = ");
        System.out.println(force);
        // Above is the wrong version

        // Let us see the correct version:
        force = G * mass1 * mass2 / (r * r);
        System.out.print("force = G * mass1 * mass2 / (r * r) = ");
        System.out.println(force);
    }
}