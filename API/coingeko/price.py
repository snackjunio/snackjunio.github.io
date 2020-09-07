import requests
import json


def main():
    i = 0
    j = 1
    while i < j:
        coinname = input('Coin name:')
        if coinname == "hakka":
            ids = "hakka-finance"
        elif coinname == "fsw":
            ids = "fsw-token"
        elif coinname == "swfl":
            ids = "swapfolio"
        elif coinname == "yfv":
            ids = "yfv-finance"
        elif coinname == "kimchi":
            ids = "kimchi-finance"
        elif coinname == "dmg":
            ids = "dmm-governance"
        elif coinname == "btc":
            ids = "bitcoin"
        elif coinname == "btcv":
            ids = "bitcoin-vault"
        elif coinname == "eth":
            ids = "ethereum"    
        else:
            return "Coin name not avaible"
        price = input("Price: USD BTC ETH ")
        if price == "usd":
            vs_currencies = "usd"
        elif price == "btc":
            vs_currencies = "btc"
        elif price == "eth":
            vs_currencies = "eth"
        else:
            return "price not avaible"
        info = api(ids, vs_currencies)
        print(info)


def api(ids, vs_currencies):
    request = "https://api.coingecko.com/api/v3/simple/price?ids={}&vs_currencies={}".format(ids, vs_currencies)
    # print(request)
    info = json.loads(requests.get(request).text)
    return info


if __name__ == "__main__":
    main()