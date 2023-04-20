package GoF.Behavioral.Mediator.CRMSys;

public class SubConcreteMediator extends ConcreteMediator {
    public Label label;
    public void componentChanged(Component component) {
        super.componentChanged(component);
        if (component == button) {
            label.update();
        }
    }
}
