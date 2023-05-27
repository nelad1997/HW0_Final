public class Quotient extends Function{

    private Function []functions=new Function[2];

    public Quotient(Function fun1,Function fun2) {
        this.functions[0]=fun1;
        this.functions[1]=fun2;
    }

    @Override
    public double valueAt(double a) {
        return (functions[0].valueAt(a))/(functions[1].valueAt(a));
    }

    @Override
    public String toString() {
        return "("+functions[0]+"/"+functions[1]+")";

    }

    @Override
    public Function derivative() {
        Product counterP1=new Product(functions[0].derivative(),functions[1]);//derivative of the counter part1
        Product counterp2=new Product(functions[0],functions[1].derivative());//derivative of the counter part2
        Difference couneter3=new Difference(counterP1,counterp2);
        Power mechaneSquared=new Power(functions[1],2);
        return new Quotient(couneter3,mechaneSquared);
    }
}
