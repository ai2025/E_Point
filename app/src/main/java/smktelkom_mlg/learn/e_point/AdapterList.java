package smktelkom_mlg.learn.e_point;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Salsa on 13/01/2018.
 */

public class AdapterList extends RecyclerView.Adapter<AdapterList.HolderItem> {

    List<ModelList> mListItem;
    Context context;

    public AdapterList(List<ModelList> mListItem, Context context) {
        this.mListItem = mListItem;
        this.context = context;
    }

    @Override
    public HolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_show, parent, false);
        HolderItem holder = new HolderItem(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderItem holder, int position) {
        ModelList mlist = mListItem.get(position);

        holder.tv_nama.setText(mlist.getNama());
        holder.tv_jenis.setText(mlist.getNama_pelanggaran());
        holder.tv_kategori.setText(mlist.getNama_kategori());
        holder.tv_tanggal.setText(mlist.getTanggal());
        holder.tv_poin.setText(mlist.getPoin());

    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class HolderItem extends RecyclerView.ViewHolder {
        TextView tv_nama, tv_jenis, tv_kategori, tv_tanggal, tv_poin;

        public HolderItem(View v) {
            super(v);

            tv_nama = (TextView) v.findViewById(R.id.tv_nama);
            tv_jenis = (TextView) v.findViewById(R.id.tv_jenis);
            tv_kategori = (TextView) v.findViewById(R.id.tv_kategori);
            tv_tanggal = (TextView) v.findViewById(R.id.tv_tanggal);
            tv_poin = (TextView) v.findViewById(R.id.tv_poin);

        }
    }
}
