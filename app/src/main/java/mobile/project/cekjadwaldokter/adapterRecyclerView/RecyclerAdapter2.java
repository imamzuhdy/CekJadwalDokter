package mobile.project.cekjadwaldokter.adapterRecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mobile.project.cekjadwaldokter.R;
import mobile.project.cekjadwaldokter.paket.firebase.ModelInfoSpesialis;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder> {
    List<ModelInfoSpesialis> list;
    Context context;

    public RecyclerAdapter2(List<ModelInfoSpesialis> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_info_dokter,parent,false);
        ViewHolder myHoder = new ViewHolder(view);

        return myHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ModelInfoSpesialis mylist = list.get(position);
        holder.NamaDokter.setText(mylist.getNamaDokter());
        Picasso.with(context).load(mylist.getImage()).into(holder.imageView);
        holder.Ruangan.setText(mylist.getImage());
        holder.Hari.setText(mylist.getHari());
        holder.Jam.setText(mylist.getJam());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.getPosition(position);
            }
        });

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView NamaDokter;
        TextView Ruangan;
        TextView Hari;
        TextView Jam;
        ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);
            NamaDokter = (TextView) itemView.findViewById(R.id.namaDokter);
            Ruangan = (TextView) itemView.findViewById(R.id.idRuangan);
            Hari = (TextView) itemView.findViewById(R.id.idHari);
            Jam = (TextView) itemView.findViewById(R.id.idJam);
            imageView = (ImageView) itemView.findViewById(R.id.fotoDokter);

        }
    }

    @Override
    public int getItemCount() {
        int arr = 0;

        try{
            if(list.size()==0){
                arr = 0;
            }
            else{

                arr=list.size();
            }
        }catch (Exception e){
        }
        return arr;
    }

    RecyclerAdapter.OnItemClick onItemClick;

    public void setOnItemClick(RecyclerAdapter.OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {
        void getPosition(int pos); //pass any things
    }
}
