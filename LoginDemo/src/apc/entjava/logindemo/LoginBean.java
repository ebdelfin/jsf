package apc.entjava.logindemo;

import apc.entjava.logindemo.dataobjects.LoginDao;
import apc.entjava.logindemo.services.LoginService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * Created by student on 12/2/2017.
 */
@ManagedBean
public class LoginBean {
    private String loginName;
    private String password;

    @ManagedProperty(value = "#{authBean}")
    private AuthBean authBean;

    public AuthBean getAuthBean() {
        return authBean;
    }

    public void setAuthBean(AuthBean authBean) {
        this.authBean = authBean;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private LoginService loginService = new LoginDao();

    public String login() {
        if(loginService.login(loginName, password)) {
            authBean.setLoggedUsername(loginName);
            return "protected/mainpage";
        }
        else {
            return "error";
        }
    }
}
