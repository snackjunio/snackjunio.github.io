# mastrobot_example.py
from telegram.ext import Updater, CommandHandler, MessageHandler, Filters
import requests
import json

# function to handle the /start command
def start(update, context):
    # update.message.reply_text('start command received')
    btc(update,context)

# function to handle the /help command
def help(update, context):
    update.message.reply_text('Help help cc!')

# function to handle errors occured in the dispatcher 
def error(update, context):
    update.message.reply_text('an error occured')

# function to handle normal text
def btc(update, context):
    ids = 'bitcoin'
    vs_currencies = 'usd'
    update.message.reply_text("{}:{}".format(ids,api(ids, vs_currencies)))

# function to handle normal text
def text(update, context):
    text_received = update.message.text
    text = text_received.split(' ')
    text = text.replace('/','')
    coinname = text[0]
    ids = getcoinname(coinname)
    vs_currencies = text[1]
    update.message.reply_text("{}:{}".format(ids,api(ids, vs_currencies)))

def getcoinname(coinname):
    
    list_coin = ["hakka","btc","argon","feg","bnb"]
    list_name = ["hakka-finance","bitcoin","argon","feg-token","binancecoin"]

    if coinname in list_coin:
        position = list_coin.index(coinname)
    else:
        position = -1
    if position != -1:
        coin = list_name[position]
    else:
        coin = "invailble"
    return coin 

def api(ids, vs_currencies):
    request = "https://api.coingecko.com/api/v3/simple/price?ids={}&vs_currencies={}".format(ids, vs_currencies)
    info = json.loads(requests.get(request).text)
    coin = info[ids]
    get_price = coin[vs_currencies]
    return get_price


def main():
    TOKEN = "1872874642:AAGpkcLAQiFSshLLYiYnsFtG1cLkOErAw2A"

    # create the updater, that will automatically create also a dispatcher and a queue to 
    # make them dialoge
    updater = Updater(TOKEN, use_context=True)
    dispatcher = updater.dispatcher

    # add handlers for start and help commands
    dispatcher.add_handler(CommandHandler("start", start))
    dispatcher.add_handler(CommandHandler("help", help))

    # add an handler for normal text (not commands)
    dispatcher.add_handler(MessageHandler(Filters.text, text))

    # add an handler for errors
    dispatcher.add_error_handler(error)

    # start your shiny new bot
    updater.start_polling()

    # run the bot until Ctrl-C
    updater.idle()

if __name__ == '__main__':
    main()