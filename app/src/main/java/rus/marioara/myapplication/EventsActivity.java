package rus.marioara.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan Roatis on 6/25/2017.
 */

public class EventsActivity extends Activity {

    private RecyclerView rvEvents;
    private EventsAdapter eventsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        rvEvents = (RecyclerView) findViewById(R.id.rv_events);
        eventsAdapter = new EventsAdapter(new ArrayList<EventInfo>());
        rvEvents.setAdapter(eventsAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvEvents.setLayoutManager(linearLayoutManager);
        FirebaseDB firebaseDB = new FirebaseDB();
        // firebaseDB.write();
        firebaseDB.read(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                List<EventInfo> tempL = new ArrayList<EventInfo>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    tempL.add(snapshot.getValue(EventInfo.class));
                }
                eventsAdapter.setEventsList(tempL);
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }


    private class EventsAdapter extends RecyclerView.Adapter<EventItem> {
        private List<EventInfo> eventsList;

        public EventsAdapter(List<EventInfo> eventsList) {
            this.eventsList = eventsList;
        }

        public void setEventsList(List<EventInfo> eventsList) {
            this.eventsList = eventsList;
            notifyDataSetChanged();
        }

        @Override
        public EventItem onCreateViewHolder(ViewGroup parent, int viewType) {
            return new EventItem(LayoutInflater.from(EventsActivity.this).inflate(R.layout.item_event, parent, false));
        }

        @Override
        public void onBindViewHolder(EventItem holder, int position) {
            EventInfo eventInfo = eventsList.get(position);
            holder.setTitle(eventInfo.getTitle());
            holder.setHour(eventInfo.getHour());
            holder.setRoom(eventInfo.getRoom());
        }

        @Override
        public int getItemCount() {
            return eventsList.size();
        }
    }
}
