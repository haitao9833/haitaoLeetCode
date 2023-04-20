package GoF.Structural.Composite;

public class VideoFile extends AbstractFile {
    private String name;
    public VideoFile(String name) {
        this.name = name;
    }
    public void add(AbstractFile file) {
        System.out.println("不支持");
    }
    public void remove(AbstractFile file) {
        System.out.println("不支持");
    }
    public AbstractFile getChild(int i) {
        System.out.println("不支持");
        return null;
    }
    public void killVirus() {
        System.out.println("   对视频文件 " + name + " 进行杀毒");
    }
}
