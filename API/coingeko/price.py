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
        elif coinname == "sushi":
        	ids = "sushi"
        elif coinname == "dia":
        	ids = "dia-data"
        elif coinname == "adel":
        	ids = "akropolis-delphi"
        elif coinname == "opt":
        	ids = "open-predict-token"
        elif coinname == "albt":
        	ids = "allianceblock"
        elif coinname == "yfi":
        	ids = "yearn-finance"
        elif coinname == "yfii":
        	ids = "yfii-finance"
        elif coinname == "ags":
        	ids = "aegis"
        elif coinname == "bch":
            ids = "bitcoin-cash"
        elif coinname == "atom":
            ids = "cosmos"
        elif coinname == "hget":
            ids = "hedget"
        elif coinname =="uni":
            ids = "uniswap"
        elif coinname =="argon":
            ids = "argon"
        elif coinname =="feg":
            ids = "feg-token"
        elif coinname == "bnb":
            ids = "binancecoin"
        elif coinname == "xau":
            ids = "gold"
        elif coinname == "gold":
            ids = "gold"
        elif coinname == "vang":
            ids = "gold"
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

        if ids in "gold":
            info = apiXAU(ids)
            print(info)
        else:
            info = apiCoin(ids, vs_currencies)
            print(info)


def apiCoin(ids, vs_currencies):
    request = "https://api.coingecko.com/api/v3/simple/price?ids={}&vs_currencies={}".format(ids, vs_currencies)
    info = json.loads(requests.get(request).text)
    return info

def apiXAU(ids):
    request = "https://tygia.com/json.php?ran=0&rate=0&{}=1&bank=VIETCOM&date=now".format(ids)
    info = json.loads(requests.get(request).text)
    return info


if __name__ == "__main__":
    main()
