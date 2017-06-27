package rus.marioara.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailsActivity extends Activity {
    private TextView tvTitle;
    private TextView tvHour;
    private TextView tvRoom;
    private TextView tvDescription;
    private ImageView ivEvent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvHour = (TextView) findViewById(R.id.tv_hour);
        tvRoom = (TextView) findViewById(R.id.tv_room);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        ivEvent = (ImageView) findViewById(R.id.iv_event);

        if (getIntent() != null && getIntent().getExtras() != null) {
            tvTitle.setText(getIntent().getStringExtra("Title"));
            tvHour.setText(getIntent().getStringExtra("Hour"));
            tvRoom.setText(getIntent().getStringExtra("Room"));
        }
    }
}
