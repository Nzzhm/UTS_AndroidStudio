package com.example.uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DestinasiAdapter extends RecyclerView.Adapter<DestinasiAdapter.DestinasiViewHolder> {

    private List<Destinasi> destinasiList;
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public DestinasiAdapter(Context context, List<Destinasi> destinasiList) {
        this.context = context;
        this.destinasiList = destinasiList;
    }

    @NonNull
    @Override
    public DestinasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyler_item, parent, false);
        return new DestinasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinasiViewHolder holder, int position) {
        Destinasi destinasi = destinasiList.get(position);

        // Mengatur data ke dalam komponen tampilan
        holder.imgDestinasi.setImageResource(destinasi.getGambarId());
        holder.tvJudul.setText(destinasi.getJudul());
        holder.tvDeskripsi.setText(destinasi.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return destinasiList.size();
    }

    // ViewHolder untuk menyimpan referensi komponen tampilan
    public class DestinasiViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDestinasi;
        TextView tvJudul, tvDeskripsi;

        public DestinasiViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inisialisasi komponen tampilan
            imgDestinasi = itemView.findViewById(R.id.img_destinasi);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);

            // Menangani klik pada item
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}