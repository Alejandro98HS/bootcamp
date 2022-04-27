package com.bootcamp.solid;

public class Calculator {
	
    public void calculate(Operar operation) throws Exception {
        if (operation == null) {
            throw new Exception("Can not perform operation");
        }

        operation.operar();
        /*
        if(operation instanceof  Addition){
             Addition ad = (Addition) operation;
             ad.result = ad.a + ad.b;
        } else if (operation instanceof Substraction){
            Substraction sb = (Substraction) operation;
            sb.result = sb.a - sb.b;
        } else if (operation instanceof Multiplication){
            Multiplication ml = (Multiplication) operation;
            ml.result = ml.a * ml.b;
        } else if (operation instanceof Dividir){
            Dividir dv = (Dividir) operation;
            dv.result = dv.a / dv.b;
        }
        */
    }

    public static void main(String[] args) throws Exception {

        Calculator  obj = new Calculator();

        Operar add = new Addition(10,5);
        obj.calculate(add);

        System.out.println("Resultado calculator: " +  add.result);

        Operar sb = new Substraction(10,5);
        obj.calculate(sb);

        System.out.println("Resultado susbration " +  sb.result);

        Operar ml = new Multiplication(10,5);
        obj.calculate(ml);

        System.out.println("Resultado multiplication " +  ml.result);

        Operar dv = new Dividir(10,5);
        obj.calculate(dv);

        System.out.println("Resultado division " +  dv.result);
    }

}