package GoF.Structural.Bridge;

public class WindowsImp implements  ImageImp {
    public void doPaint(Matrix matrix) {
        System.out.print("在 Windows 系统中显示图片:");
    }
}
