package apc.entjava.jkem;

import apc.entjava.jkem.dataobjects.LoginDao;
import apc.entjava.jkem.services.LoginService;

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

    private LoginService loginService = new LoginDao();

    public String login(){
        if(loginService.login(userName, password)){
            authBean.setLoggedUserName(userName);
            return "protected/mainDashboard";
        }else {
            return "error";
        }
    }

}
