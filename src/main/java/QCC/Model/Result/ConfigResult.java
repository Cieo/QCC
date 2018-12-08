package QCC.Model.Result;

public class ConfigResult {
    private int code;
    private boolean success;
    private String retInfo;

    public ConfigResult() {
        this.code = 200;
        this.success = true;
        this.retInfo = null;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    public void fail(int code, String info){
        this.code = code;
        this.success = false;
        this.retInfo = info;
    }

    public void success(int code, String info){
        this.code = code;
        this.success = true;
        this.retInfo = info;
    }
}
