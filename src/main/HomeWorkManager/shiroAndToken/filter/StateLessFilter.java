package HomeWorkManager.shiroAndToken.filter;

import HomeWorkManager.shiroAndToken.StateLessToken;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cjw on 2017/12/16.
 */
public class StateLessFilter extends AccessControlFilter {

    public static final int HTTP_STATUS_AUTH = 306;
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        Map<String, String[]> params = new HashMap<String, String[]>(servletRequest.getParameterMap());
        String clentDegist=httpServletRequest.getHeader("clentDegist");
        StateLessToken stateLessToken=new StateLessToken(params,clentDegist);
        if(clentDegist==null){
            onAjaxAuthFail(servletRequest,servletResponse);
            return false;
        }
        try {
            getSubject(servletRequest,servletResponse).login(stateLessToken);
        }catch (AuthenticationException e){
            e.printStackTrace();
            onAjaxAuthFail(servletRequest,servletResponse);
            return false;
        }
        catch (Exception e)
        {
            onAjaxAuthFail(servletRequest,servletResponse);
            return false;
        }

        return true;
    }

    protected void onAjaxAuthFail(ServletRequest request, ServletResponse resp) throws IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        JSONObject json = new JSONObject();
        json.put("msg", "auth check error!");
        response.setStatus(HTTP_STATUS_AUTH);
        response.getWriter().write(json.toString());
    }
}
