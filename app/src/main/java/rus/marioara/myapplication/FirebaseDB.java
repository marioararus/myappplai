package rus.marioara.myapplication;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan Roatis on 6/25/2017.
 */

public class FirebaseDB {
    FirebaseDatabase database;
    DatabaseReference myRef;

    public FirebaseDB() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
    }

    public void write() {
        myRef.setValue(createEvents());
    }

    private List<EventInfo> createEvents() {
        List<EventInfo> tempList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            tempList.add(new EventInfo("event " + i, "10 -14", "sala" + i));
        }
        return tempList;
    }

    public void read(ValueEventListener valueEventListener) {
        // Read from the database
        myRef.addValueEventListener(valueEventListener);
    }
}
