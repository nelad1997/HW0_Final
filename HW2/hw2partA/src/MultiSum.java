public class MultiSum extends Sum{
    public MultiSum(Function... functions) {//TODO: check how to make compilation error if the num of args<2
           super(functions);
    }
    @Override
    public Function derivative() {
        int len =functions.length;
        Function []sumFunctions=new Function[len];
        for(int i=0;i<len;i++)
            sumFunctions[i]=functions[i].derivative();
        return new MultiSum(sumFunctions);
    }

}
