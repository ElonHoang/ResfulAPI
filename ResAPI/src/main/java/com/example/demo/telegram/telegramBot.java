package com.example.demo.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.example.demo.controller.Rescontroller;

public class telegramBot extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		// System.out.println(update.getMessage().getText());
		String comand = update.getMessage().getText();
		// check update message
		SendMessage mess = new SendMessage();
		if (update.hasMessage() && update.getMessage().hasText()) {
			if (comand.contains("display-list")) {
				//mess = new SendMessage();
				mess.setChatId(update.getMessage().getChatId().toString());
				mess.setText(Rescontroller.getAll().toString());
			} else if (comand.contentEquals("xin loi")) {
				//mess = new SendMessage();
				mess.setChatId(update.getMessage().getChatId().toString());
				mess.setText("Loi xin loi cua may qua muon mang !");
			} else if (comand.contains("xin chao")) {
				//mess = new SendMessage();
				mess.setChatId(update.getMessage().getChatId().toString());
				mess.setText("Chao may !");
			} else {
				//mess = new SendMessage();
				mess.setChatId(update.getMessage().getChatId().toString());
				mess.setText("Bay gio may muon gi nao !");
			}
			try {
				execute(mess);
				System.out.println("OK");
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
		

	}

	

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "HoangNVBot";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "5313251231:AAFAf3pHcF3kJgsogGn1Ns86vhReA9ZtV5Q";
	}

}
