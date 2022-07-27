package qz.simplekml.qzmodel;

public class coin_list {
  String token_nama;
  String token_harga;
  String token_kuantitas;
  String token_total;
  String token_image;

  public coin_list(
      String token_nama,
      String token_harga,
      String token_kuantitas,
      String token_total,
      String token_image) {
    this.token_nama = token_nama;
    this.token_harga = token_harga;
    this.token_kuantitas = token_kuantitas;
    this.token_total = token_total;
    this.token_image = token_image;
  }

  public void setToken_image(String token_image) {
    this.token_image = token_image;
  }

  public String getToken_image() {
    return token_image;
  }

  public void setToken_nama(String token_nama) {
    this.token_nama = token_nama;
  }

  public String getToken_nama() {
    return token_nama;
  }

  public void setToken_harga(String token_harga) {
    this.token_harga = token_harga;
  }

  public String getToken_harga() {
    return token_harga;
  }

  public void setToken_kuantitas(String token_kuantitas) {
    this.token_kuantitas = token_kuantitas;
  }

  public String getToken_kuantitas() {
    return token_kuantitas;
  }

  public void setToken_total(String token_total) {
    this.token_total = token_total;
  }

  public String getToken_total() {
    return token_total;
  }
}
