public class MultiProduct extends Product{
    public MultiProduct(Function... functions) {//TODO: repair the constructor below 2 parameters
        super(functions);
    }
    @Override
    public Function derivative() {//TODO: after repairing the constructor need to check if it works as it should
        int len =functions.length;
        Function []multfun=new Function[len-1];//Parameter to the first inner Product
        Product innerP;//inner multiProduct i!=j
        MultiProduct outerP;//MultiProduct between innerP and  i derivative
        MultiProduct [] multiProducts=new  MultiProduct [len];//temporary array of all products
        Function derivativeI;
        if(functions.length==2)
           super.derivative();//the regular derivative method of Product Class, because there are only 2 Functions
        for(int i=0;i<len;i++){
            derivativeI=functions[i].derivative();
            for(int j=0; j<len;j++){
                if(j!=i)
                    multfun[j]=functions[j];//all functions so that i!=j
            }
            innerP=new MultiProduct(multfun);
            outerP =new MultiProduct(derivativeI,innerP);
            multiProducts[i]=new MultiProduct (outerP);
        }
        return new MultiSum(multiProducts);
    }
}
