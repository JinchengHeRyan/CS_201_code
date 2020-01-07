import nspace.PolarComplex;
import nspace.StandardComplex;

public class Test {
    public static void testComplex(StandardComplex a, PolarComplex b, StandardComplex c) {
        System.out.println(a.magnitude());
        System.out.println(b.im());

        System.out.println(a.plus(b));
        System.out.println(b.plus(a));

        System.out.println(a.minus(b));
        System.out.println(b.minus(a));

        System.out.println(a.plus(c));
        System.out.println(c.plus(a));
    }

    public static void main(String[] args) {
        StandardComplex a1 = new StandardComplex(3, 4);
        PolarComplex b1 = new PolarComplex(5, Math.PI / 2);
        StandardComplex c1 = new StandardComplex(5, 6);
        testComplex(a1, b1, c1);
    }
}