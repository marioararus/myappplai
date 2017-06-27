package rus.marioara.myapplication;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class EventItem extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView tvTitle;
    private TextView tvHour;
    private TextView tvRoom;
    private OnElementClick onElementClick;

    public EventItem(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvHour = (TextView) itemView.findViewById(R.id.tv_hour);
        tvRoom = (TextView) itemView.findViewById(R.id.tv_room);

        itemView.setOnClickListener(this);
    }

    public void setOnClickEvent(OnElementClick onElementClick) {
        this.onElementClick = onElementClick;
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setHour(String hour) {
        tvHour.setText(hour);
    }

    public void setRoom(String room) {
        tvRoom.setText(room);
    }

    @Override
    public void onClick(View v) {
        if (onElementClick != null) {
            onElementClick.onEventClick(v,getAdapterPosition());
        }
    }

    public interface OnElementClick {
        void onEventClick(View view, int position);
    }
}
