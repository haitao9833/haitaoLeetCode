package GoF.Creational.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Log {
    private String name;
    private String date;
    private String content;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    //  深克隆泛型方法在父类里，子类继承调用之
    public <T extends Log> T deepClone() {
        T res = null;
        byte[] obj = null;

        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
             ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
        ){
            objOut.writeObject(this);      // 写入对象
            obj = byteOut.toByteArray();   // 保存对象
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        try (ByteArrayInputStream byteIn = new ByteArrayInputStream(obj);
             ObjectInputStream objIn = new ObjectInputStream(byteIn)
        ){
            res = (T) objIn.readObject();  // 读取对象
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
