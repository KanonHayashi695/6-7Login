package jp.co.aforce.Action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Customer;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;



public class LoginAction extends Action{
		String errormessage="IDもしくはパスワードが違います。";
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		
		HttpSession session=request.getSession();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		CustomerDAO dao=new CustomerDAO();
		Customer customer=dao.search(id, password);
		
		if(customer!=null) {
			session.setAttribute("customer",customer);
			return "jsp/login-suc.jsp";
		}
		
		return errormessage;
	}

}
