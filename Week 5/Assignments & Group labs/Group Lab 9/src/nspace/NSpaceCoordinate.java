package nspace;

import java.util.ArrayList;

public class NSpaceCoordinate {
    public ArrayList coordinates = new ArrayList();

    public NSpaceCoordinate(double n1) {
        this.coordinates.add(n1);
    }

    public NSpaceCoordinate(double n1, double n2) {
        this.coordinates.add(n1);
        this.coordinates.add(n2);
    }

    public NSpaceCoordinate(double n1, double n2, double n3) {
        this.coordinates.add(n1);
        this.coordinates.add(n2);
        this.coordinates.add(n3);
    }

    public NSpaceCoordinate(double[] n) {
        for (int i = 0; i < n.length; i++) {
            this.coordinates.add(n[i]);
        }
    }

    public final double magnitude() {
        double ans = 0;
        for (int i = 0; i < this.coordinates.size(); i++) {
            ans += (double) this.coordinates.get(i) * (double) this.coordinates.get(i);
        }
        return Math.sqrt(ans);
    }

    public final double getCoordinate(int i) {
        return (double) this.coordinates.get(i);
    }
}