package rus.marioara.myapplication;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Bogdan Roatis on 6/25/2017.
 */

public class EventItem extends RecyclerView.ViewHolder {
    private TextView tvTitle;
    private TextView tvHour;
    private TextView tvRoom;

    public EventItem(View itemView) {
        super(itemView);

        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvHour = (TextView) itemView.findViewById(R.id.tv_hour);
        tvRoom = (TextView) itemView.findViewById(R.id.tv_room);


    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setHour(String hour) {
        tvHour.setText(hour);
    }
    public void setRoom(String room){
        tvRoom.setText(room);
    }
}
