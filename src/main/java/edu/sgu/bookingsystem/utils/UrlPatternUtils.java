package edu.sgu.bookingsystem.utils;

import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;

public class UrlPatternUtils {

	  private static boolean hasUrlPattern(ServletContext servletContext, String urlPattern) {
	      Map<String, ? extends ServletRegistration> map = servletContext.getServletRegistrations();
	      for (String servletName : map.keySet()) {
	         ServletRegistration sr = map.get(servletName);
	         Collection<String> mappings = sr.getMappings();
	         if (mappings.contains(urlPattern)) {
	            return true;
	         }
	      }
	      return false;
	   }
	  
	  //Servlet url-pattern = /spath/*
	  //http://localhost:8080/ServletTutorial/----spath---/---abc---/---mnp?p1=1
	  //--------------------/-(contextpath)-/(servletPath)/(PathInfo)/----/(queryString)
	  //------(requestURL)--/------(requestURI)----------------
	  
	  // servletPath:
	   // ==> /spath
	   // ==> /spath/*
	   // ==> *.ext
	   // ==> /
	  public static String getUrlPattern(HttpServletRequest request) {
	      ServletContext servletContext = request.getServletContext(); // lay servletpatch & pathInfo chua vao servletContext
	      String servletPath = request.getServletPath();
	      String pathInfo = request.getPathInfo();
	 
	      String urlPattern = null;
	      if (pathInfo != null) {
	         urlPattern = servletPath + "/*";
	         return urlPattern;
	      }
	      urlPattern = servletPath; // urlpattern = servletPath = /spath/*
	 
	      boolean has = hasUrlPattern(servletContext, urlPattern);
	      if (has) {
	         return urlPattern;
	      }
	      int i = servletPath.lastIndexOf('.');
	      if (i != -1) {
	         String ext = servletPath.substring(i + 1);
	         urlPattern = "*." + ext;
	         has = hasUrlPattern(servletContext, urlPattern);
	 
	         if (has) {
	            return urlPattern;
	         }
	      }
	      return "/";
	   }
}
