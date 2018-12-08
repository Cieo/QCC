package QCC.Controller;

import QCC.Model.Result.ConfigResult;
import QCC.Service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConfigController {

    @Autowired
    ConfigService configService;

    @RequestMapping(value = "/QCC/config/user/{root}", method = RequestMethod.POST)
    public ConfigResult setUserInfo(@RequestParam(name = "user") String user, @RequestParam(name = "pwd") String pwd,@PathVariable(name = "root") String type){
        ConfigResult result = new ConfigResult();
        switch (type){
            case "root":
                configService.configCspRootInfo(user, pwd);
                break;
            case "csp":
                configService.configCspUserInfo(user, pwd);
                break;
            default:
                result.fail(400, "Wrong user type : " + type);
        }
        return result;
    }

    @RequestMapping(value = "/QCC/config/paas", method = RequestMethod.POST)
    public ConfigResult setPaasInfo(@RequestParam(name = "paas") String paas){
        ConfigResult configResult = new ConfigResult();
        configService.configPaas(paas);
        return configResult;
    }


}
