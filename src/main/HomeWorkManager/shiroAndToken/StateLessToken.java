package HomeWorkManager.shiroAndToken;

import org.apache.shiro.authc.AuthenticationToken;

import java.util.Map;

/**
 * Created by cjw on 2017/12/14.
 */
public class StateLessToken implements AuthenticationToken {

    private String clientKey;

    private String digest;// 消息摘要

    private String exp;

    private Map<String, ?> parameters;

    private String token;

    public StateLessToken(String clientKey,Map<String,?> parameters,String token){
        this.clientKey=clientKey;
        this.parameters=parameters;
        this.token=token;
    }

    @Override
    public Object getPrincipal() {
        return this.clientKey;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public Map<String, ?> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, ?> parameters) {
        this.parameters = parameters;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
