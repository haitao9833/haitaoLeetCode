package GoF.Structural.Composite;

import java.util.ArrayList;

public class Folder extends AbstractFile {
    private String name;
    private ArrayList<AbstractFile> fileList;
    public Folder(String name) {
        this.name = name;
        fileList = new ArrayList<>();
    }
    public void add(AbstractFile file) {
        fileList.add(file);
    }
    public void remove(AbstractFile file) {
        fileList.remove(file);
    }
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }
    public void killVirus() {
        System.out.println("对文件夹 " + name + " 进行杀毒：");
        for (AbstractFile file : fileList) {
            file.killVirus();
        }
    }
}
