package com.spi.membershipdetails.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spi.membershipdetails.CreateConnection;
import com.spi.membershipdetails.bean.UserActionHistory;

@Component
public class UserActionHistoryImpl implements UserActionHistoryDAO {

	/* Read the userDetails */
	public UserActionHistory readUserActionDetails(
			UserActionHistory actionHistoryDetDTO, String mobile,
			String district, String member) throws SQLException {
		// For XML

		CreateConnection con = new CreateConnection();
		Statement st = con.getConnection().createStatement();

		String finalSQL = "Select name,memberid,Joining_Date,Membership_Type,Disrtict,Mobile_Number,ADDRESS,Blood_group from user_details";
		if (!mobile.equals("") && district.equals("") && member.equals("")) {
			finalSQL = finalSQL + " where Mobile_Number like '%" + mobile
					+ "%'";
		}

		if (!district.equals("") && mobile.equals("") && member.equals("")) {
			finalSQL = finalSQL + " where Disrtict like '%" + district + "%'";
		}

		if (district.equals("") && mobile.equals("") && !member.equals("")) {
			finalSQL = finalSQL + " where MemberID like '%" + member + "%'";
		}

		if (!mobile.equals("") && !district.equals("") && member.equals("")) {
			finalSQL = finalSQL + " where Mobile_Number like '%" + mobile
					+ "%' and Disrtict like '%" + district + "%'";
		}

		if (!mobile.equals("") && district.equals("") && !member.equals("")) {
			finalSQL = finalSQL + " where Mobile_Number like '%" + mobile
					+ "%' and MemberID like '%" + member + "%'";
		}

		if (mobile.equals("") && !district.equals("") && !member.equals("")) {
			finalSQL = finalSQL + " where Disrtict like '%" + district
					+ "%' and MemberID like '%" + member + "%'";
		}

		if (!mobile.equals("") && !district.equals("") && !member.equals("")) {
			finalSQL = finalSQL + " where Mobile_Number like '%" + mobile
					+ "%'" + " and Disrtict like '%" + district
					+ "%' and MemberID like '%" + member + "%'";
		}

		if (mobile.equals("") && district.equals("") && member.equals("")) {
			finalSQL = finalSQL + " where Application_Number is not null";
		}

		finalSQL = finalSQL + " order by Joining_Date";

		System.out.println(finalSQL);

		ResultSet rs = st.executeQuery(finalSQL);
		int i = 1;
		List<List<String>> booklist = new ArrayList<List<String>>();
		while (rs.next()) {
			List<String> book = new ArrayList<String>();
			book.add(rs.getString(1));
			book.add(rs.getString(2));
			book.add(rs.getString(3));
			book.add(rs.getString(4));
			book.add(rs.getString(5));
			book.add(rs.getString(6));
			booklist.add(book);
			i++;
		}
		if (booklist.size() == 0) {
			/*
			 * request.setAttribute("IdList", booklist); RequestDispatcher
			 * dispatcher = getServletContext() .getRequestDispatcher(
			 * "/SearchDynamic.jsp?errorCode= No Records Found");
			 * dispatcher.forward(request, response);
			 */
			// response.sendRedirect(request.getContextPath()
			// +"/SearchDynamic.jsp?errorCode= No Records Found");
		} else {
			/*
			 * request.setAttribute("IdList", booklist); RequestDispatcher
			 * dispatcher = getServletContext()
			 * .getRequestDispatcher("/SearchDynamic.jsp");
			 * dispatcher.forward(request, response);
			 */
			// System.out.println(booklist.size());
			// response.sendRedirect(request.getContextPath()
			// +"/SearchDynamic.jsp");
		}

		if (actionHistoryDetDTO != null
				&& !actionHistoryDetDTO.getAttributeName().equals(null)) {
			return new UserActionHistory(null,
					"Attribuite Name for the Given BAN is :"
							+ actionHistoryDetDTO.getAttributeName()
							+ " :Retreived Successfully", null, 0, null, null,
					null, null, null, null, null);
		} else {
			return new UserActionHistory(null, "No Records Found", null, 0,
					null, null, null, null, null, null, null);
		}
	}

	@Override
	public String readUserActionDetails(UserActionHistory actionHistoryDetDTO,
			String ACCOUNT, int ban) {
		// TODO Auto-generated method stub
		return "Hai";
	}
}
