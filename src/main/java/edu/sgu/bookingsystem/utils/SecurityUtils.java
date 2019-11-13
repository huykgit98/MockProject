package edu.sgu.bookingsystem.utils;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import edu.sgu.bookingsystem.filter.SecurityConfig;

public class SecurityUtils {
	//kiem tra request nay co bat buoc phai dang nhap khong -> chi trang login.jsp khong, con lai can phai bat buoc dang nhap
	public static boolean isSecurityPage(HttpServletRequest request)
	{
		//b1: lay url request 
		String urlPattern = UrlPatternUtils.getUrlPattern(request);
		
		//b2: lay tat ca role cho vao set<String> , tat ca role la duy nhat, vi cac role co gia tri nhu nhau (vd: admin_hung = admin1, seller_abc= seller_xyz)
		Set<String> roles = SecurityConfig.getAllAppRoles(); 
		
		//b3: check
		//b3.1: bo tat ca "url theo role" vao List
		//b3.2: neu "url theo role" chua url request -> tra ve true
		for (String r: roles)
		{
			List<String> urlPatternList = SecurityConfig.getUrlPatternsForRole(r);
			if (urlPatternList != null && urlPatternList.contains(urlPattern)) //b3.2
			{
				return true;
			}
		}
		return false;	
	}
	
	
	// check "request" co vai tro phu hop khong?
	public static boolean hasPermission(HttpServletRequest request)
	{
		String urlPattern = UrlPatternUtils.getUrlPattern(request);
		Set<String> allRoles = SecurityConfig.getAllAppRoles();
		
		for (String r: allRoles)
		{
			if ( !request.isUserInRole(r)) {
				continue;
			}
			 List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(r);
	            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
	                return true;
	            }
		}
		return false;
	}
}
