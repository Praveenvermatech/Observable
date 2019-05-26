package developervisits.com.obserablerecyclerviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;

public class MainActivity extends AppCompatActivity {

    public final String TAG = "MAIN_ACTIVITY";
    private RecyclerView recyclerListView;
    private RecycleviewAdapter recycleviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating layout
        recyclerListView = (RecyclerView) findViewById(R.id.recyclerview_list);
        recyclerListView.setLayoutManager(new LinearLayoutManager(this));
        recycleviewAdapter = new RecycleviewAdapter(this);
        recyclerListView.setAdapter(recycleviewAdapter);
        // creating observales
        creatingObserable();
    }

    // method that added list of names

    public List<String> getNameList() {
        List<String> list = new ArrayList<>();
        list.add("Praveen");
        list.add("Rajeev");
        list.add("Vibhanshu");
        list.add("Vinay");
        list.add("Arvind");
        list.add("Ajay");
        return list;
    }

    // creating Obserables
    private void creatingObserable() {
        final Observable<List<String>> listObserable = Observable.just(getNameList());
        listObserable.subscribe(new Observer<List<String>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError()", e);
            }

            @Override
            public void onNext(List<String> data) {
                recycleviewAdapter.setData(data);
            }
        });

    }
}
