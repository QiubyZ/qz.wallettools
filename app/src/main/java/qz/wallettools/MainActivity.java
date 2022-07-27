package qz.wallettools;

import android.os.*;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.itsaky.androidide.logsender.LogSender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qz.simplekml.qzmodel.coin_list;
import qz.wallettools.databinding.*;
import qz.wallettools.qzmodel.AdapterCoin;
import android.annotation.*;
public class MainActivity extends AppCompatActivity {
  private MainActivityBinding binding;
  public AdapterCoin MyadapterCoin;
  private ArrayList<coin_list> coinlist;
  Python python;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // Remove this line if you don't want AndroidIDE to show this app's logs
    LogSender.startLogging(this);
    super.onCreate(savedInstanceState);
    // Inflate and get instance of binding
    binding = MainActivityBinding.inflate(getLayoutInflater());
    // set content view to binding's root
    setContentView(binding.getRoot());
    binding.listCoin.setLayoutManager(new LinearLayoutManager(this));
    this.coinlist = new ArrayList<coin_list>();
    this.MyadapterCoin = new AdapterCoin(this.coinlist);
    binding.listCoin.setAdapter(this.MyadapterCoin);
    
    String walletaddress = "0xcE8b739b3f1624D359e5F8E9ea72A826f1d48178";
    
    
    //for(int i = 0; i < 5 ;i++){
     //   this.coinlist.add(new coin_list("TOKEN "+i,"Rp.23"+i,"100.0000.000,0"+i,"Rp.1000.000.0000 "+i, "gambar "+i));}
    try{
        main(walletaddress);
        }
        catch(Exception e){
            Toast.makeText(this, e.toString(), 1);
            }
  }
  void main(String wallet) {
    if (!Python.isStarted()) {
      Python.start(new AndroidPlatform(this));
      this.python = Python.getInstance();
    }
    PyObject myfile = python.getModule("main");
    List listcoin = myfile.callAttr("token", wallet).asList();
    
    //binding.view.setText(myfile.callAttr("main", pharase).toString());
  }
  void start() {
    //binding.about.setText("Wallet Tools\nQiuby Zhukhi");
    //binding.submit.setOnClickListener(
        //new View.OnClickListener() {
       //   @Override
      //   public void onClick(View arg0) {
            // TODO: Implement this method
            //String pharase = binding.input.getText().toString();
            //if (pharase.isEmpty()) {
              //binding.view.setText("Masukkan Pharase");
         //   } else {
         //     try {
            //    main(pharase);
         //     } catch (Exception e) {
             //   binding.view.setText(e.toString());       } }} });
             }
}
