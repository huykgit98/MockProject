package edu.sgu.bookingsystem.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.sgu.bookingsystem.model.User;

public class SecurityConfig {
	
	public static final String ROLE_MANAGER = "MANAGER";
	public static final String ROLE_EMPLOYEE  = "EMPLOYEE";
	
	// String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>(); //key: duy nhat, value: trung lap, de truy xuat key va 1 role co nhieu user
 
    static {
        init();
    }

	private static void init() {
		//set Role for "EMPLOYEE"
		List<String> urlPatternEmployee = new ArrayList<String>();
		urlPatternEmployee.add("/admin-ticket");
		urlPatternEmployee.add("/admin-info");
		urlPatternEmployee.add("/admin-updateTicket");
		urlPatternEmployee.add("/admin-seat");
		urlPatternEmployee.add("/admin-updateseat");
		mapConfig.put(ROLE_EMPLOYEE, urlPatternEmployee);
		
		//set Role for "MANAGER"
		List<String> urlPatternManager = new ArrayList<String>();
		urlPatternManager.add("/admin-user");
		urlPatternManager.add("/admin-ticket");
		urlPatternManager.add("/admin-seat");
		urlPatternManager.add("/admin-info");
		urlPatternManager.add("/admin-updateseat");
		urlPatternManager.add("/admin-updateTicket");
		urlPatternManager.add("/admin-listUserController");
		urlPatternManager.add("/listUserController");
		mapConfig.put(ROLE_MANAGER, urlPatternManager); //admin
	}
	
	public static Set<String> getAllAppRoles(){
		return mapConfig.keySet(); 
		//lay tat ca Role tu mapConfig : gui qua SecurityUtil de check page nao can request dang nhap
	}
	
	public static List<String> getUrlPatternsForRole(String role) {
	        return mapConfig.get(role);
	        //lay url theo role
	    }
	
}
