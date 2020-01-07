package nspace;

public class StandardComplex extends NSpaceCoordinate implements Complex {
	public StandardComplex(double real, double imag) {
		super(real, imag);
	}

	// return a string representation of the invoking Complex object
	public String toString() {
		if (this.im() == 0)
			return this.re() + "";
		if (this.re() == 0)
			return this.im() + "i";
		if (this.im() < 0)
			return this.re() + " - " + (-this.im()) + "i";
		return this.re() + " + " + this.im() + "i";
	}

	// return abs/modulus/magnitude
	public double abs() {
		return super.magnitude();
	}

	public double r() {
		return abs();
	}

	public double th() {
		return Math.atan2(this.im(), this.re());
	}

	// return a new Complex object whose value is (this + b)
	public Complex plus(Complex b) {
		double real = this.re() + b.re();
		double imag = this.im() + b.im();
		return new StandardComplex(real, imag);
	}

	// return a new Complex object whose value is (this - b)
	public Complex minus(Complex b) {
		Complex a = this;
		double real = a.re() - b.re();
		double imag = a.im() - b.im();
		return new StandardComplex(real, imag);
	}

	// return a new Complex object whose value is (this * b)
	public Complex times(Complex b) {
		Complex a = this;
		double real = a.re() * b.re() - a.im() * b.im();
		double imag = a.re() * b.im() + a.im() * b.re();
		return new StandardComplex(real, imag);
	}

	// return the real or imaginary part
	public double re() {
		return super.getCoordinate(0);
	}

	public double im() {
		return super.getCoordinate(1);
	}

	public boolean equals(Object x) {
		if (x == null || !(x instanceof Complex))
			return false;
		Complex that = (Complex) x;
		return (this.re() == that.re()) && (this.im() == that.im());
	}

	@Override
	public int compareTo(Complex that) {
		if (this.re() > that.re()) {
			return 1;
		}
		if (this.re() < that.re()) {
			return -1;
		}

		if (this.re() == that.re()) {
			if (this.im() > that.im()) {
				return 1;
			}
			if (this.im() < that.im()) {
				return -1;
			} else {
				return 0;
			}
		}
		return 0;

	}
}