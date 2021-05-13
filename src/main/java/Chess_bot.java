import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chess_bot extends TelegramLongPollingBot {
    public Map<String, String> Quest(){
        Map<String, String> questionAns = new HashMap<>();
        questionAns.put("1", "D4");
        return questionAns;
    }
    public List<KeyboardRow> Beginner(){
        List<KeyboardRow> keyboardRowList2 = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("За белых!"));
        keyboardRow2.add(new KeyboardButton("За чёрных!"));
        keyboardRowList2.add(keyboardRow1);
        keyboardRowList2.add(keyboardRow2);
        return keyboardRowList2;
    }
    public List<KeyboardRow> Start(){
        List<KeyboardRow> keyboardRowList1 = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Новичок"));
        keyboardRow2.add(new KeyboardButton("Любитель"));
        keyboardRow3.add(new KeyboardButton("Мастер"));
        keyboardRowList1.add(keyboardRow1);
        keyboardRowList1.add(keyboardRow2);
        keyboardRowList1.add(keyboardRow3);
        return keyboardRowList1;
    }
    public List<KeyboardRow> Proceed(){
        List<KeyboardRow> keyboardRowList3 = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Продолжить"));
        keyboardRowList3.add(keyboardRow1);
        return keyboardRowList3;
    }
    public void SendMsg(Message message, List<KeyboardRow> keyboardRowList ,String text) {
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
     // sendMessage.setReplyToMessageId(message.getMessageId()); - Ответ на сообщ
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    public void SendPht(Message message, InputFile file, String text) {
        SendMessage sendMessage = new SendMessage();
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId().toString());
        sendPhoto.setPhoto(file);
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());

        sendMessage.setText(text);
        try {
            execute(sendPhoto);
            execute(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        InputFile a = new InputFile("https://chessok.net/uploads/posts/2020-08/1598705644_prostoj-i-prijatnyj-mat-v-1-hod_-reshi-za-10-sekund.jpg");
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/start" -> SendMsg(message,Start() ,"Привет! Выбери свой уровень владения шахматным искусством:");
                case "Новичок" -> SendMsg(message,Beginner() ,"Начнем тренировку");
                case "За белых!" -> SendPht(message, a, "Найдите мат в 1 ход");
                case "a6-g6" -> SendMsg(message,Proceed() ,"Абсолютно верно!");
            }
        }
    }
    @Override
    public String getBotUsername() {
        return "chess_accelerator_bot";
    }

    @Override
    public String getBotToken() {
        return "1834908590:AAGm6ybJNjUjyqKeu7EJCoJox8B_rjWjgFI";
    }
}