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
    public int CounterAns = 0;
    public int Completed = 0;

    public Map<Integer, InputFile> EtudeW(){
        Map<Integer, InputFile> questionAns = new HashMap<>();
        InputFile b1 = new InputFile("https://chessok.net/uploads/posts/2020-08/1598705644_prostoj-i-prijatnyj-mat-v-1-hod_-reshi-za-10-sekund.jpg");
        InputFile b2 = new InputFile("https://chessmatenok.ru/wp-content/uploads/2017/04/mat-peskoy.jpg");
        InputFile b3 = new InputFile("https://chessmatenok.ru/wp-content/uploads/2017/04/2.jpg");
        InputFile b4 = new InputFile("https://chessmatenok.ru/wp-content/uploads/2017/04/17.jpg");
        InputFile b5 = new InputFile("https://chessmatenok.ru/wp-content/uploads/2017/04/11.jpg");
        questionAns.put(0 , b1);
        questionAns.put(1 , b2);
        questionAns.put(2 , b3);
        questionAns.put(3 , b4);
        questionAns.put(4 , b5);
        return questionAns;
    }
    public Map<Integer, InputFile> EtudeB(){
        Map<Integer, InputFile> questionAns = new HashMap<>();
        InputFile b1 = new InputFile("https://chessmatenok.ru/wp-content/uploads/2017/04/10.jpg");
        InputFile b2 = new InputFile("https://chessmatenok.ru/wp-content/uploads/2017/04/mat-ladiey-6.jpg");
        InputFile b3 = new InputFile("https://chessok.net/uploads/posts/2020-06/1591255558_chernye-stavjat-mat-v-1-hod.png");
        InputFile b4 = new InputFile("https://chessmatenok.ru/wp-content/uploads/2017/04/fg2.jpg");
        InputFile b5 = new InputFile("https://chessmatenok.ru/wp-content/uploads/2017/04/16.jpg");
        questionAns.put(0 , b1);
        questionAns.put(1 , b2);
        questionAns.put(2 , b3);
        questionAns.put(3 , b4);
        questionAns.put(4 , b5);
        return questionAns;
    }
    public Map<Integer, String> StepName(){
        Map<Integer, String> questionAns = new HashMap<>();
        questionAns.put(1 , "За чёрных!");
        questionAns.put(2 ,"Любитель");
        questionAns.put(3 , "За чёрных!");
        questionAns.put(4 , "Мастер");
        questionAns.put(5 , "За чёрных!");
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
    public List<KeyboardRow> BlackKey(){
        List<KeyboardRow> keyboardRowList2 = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("За чёрных!"));
        keyboardRowList2.add(keyboardRow1);
        return keyboardRowList2;
    }
    public List<KeyboardRow> Lover(){
        List<KeyboardRow> keyboardRowList2 = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Любитель"));
        keyboardRowList2.add(keyboardRow1);
        return keyboardRowList2;
    }
    public List<KeyboardRow> Master(){
        List<KeyboardRow> keyboardRowList2 = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Мастер"));
        keyboardRowList2.add(keyboardRow1);
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
    public List<KeyboardRow> ProceedB(){
        List<KeyboardRow> keyboardRowList3 = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("К следующему шагу!"));
        keyboardRowList3.add(keyboardRow1);
        return keyboardRowList3;
    }
    public Map<Integer, List<KeyboardRow>> StepKey(){
        Map<Integer, List<KeyboardRow>> questionAns = new HashMap<>();
        questionAns.put(1 , BlackKey());
        questionAns.put(2 ,Lover());
        questionAns.put(3 , BlackKey());
        questionAns.put(4 , Master());
        questionAns.put(5 , BlackKey());
        return questionAns;
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
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    public void SendPraise(Message message, List<KeyboardRow> keyboardRowList ,String text) {
        CounterAns ++;
        if (CounterAns > 4) {
            CounterAns = 0;
            Completed++;
            SendMessage sendMessage = new SendMessage();
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setOneTimeKeyboard(true);
            replyKeyboardMarkup.setKeyboard(StepKey().get(Completed));
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(message.getChatId().toString());
            sendMessage.setText("Потрясающе! Перейдите к следующему шагу написав - " + StepName().get(Completed));
            try {
                execute(sendMessage);
            } catch (TelegramApiException e){
                e.printStackTrace();
            }
        } else {
            SendMessage sendMessage = new SendMessage();
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setOneTimeKeyboard(true);
            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(message.getChatId().toString());
            sendMessage.setText(text);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e){
                e.printStackTrace();
            }
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

        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/start" -> SendMsg(message,Start() ,"Привет! Выбери свой уровень владения шахматным искусством:");
                case "Новичок", "Любитель", "Мастер" -> SendMsg(message,Beginner() ,"Начнем тренировку");
                case "За белых!", "Продолжить" -> SendPht(message, EtudeW().get(CounterAns), "Найдите мат в 1 ход\n(Пример ввода e2-e4)");
                case "К следующему шагу!", "За чёрных!" -> SendPht(message, EtudeB().get(CounterAns), "Найдите мат в 1 ход\n(Пример ввода e2-e4)");
                case "a6-g6", "g6-g7", "g6-h7", "g7-g6", "d5-b6"-> SendPraise(message,Proceed() ,"Абсолютно верно!");
                case "d8-h4", "d8-a5", "e5-e1", "a1-c3", "d5-g1", "d5-g2","f5-d6"-> SendPraise(message,ProceedB() ,"Абсолютно верно!");
            }
        }
    }
    @Override
    public String getBotUsername() {
        return "chess_accelerator_bot";
    }

    @Override
    public String getBotToken() {
        return "1834908590:AAEVhFOTX9yByEVFjIx0a4UeEOfUmoUfGf8";
    }
}