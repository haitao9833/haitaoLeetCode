package GoF.Structural.Bridge;

public class UnixImp implements ImageImp {
    public void doPaint(Matrix matrix) {
        System.out.print("在 Unix 系统中显示图片:");
    }
}
