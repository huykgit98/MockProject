package edu.sgu.bookingsystem.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.model.RoleModel;
import edu.sgu.bookingsystem.model.UserModel;
import edu.sgu.bookingsystem.service.RoleService;
import edu.sgu.bookingsystem.service.UserService;
import edu.sgu.bookingsystem.service.impl.RoleServiceImpl;
import edu.sgu.bookingsystem.service.impl.UserServiceImpl;

@WebServlet("/functionUserController")
public class FunctionUserController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = null;
	RoleService roleService =null;
	public FunctionUserController() {
		// TODO Auto-generated constructor stub
		userService= new UserServiceImpl();
		roleService = new RoleServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = resp.getWriter()) {
			String yc = req.getParameter("action");
			System.out.println(yc);
			if (yc.equals("edit")) {
				String id_food = req.getParameter("txtIdUser");
				UserModel umdao = userService.getID(Long.parseLong(id_food));
				req.setAttribute("userEdit", umdao);
				getListRole(req,resp);
				RequestDispatcher dispatcher = req.getRequestDispatcher("admin/updateUser.jsp");
				dispatcher.forward(req, resp);
			}
			if(yc.equals("insertNewUser"))
			{
				String full_name = req.getParameter("txt_full_name_user");
				String user_name_login =req.getParameter("txt_name_user_login");
				String address  =req.getParameter("txt_address_user");
				String  number_phone=req.getParameter("txt_phone_user");
				Long id_option = Long.parseLong(req.getParameter("idOptionRole"));
				System.out.println(full_name +"  "+user_name_login+address+number_phone+id_option);
				UserModel userModel = new UserModel();
				userModel.setFullNameUser(full_name);
				userModel.setUserName(user_name_login);
				userModel.setAddressUser(address);
				userModel.setPhoneUser(number_phone);
				userModel.setRoleModel(roleService.getID(id_option));
				userService.insertUser(userModel);
				resp.sendRedirect("listUserController");	
			}
			if(yc.equals("updateUser"))
			{
				Long id_employee =Long.parseLong(req.getParameter("txt_id_name_user"));
				String full_name = req.getParameter("txt_full_name_user");
				String user_name_login =req.getParameter("txt_name_user_login");
				String address  =req.getParameter("txt_address_user");
				String  number_phone=req.getParameter("txt_phone_user");
				Long id_option = Long.parseLong(req.getParameter("idOptionRole"));
				UserModel userModel = new UserModel();
				userModel.setIdUser(id_employee);
				userModel.setFullNameUser(full_name);
				userModel.setUserName(user_name_login);
				userModel.setAddressUser(address);
				userModel.setPhoneUser(number_phone);
				userModel.setRoleModel(roleService.getID(id_option));
				userService.updateUser(userModel);
				resp.sendRedirect("listUserController");
			}
		}
	}
	private void getListRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ArrayList<RoleModel> lRole = roleService.getAllRole();
		req.setAttribute("listRoleF", lRole);
	}
}
