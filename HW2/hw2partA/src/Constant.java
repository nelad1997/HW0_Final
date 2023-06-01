public class Constant extends Polynomial {


    public Constant(double... coefficients) {
        super(coefficients);
    }

    @Override
    public double valueAt(double x) {
        return coefficients[0];
    }

    @Override
    public Constant derivative() {
        return new Constant(0);
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
    return new Polynomial(coefficients[0]);
    }
}