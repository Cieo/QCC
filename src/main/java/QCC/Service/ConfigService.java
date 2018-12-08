package QCC.Service;

import QCC.Model.Constant.EnvironmentConstant;
import QCC.Model.Result.ConfigResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    @Autowired
    EnvironmentConstant environmentConstant;

    public boolean configCspUserInfo(String cspUser, String cspPwd){
        environmentConstant.setCspUserInfo(cspUser, cspPwd);
        return true;
    }

    public boolean configCspRootInfo(String rootUser, String rootPwd){
        environmentConstant.setRootUserInfo(rootUser, rootPwd);
        return true;
    }

    public boolean configPaas(String paas){
        environmentConstant.setPaasIp(paas);
        return true;
    }

}
