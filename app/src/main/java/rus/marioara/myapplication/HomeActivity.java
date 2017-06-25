package rus.marioara.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Bogdan Roatis on 6/25/2017.
 */

public class HomeActivity extends Activity {

    private ImageView ivAmb;
    private Button btnEvents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ivAmb = (ImageView) findViewById(R.id.iv_amb);
        ivAmb.setImageDrawable(getResources().getDrawable(R.drawable.amb));
        btnEvents = (Button) findViewById(R.id.btn_events);
        btnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, EventsActivity.class));
            }
        });
    }
}
