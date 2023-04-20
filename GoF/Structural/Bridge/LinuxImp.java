package GoF.Structural.Bridge;

public class LinuxImp implements ImageImp {
    public void doPaint(Matrix matrix) {
        System.out.print("在 Linux 系统中显示图片:");
    }
}
