package developervisits.com.obserablerecyclerviewex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by developervisits on 26/5/19.
 *
 * @author Praveen.verma | Noida
 */
public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.MyViewHolder> {

    private final Context mContext;
    private final List<String> nameList = new ArrayList<>();

    public RecycleviewAdapter(Context context){mContext=context;}

    public void setData(List<String> names){
        nameList.clear();
        nameList.addAll(names);
        notifyDataSetChanged();
    }
    @Override
    public RecycleviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.display_list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecycleviewAdapter.MyViewHolder holder, final int position) {
        holder.myTextView.setText(nameList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext," "+nameList.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public  TextView myTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            myTextView=(TextView)itemView.findViewById(R.id.tvName);
        }
    }
}
