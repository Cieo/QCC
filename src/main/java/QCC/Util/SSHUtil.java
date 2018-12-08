package QCC.Util;

import QCC.Model.Constant.EnvironmentConstant;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;


public class SSHUtil {

    private static final String EXPORTK8S = "export kubectl=";
    private static final String getAllPod = "";
    private static final String getPodDescribe = "";

    @Autowired
    EnvironmentConstant environmentConstant;

    public static List<String> queryInstance(){
        return null;
    }

    public static Channel getShell(Session session){
        return null;
    }

    public static Channel getFtp(Session session){
        return null;
    }

}
