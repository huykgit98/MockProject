package edu.sgu.bookingsystem.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import edu.sgu.bookingsystem.model.User;

public class AppUtils {

	private static int REDIRECT_ID = 0;
	
	private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
	private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();

	//luu tru thong tin nguoi dung vao session
	public static void storeLoginedUser(HttpSession session, User loginedUser) {
		session.setAttribute("loginedUser", loginedUser); //tren jsp truy cap thong qua ${loginedUser}
	}
	
	//lay thong tin nguoi dung luu tru trong session
	public static User getLoginedUser(HttpSession session) {
		User loginedUser = (User) session.getAttribute("loginedUser");
		return loginedUser;
	}

	public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
		Integer id = uri_id_map.get(requestUri);

		 if (id == null) {
	            id = REDIRECT_ID++;
	 
	            uri_id_map.put(requestUri, id);
	            id_uri_map.put(id, requestUri);
	            return id;
	        }
	 
	        return id;
	}



	public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
		String url = id_uri_map.get(redirectId);
        if (url != null) {
            return url;
        }
        return null;
    }

}
