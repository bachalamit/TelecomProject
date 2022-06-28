package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig()

	{
		try {
			FileInputStream fis = new FileInputStream("./Configuration/config.properties");
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getEdgepath()
	{
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}
	public String getFirefoxpath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getUserID()
	{
		String username = pro.getProperty("userID");
		return username;
	}
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}

}
