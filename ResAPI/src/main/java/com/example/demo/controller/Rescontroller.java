package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.example.demo.dao.Dao;
import com.example.demo.dao.DaoImp;
import com.example.demo.model.Manager;
import com.example.demo.response.addResponse;
import com.example.demo.response.deleteResponse;
import com.example.demo.response.updateResponse;
import com.example.demo.sendMess.sendMessage;
import com.example.demo.telegram.telegramBot;



@RestController
public class Rescontroller {
	Logger log = LoggerFactory.getLogger(Rescontroller.class);
	static List<Manager> list = new ArrayList<>();
	
	@Value("${notification.channel}")
	public String nof;
	
	@Autowired
	sendMessage s;
	
	@Autowired
	Dao d = new DaoImp() ;
	
	@GetMapping("/get")
	public ResponseEntity<List<Manager>> getAllManager() {
		
		//System.out.println(d.demoData());
		//d.demoData();
		if (list.size() == 0) {
			log.error("GetAllManager is null !");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
			log.info("GetAllManager OK");
		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	
//	 @RequestMapping("/loginPage")
//	  public String welcome() {
//	    return "ABC";
//	  }
	@GetMapping("/gets")
	public static List<Manager> getAll(){
		//d.demoData();
		if(list.size() == 0) return null;
		//if(s == null) return null;
		return list;
		
	}
	@GetMapping("/send")
	public ResponseEntity<String> sendMai() throws UnsupportedEncodingException, MessagingException{
			getAll();
			s.sendMail("hoangnv06042002@gmail.com");
			log.info("Send Message Success !");
			return new ResponseEntity<>("Send Ok", HttpStatus.OK);
	}
	@GetMapping("/telegram")
	public ResponseEntity<String> telegramApi(){
			getAll();
		try {
			TelegramBotsApi botApi = new TelegramBotsApi(DefaultBotSession.class);
			botApi.registerBot(new telegramBot());
//			SendMessage s = new SendMessage();
//			s.setText(getAll().toString());
			System.out.println("OK");
			return new ResponseEntity<>("Bot Telegram Ok",HttpStatus.OK);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Bot telegram failed", HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/option")
	public String Option() throws UnsupportedEncodingException, MessagingException{
		if(nof == null) return null;
		switch(nof.trim().toString()) {
		case "GMAIL":
			sendMai();
			System.out.println("option send ok");
			break;
		case "TELEGRAM":
			telegramApi();
			System.out.println("option tel ok");
			break;
		default:
			sendMai();
			System.out.println("Send Mail");
			break;
		}
		return nof;
	}

	@PostMapping("/post")
	public ResponseEntity<addResponse> addManager(@RequestBody Manager m) {
		if ( m == null || m.getUserId() <= 0 || m.getCurrent_balance() <= 0) {
			addResponse addF = new addResponse("1", "Add failed", "1", LocalDateTime.now().toString(),String.valueOf(m.getUserId()));
			log.error(String.valueOf(addF));
			return new ResponseEntity<>(addF, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			addResponse addT = new addResponse("0", "Added !", "0", LocalDateTime.now().toString(),String.valueOf(m.getUserId()));
			list.add(m);
			log.info(String.valueOf(addT));
			
			return new ResponseEntity<>(addT, HttpStatus.CREATED);		
		}
	}

	@PutMapping("/put")
	public ResponseEntity<updateResponse> updateManager(@RequestBody Manager m) {
		if (m == null || list.size() == 0) {
			updateResponse updF = new updateResponse("2", "Update failed", "2", LocalDateTime.now().toString(),
					String.valueOf(m.getUserId()));
			log.error(String.valueOf(updF));
			return new ResponseEntity<>(updF, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		updateResponse updT = new updateResponse();
		list.forEach(t -> {
			if (t.getUserId() != m.getUserId())
					return;
			t.setTitle(m.getTitle());
			t.setContent(m.getContent());
			t.setCurrent_balance(m.getCurrent_balance());
			t.setType(m.getType());
			t.setPartner(m.getPartner());
			updT.setResponseId("0");
			updT.setResponseMessage("Updated !");
			updT.setResponseCode("0");
			updT.setResponseTime(LocalDateTime.now().toString());
			updT.setUpdateId(String.valueOf(m.getUserId()));
		});
		log.info(String.valueOf(updT));
		return new ResponseEntity<>(updT, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<deleteResponse> deleteManager(@RequestParam(name = "id") int id) {
		deleteResponse delF = new deleteResponse();
		if (id <= 0 || list.size() == 0) {
			delF.setResponseId("3");
			delF.setResponseMessage("Delete failed !");
			delF.setResponseCode("3");
			delF.setResponseTime(LocalDateTime.now().toString());
			delF.setDeleteId(String.valueOf(id));
			log.error(String.valueOf(delF));
			return new ResponseEntity<>(delF, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		deleteResponse delT = new deleteResponse();	
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUserId() == id) {
				list.remove(i);
				delT.setResponseId("0");
				delT.setResponseMessage("Deleted !");
				delT.setResponseCode("0");
				delT.setResponseTime(LocalDateTime.now().toString());
				delT.setDeleteId(String.valueOf(id));
			}else {
				log.error(String.valueOf(delF));
				return new ResponseEntity<>(delF, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		log.info(String.valueOf(delT));
		
		return new ResponseEntity<>(delT, HttpStatus.ACCEPTED);
	}
}
