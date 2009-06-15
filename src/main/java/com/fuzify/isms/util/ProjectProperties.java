package com.fuzify.isms.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

/**
 * @author  arindam
 */
public class ProjectProperties extends HttpServlet 
{
	static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ProjectProperties.class);
	/**
	 * @uml.property  name="projectProperties"
	 */
	static Properties projectProperties;
	/**
	 * @uml.property  name="properties"
	 */
	static Properties properties;
	
	public void init() throws ServletException
	{
		try 
		{
			System.out.println("Loading Project Properties ...");
			log("Loading Project Properties ...");
//           
//			InputStream is = new FileInputStream(this.getServletContext().getRealPath("WEB-INF/classes/project.properties"));
//            projectProperties = new Properties();
//            projectProperties.load(is);
//            this.getServletContext().setAttribute("properties",projectProperties);
//            is.close();
            
            //loadTargetProperties();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 * @uml.property  name="projectProperties"
	 */
	public static Properties getProjectProperties()
	{
		return projectProperties;
	}
	
	/**
	 * @return
	 * @uml.property  name="properties"
	 */
	public static Properties getProperties()
	{
		return properties;
	}
	
	private void loadTargetProperties()
	{
		System.out.println("Loading Target Properties ...");
		try
		{
			String loadPathPrefix = "WEB-INF/classes/";
			String targetPropertyFile = projectProperties.getProperty("status").toLowerCase()+".properties";
			String loadPath = loadPathPrefix + targetPropertyFile;
		
			InputStream is = new FileInputStream(this.getServletContext().getRealPath(loadPath));
		
			properties = new Properties();
			properties.load(is);

            this.getServletContext().setAttribute("properties", properties);
            is.close();

			System.out.println("Target Properties app_url_prefix = "+ properties.getProperty("app_url_prefix"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

