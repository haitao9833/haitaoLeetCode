package GoF.Creational.Builder;

public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairstyle();

    /**
     * 钩子方法 ———— 提供默认实现，也可供不同的子类构建者重写覆盖
     */
    public boolean isBareheaded() {
        return false;
    }

    public Actor createActor() {
        return actor;
    }
}
