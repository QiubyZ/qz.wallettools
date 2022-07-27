from QiubyZEtherChain.EtherBlock import BinanceSmartChain
from os import path

show_all_Token = False
wallet = "0xcE8b739b3f1624D359e5F8E9ea72A826f1d48178"
def real_path(file_name=r"/address_wallet.txt"):
  with open(path.dirname(path.abspath(__file__)) + file_name) as openfile:
    return openfile.readlines()

def search_token(walet, cari_koin):
      bsc = BinanceSmartChain(walet.strip())
      for myjson in bsc.getToken():
          symbl = myjson.get('symbol')
          token_value = myjson.get("jumlah_token")
          price = myjson.get("usd")
          if cari_koin == symbl:
              print(f" \033[1;32mINFO\033[0m: {walet.strip()} | Received: \033[1;32m{token_value} {symbl}\033[0m | Price: {price}")

def unpack_token(wallet):
      print(f"[*]{wallet.strip()}[*]")
      bsc = BinanceSmartChain(wallet.strip())
      n = 0
      for myjson in bsc.getToken():
          n += 1
          symbl = myjson.get('symbol')
          token_value = myjson.get("jumlah_token")
          print(f"{n}. {token_value} {symbl}")

def main():
    find_symbol = input(" Enter your syimbol: ")
    if len(find_symbol) < 1:
      for wallet in real_path():
        unpack_token(wallet)
    else:
      for wallet in real_path():
        search_token(wallet, find_symbol)

def token(wallet):
    bsc = BinanceSmartChain(wallet).getToken()
    return bsc
    
#if __name__ == '__main__':
#    print(token(wallet))