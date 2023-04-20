package GoF.Creational.AbstractFactory;

public class SpringTextField implements TextField {
    @Override
    public void display(){
        System.out.println("绿色文本框");
    }
}
