package db1;

public class UsingDB {

	String url = "jdbc:mysql://127.0.0.1:3306/kimshinyanglee?useSSL=false";
	String dbuser = "kimshinyanglee";
	String dbpass = "uh129921";

	public String getUrl(){
		return url;
	}

	public String getDbuser(){
		return dbuser;
	}

	public String getDbpass(){
		return dbpass;
	}

}
