import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Chess_bot extends TelegramLongPollingBot {
    public List<KeyboardRow> Beginner(){
        List<KeyboardRow> keyboardRowList2 = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("1"));
        keyboardRow2.add(new KeyboardButton("2"));
        keyboardRow3.add(new KeyboardButton("3"));
        keyboardRowList2.add(keyboardRow1);
        keyboardRowList2.add(keyboardRow2);
        keyboardRowList2.add(keyboardRow3);
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
    public void SendMsg(Message message, List<KeyboardRow> keyboardRowList ,String text) {
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
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
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        if (message != null && message.hasText()) {
            switch (message.getText()) {
                //case "Привет" -> SendMsg(message, "Здарова!");
                case "/start" -> SendMsg(message,Start() ,"Привет! Выбери свой уровень владения шахматным искусством:");
                case "Новичок" -> SendMsg(message,Beginner() ,"Начнем тренировку");
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
