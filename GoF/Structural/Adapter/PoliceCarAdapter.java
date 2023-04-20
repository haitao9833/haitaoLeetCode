package GoF.Structural.Adapter;

public class PoliceCarAdapter extends CarTarget {
    private PoliceSound sound;   // 适配者
    private PoliceLamp lamp;     // 适配者

    public PoliceCarAdapter() {
        sound = new PoliceSound();
        lamp = new PoliceLamp();
    }

    public void phonate() {
        sound.alarmSound();
    }
    public void twinkle() {
        lamp.alarmLamp();
    }
}
