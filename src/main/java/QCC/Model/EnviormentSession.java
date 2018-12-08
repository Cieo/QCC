package QCC.Model;

import QCC.Model.Constant.EnvironmentConstant;
import com.jcraft.jsch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnviormentSession {

    @Autowired
    EnvironmentConstant envConst;

    private Session session;

    @Scheduled(fixedRate = 10000)
    private List<String> queryInstances() {
        List<String> result = new ArrayList<>();
        ChannelExec channelExec = getExec();
        if (!validChannel(channelExec)){
            return result;
        }

        StringBuffer buffer = new StringBuffer();

        channelExec.setCommand("");

        return result;
    }

    public boolean upload() {
        return false;
    }

    public boolean download() {
        return false;
    }

    public String connectSession() {
        if (sessionValid()) {
            session.disconnect();
        }
        try {
            JSch jSch = new JSch();
            session = jSch.getSession("cspexpert", envConst.getCspUser(), 22);
            session.setPassword(envConst.getCspPwd());
            setSessionConfig();
            session.connect();
        } catch (JSchException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "";
    }

    private boolean sessionValid() {
        return session != null && session.isConnected();
    }

    private void setSessionConfig() {
        session.setConfig("StrictHostKeyChecking", "no");
        session.setConfig("ClientAliveInterval", "60");
    }

    private ChannelSftp getFtp() {
        ChannelSftp channelSftp;
        try {
            channelSftp = (ChannelSftp) session.openChannel("Sftp");
            channelSftp.connect();
            return channelSftp;
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ChannelExec getExec() {
        ChannelExec channelExec;
        try {
            channelExec = (ChannelExec) session.openChannel("Exec");
            channelExec.connect();
            return channelExec;
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean validChannel(Channel channel){
        return channel != null && channel.isConnected();
    }
}
