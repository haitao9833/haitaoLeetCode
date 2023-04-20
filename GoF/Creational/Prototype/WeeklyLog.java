package GoF.Creational.Prototype;

import java.io.*;

public class WeeklyLog extends Log implements Cloneable , Serializable {

    private Attachment attachment;

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
    public Attachment getAttachment() {
        return attachment;
    }

    @Override
    public WeeklyLog clone() {
        try {
            return (WeeklyLog) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
