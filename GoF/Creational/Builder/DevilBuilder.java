package GoF.Creational.Builder;

public class DevilBuilder extends ActorBuilder {
    public void buildType(){
        actor.setType("恶魔");
    }
    public void buildSex(){
        actor.setSex("妖");
    }
    public void buildFace(){
        actor.setFace("丑陋");
    }
    public void buildCostume(){
        actor.setCostume("黑衣");
    }
    public void buildHairstyle(){
        actor.setHairstyle("光头");
    }

    /**
     * 重写覆盖父类提供的默认实现
     */
    @Override
    public boolean isBareheaded() {
        return true;
    }
}
