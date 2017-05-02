package com.spi.membershipdetails.dao;




import com.spi.membershipdetails.bean.UserActionHistory;

public interface UserActionHistoryDAO {
	public String readUserActionDetails(UserActionHistory actionHistoryDetDTO, String ACCOUNT, int ban);
}
