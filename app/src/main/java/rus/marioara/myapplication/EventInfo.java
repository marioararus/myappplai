package rus.marioara.myapplication;

/**
 * Created by Bogdan Roatis on 6/25/2017.
 */

public class EventInfo {
    private String title;
    private String hour;
    private String room;

    public EventInfo(String title, String hour, String room) {
        this.title = title;
        this.hour = hour;
        this.room = room;
    }

    public EventInfo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
