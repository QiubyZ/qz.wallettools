from web3 import eth
from os import sys

def main(pharase):
    try:
        eth.Account.enable_unaudited_hdwallet_features()
        mnemon = eth.Account.from_mnemonic(pharase)
        return f"Address: {mnemon.address}\nPrivate Keys: {mnemon.privateKey.hex()}"
    except Exception as e:
        return e