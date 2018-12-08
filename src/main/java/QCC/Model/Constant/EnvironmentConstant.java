package QCC.Model.Constant;

import com.jcraft.jsch.Session;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnvironmentConstant {
    private String paasIp = "";
    private String cspUser = "cspexpert";
    private String cspPwd = "mt2017@cspos@HW";
    private String rootUser = "root";
    private String rootPwd = "cnp200@cspos@HW";


    private List<String> instances = new ArrayList<>();

    public EnvironmentConstant() {
    }

    public String getPaasIp() {
        return paasIp;
    }

    public String getCspUser() {
        return cspUser;
    }

    public String getCspPwd() {
        return cspPwd;
    }

    public String getRootUser() {
        return rootUser;
    }

    public String getRootPwd() {
        return rootPwd;
    }

    public void setPaasIp(String paasIp){
        this.paasIp = paasIp;
    }

    public void setCspUserInfo (String cspUser, String cspPwd){
        this.cspUser = cspUser;
        this.cspPwd = cspPwd;
    }

    public void setRootUserInfo(String rootUser, String rootPwd) {
        this.rootUser = rootUser;
        this.rootPwd = rootPwd;
    }

}
