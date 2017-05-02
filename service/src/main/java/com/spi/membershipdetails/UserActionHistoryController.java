package com.spi.membershipdetails;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spi.membershipdetails.bean.UserActionHistory;
import com.spi.membershipdetails.dao.UserActionHistoryImpl;



@RestController
@Component
@CrossOrigin
public class UserActionHistoryController{// implements Filter { 

	
	@Autowired
	UserActionHistory accountDetails; 
	
	@Autowired
	UserActionHistoryImpl actionHistoryImpl;
	
	public static final String ACCOUNT = "UserHistory";

	@RequestMapping(value="/readAccount", method=RequestMethod.GET)
	public String readUserActionHistory( 
			@RequestParam(value = "ban") int ban)
			throws UnknownHostException {
		
	    return actionHistoryImpl.readUserActionDetails(accountDetails,ACCOUNT,ban);
	
	}
}