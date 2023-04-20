package GoF.Creational.Builder;

public class Director {
    public Actor construct(ActorBuilder builder) { // 方法参数注入
        Actor actor;

        builder.buildType();
        builder.buildSex();
        builder.buildFace();
        builder.buildCostume();
        if (!builder.isBareheaded()) {  // 钩子方法控制是否调用 buildPartX() 方法
            builder.buildHairstyle();
        }

        actor = builder.createActor();

        return actor;
    }
}
