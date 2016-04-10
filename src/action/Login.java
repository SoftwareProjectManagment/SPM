package action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import javax.faces.bean.SessionScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.*;

/**
 * Created by Martin on 2015/12/25.
 */
@SessionScoped
public class Login extends ActionSupport {
    Connection conn=null;
    Statement stmt = null;
    ResultSet rs=null;
    String DBpassword=null;
    String DBidentity=null;
    private String username;
    private String password;
    private String identity;
    private String message;
    private Map<String,Object> attributes;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this. username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this. password = password;
    }
    public String loginUser(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            conn=DriverManager. getConnection("jdbc:mysql://localhost:3306/test",
                    "root", "root");
            stmt=conn.createStatement();
            rs=stmt.executeQuery("select * from user where username = '" + username +"'");
            if(rs.next()){
                DBpassword = rs.getString("password");
                DBidentity = rs.getString("identity");
            }
            else
            {
                message="登录失败";
                return "fail";
            }
        } catch(Exception e){
            e.printStackTrace();
            message="登录失败";
            return "fail";
        }
        if (DBpassword.equals(password)&&DBidentity.equals("teacher")){
            return "success";
        }
        if (DBpassword.equals(password)&&DBidentity.equals("student")){
            attributes = ActionContext.getContext().getSession();
            attributes.put("username",username);
            return "display";
        }
        else{
            message="登录失败";
            return "fail";
        }
    }
    public String registerPage(){
        return "success";
    }
    public String register(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "root", "root");
            stmt = conn.createStatement();
            stmt.executeUpdate("insert into user (username,password,identity) values('"+username+"','"+password+"','"+identity+"')");
        }
        catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
    public String back(){
        return "success";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
