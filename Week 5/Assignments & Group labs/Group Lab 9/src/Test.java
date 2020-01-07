import java.util.ArrayList;
import java.util.Collections;
import nspace.Complex;
import nspace.PolarComplex;
import nspace.StandardComplex;

public class Test {
    public static void main(String[] args) {
        ArrayList<Complex> complex_list = new ArrayList<>();
        complex_list.add(new StandardComplex(1, 2));
        complex_list.add(new PolarComplex(-1, 0));
        complex_list.add(new PolarComplex(1, 0));
        complex_list.add(new StandardComplex(4, 5));

        Collections.sort(complex_list);
        System.out.println(complex_list);
    }
}