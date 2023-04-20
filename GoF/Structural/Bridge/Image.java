package GoF.Structural.Bridge;

public abstract class Image { // 抽象类，代表图片格式维度
    protected ImageImp imp;   // 抽象关联
    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }
    public abstract void parseFile(String fileName);  // parse == 解析，分析
}
