package GoF.Behavioral.Mediator.CRMSys;

/**
 * 中介者模式：
 *          将多个对象之间的交互和关系，抽取封装为一个对象
 */

public class Client {
    public static void main(String[] args) {
        SubConcreteMediator mediator = new SubConcreteMediator();

        Button button = new Button();
        List list = new List();
        ComboBox comboBox = new ComboBox();
        TextBox textBox = new TextBox();
        Label label = new Label();

        button.setMediator(mediator);
        list.setMediator(mediator);
        comboBox.setMediator(mediator);
        textBox.setMediator(mediator);
        label.setMediator(mediator);

        mediator.button = button;
        mediator.list = list;
        mediator.comboBox = comboBox;
        mediator.textBox = textBox;
        mediator.label = label;

        button.changed();
        System.out.println();
        list.changed();
        System.out.println();
        comboBox.changed();
    }
}
