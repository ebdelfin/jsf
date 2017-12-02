package apc.entjava.logindemo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class LoginBean {
    private String userName;
    private String password;


    @ManagedProperty(value = "#{authBean}")
    private AuthBean authBean;

    public AuthBean getAuthBean() {
        return authBean;
    }

    public void setAuthBean(AuthBean authBean) {
        this.authBean = authBean;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        if(userName.equals("admin") && password.equals("password")){
            authBean.setLoggedUserName(userName);
            return "protected/mainpage";
        }else {
            return "error";
        }
    }

}
