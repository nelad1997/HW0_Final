public class Constant extends Function {

    private final double constant;
    public Constant(double constant) {
        this.constant=constant;
    }
    @Override
    public double valueAt(double x){
        return constant;
    }

    @Override
    public String toString() {
        return "("+constant+")";
    }

    @Override
    public Constant derivative(){
       return new Constant(0);
    }
}
