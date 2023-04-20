package GoF.Structural.Composite;

/**
 * 组合模式：
 *        角色：
 *            1、Component  抽象构件   使得客户端可以统一对待叶子构件和容器构件
 *            2、Leaf       叶子构件
 *            3、Composite  容器构件
 *        透明组合模式：
 *                  抽象构件 Component 提供了所有的方法
 *                  确保 Leaf 和 Composite 都继承有相同的方法
 *                  缺点是有些方法也许是 Leaf 所不必的，不够安全
 *        安全组合模式：
 *                  抽象构件 Component 只提供一些必要的公共的方法
 *                  具体构件 Leaf 和 Composite 会自主实现各自的一些特定方法
 *                  缺点是客户端无法完全面向抽象编程，需要区别对待 Leaf 和 Composite 构件
 */

public class Client {
    public static void main(String[] args) {
        AbstractFile folder1 = new Folder("图像文件夹");
        AbstractFile image01 = new ImageFile("图片1");
        AbstractFile image02 = new ImageFile("图片2");
        folder1.add(image01);
        folder1.add(image02);

        AbstractFile folder2 = new Folder("文本文件夹");
        AbstractFile text01 = new TextFile("文本1");
        AbstractFile text02 = new TextFile("文本2");
        folder2.add(text01);
        folder2.add(text02);

        AbstractFile folder3 = new Folder("视频文件夹");
        AbstractFile video01 = new VideoFile("视频1");
        AbstractFile video02 = new VideoFile("视频2");
        folder3.add(video01);
        folder3.add(video02);

        folder1.add(folder2);
        folder1.add(folder3);
        folder1.killVirus();
    }
}
