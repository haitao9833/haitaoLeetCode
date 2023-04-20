package GoF.Behavioral.Mediator.CRMSys;

public abstract class Component {
    protected Mediator mediator;  // 关联一个抽象中介者
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    public void changed() {
        mediator.componentChanged(this);
    }
    public abstract void update();
}
