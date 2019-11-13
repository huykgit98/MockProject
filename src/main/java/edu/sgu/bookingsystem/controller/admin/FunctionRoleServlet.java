package edu.sgu.bookingsystem.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.model.RoleModel;
import edu.sgu.bookingsystem.service.RoleService;
import edu.sgu.bookingsystem.service.impl.RoleServiceImpl;
@WebServlet("/functionServlet")
public class FunctionRoleServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	RoleService roleService = null;

	public FunctionRoleServlet() {
		// TODO Auto-generated constructor stub
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
			String nameR = req.getParameter("name_role");
			String descriptionR = req.getParameter("description_role");
			System.out.println(yc+" "+nameR+" "+descriptionR);
			if (yc.equals("addNewRole")) {		
				RoleModel createnewRole = new RoleModel(nameR, descriptionR);
				roleService.insertRole(createnewRole);
				resp.sendRedirect("listRoleController");
			} else if (yc.equals("updateRole")) {
				String id_role_change = req.getParameter("txt_id_role");
				String name_role_change =req.getParameter("txt_name_role");
				String des_change =req.getParameter("txt_description_role");
				RoleModel createnewRole1 = new RoleModel(Long.parseLong(id_role_change),name_role_change, des_change);
				roleService.updateRole(createnewRole1);
				resp.sendRedirect("listRoleController");
			} else if (yc.equals("editRole")) {
				String id_food = req.getParameter("txtId");
				RoleModel roleEdit = roleService.getID(Long.parseLong(id_food));
				req.setAttribute("roleEdit", roleEdit);
				dispatcher = req.getRequestDispatcher("admin/updateRole.jsp");
				dispatcher.forward(req, resp);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
