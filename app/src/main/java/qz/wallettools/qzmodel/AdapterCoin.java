package qz.wallettools.qzmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import qz.simplekml.qzmodel.coin_list;
import qz.wallettools.R;
import qz.wallettools.qzmodel.AdapterCoin.MyViewHolder;

public class AdapterCoin extends RecyclerView.Adapter<AdapterCoin.MyViewHolder> {
  private ArrayList<coin_list> listcoin;

  public AdapterCoin(ArrayList<coin_list> data) {
    this.listcoin = data;
  }

  @Override
  public int getItemCount() {
    return this.listcoin.size();
  }

  @Override
  public int getItemViewType(int arg0) {
    return super.getItemViewType(arg0);
  }

  void hapusPosisi(int posisi) {
    listcoin.remove(posisi);
    notifyItemRemoved(posisi);
    notifyDataSetChanged();
  }

  @Override
  public long getItemId(int arg0) {
    return super.getItemId(arg0);
  }

  @Override
  public void onBindViewHolder(AdapterCoin.MyViewHolder arg0, int arg1) {
    coin_list coin = listcoin.get(arg1);
    arg0.token_harga.setText(coin.getToken_harga());
    arg0.token_kuantitas.setText(coin.getToken_kuantitas());
    arg0.token_nama.setText(coin.getToken_nama());
    arg0.token_total.setText(coin.getToken_total());
    // arg0.token_img.setImageIcon()
  }

  @Override
  public qz.wallettools.qzmodel.AdapterCoin.MyViewHolder onCreateViewHolder(
      ViewGroup arg0, int arg1) {
    View view = LayoutInflater.from(arg0.getContext()).inflate(R.layout.costumlist, arg0, false);
    return new MyViewHolder(view);
  }

  public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView token_nama;
    private TextView token_harga;
    private TextView token_kuantitas;
    private TextView token_total;
    private ImageView token_img, hapus;
    private CardView rootid;

    public MyViewHolder(View view) {
      super(view);
      rootid = view.findViewById(R.id.rootlayout);
      token_harga = view.findViewById(R.id.token_harga);
      token_kuantitas = view.findViewById(R.id.token_kuantitas);
      token_nama = view.findViewById(R.id.token_nama);
      token_total = view.findViewById(R.id.token_total);
      hapus = view.findViewById(R.id.hapus);
      token_img = view.findViewById(R.id.coinimage);
      view.setClickable(true);

      token_img.setOnClickListener(this);
      rootid.setOnClickListener(this);
      view.setOnClickListener(this);
      hapus.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
      switch (arg0.getId()) {
        case R.id.hapus:
          hapusPosisi(getPosition());
        //default:
          //Toast.makeText(arg0.getContext(), "Default", 000001).show();
      }
    }
  }
}
