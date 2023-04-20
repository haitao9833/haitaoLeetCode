package GoF.Behavioral.Mediator.CRMSys;

public class ConcreteMediator extends Mediator {
    public Button button;
    public List list;
    public TextBox textBox;
    public ComboBox comboBox;         // 关联各个同事对象的成员变量
    @Override
    public void componentChanged(Component component) { // 封装复杂的成员变量的交互行为
        if (component == button) {
            System.out.println("--单击增加按钮--");
            list.update();
            comboBox.update();
            textBox.update();
        } else if (component == list) {
            System.out.println("--从列表框中选择客户--");
            comboBox.select();
            textBox.setText();
        } else if (component == comboBox) {
            System.out.println("--从组合框中选择客户--");
            list.select();
            textBox.setText();
        }
    }
}
