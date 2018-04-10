package com.company;

import org.telegram.telegrambots.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Test_MD_Bot extends TelegramLongPollingBot {

    private Long myID = Long.parseLong("418940670");
    private SendMessage message;
    InlineQuery inlineQuery = new InlineQuery();
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (update.getMessage().getChatId().equals(myID)){
//                callBack(myID);

            }else {
                message = new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText("Принято");
                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText("ответить")
                                .setCallbackData("sdada")
                                .setSwitchInlineQuery("[f[f[f[")
                                .setSwitchInlineQueryCurrentChat("sdadasdasd");
            AnswerCallbackQuery callbackQuery = new AnswerCallbackQuery();
            if (update.hasCallbackQuery()) {
                callbackQuery.setCallbackQueryId(update.getCallbackQuery().getId());
                callbackQuery.setText("dsadasdsa");
            }

            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            List<InlineKeyboardButton> buttons = new ArrayList<InlineKeyboardButton>();
            buttons.add(inlineKeyboardButton);
            List<List<InlineKeyboardButton>> inlinek = new ArrayList<List<InlineKeyboardButton>>();
            inlinek.add(buttons);
            inlineKeyboardMarkup.setKeyboard(inlinek);
                message = new SendMessage() // Create a SendMessage object with mandatory fields
                        .setChatId(myID)
                        .setText("Messege: " + update.getMessage().getText() +
                                "\n id: " + update.getMessage().getChatId() +
                                "\n Name: " + update.getMessage().getFrom().getFirstName())
                        .setReplyMarkup(inlineKeyboardMarkup);
                if (update.hasInlineQuery()) message.setText("Messege: " + update.getMessage().getText() +
                    "\n id: " + update.getMessage().getChatId() +
                    "\n Name: " + update.getMessage().getFrom().getFirstName() +
                    "\n Query: " + update.getInlineQuery().getQuery());
                try {
                    execute(message); // Call method to send the message
                    if (callbackQuery != null) execute(callbackQuery);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }



    @Override
    public String getBotUsername() {
        return "Test_MD_Bot";
    }

    @Override
    public String getBotToken() {
        return "428699141:AAEbZcUCSY_BFN70E5U89WXEr1TrTGnfEsM";
    }

    private void callBack(Long id){
//        ReplyKeyboard keyboard = new ReplyKeyboardMarkup();
//        List<KeyboardRow> keyboardRowList = new ArrayList<KeyboardRow>();
//        KeyboardRow keyboardRow = new KeyboardRow();
//        KeyboardButton keyboardButton = new KeyboardButton();
//        keyboardButton.setText("хуйхуй");
//        keyboardRow.add("[e[ewqeqw");
//        keyboardRowList.add(keyboardRow);
//        ((ReplyKeyboardMarkup) keyboard).setKeyboard(keyboardRowList);
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("ответить");
        inlineKeyboardButton.setCallbackData("[th");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> buttons = new ArrayList<InlineKeyboardButton>();
        buttons.add(inlineKeyboardButton);
        List<List<InlineKeyboardButton>> inlinek = new ArrayList<List<InlineKeyboardButton>>();
        inlinek.add(buttons);
        inlineKeyboardMarkup.setKeyboard(inlinek);
        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                .setChatId(myID)
                .setText("Привет админ")
                .setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
