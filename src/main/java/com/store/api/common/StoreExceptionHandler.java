package com.store.api.common;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Controller
public class StoreExceptionHandler {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
  
    @ExceptionHandler(Exception.class)  
    @ResponseBody  
    public String handleException(Exception e ,HttpServletRequest req) {
        StackTraceElement[] ste = e.getStackTrace();  
        StringBuffer sb_e = new StringBuffer();  
        for(int j=0;j<ste.length;j++){  
                sb_e.append(ste[j].toString()+"\n");  
        }
        
        StringBuffer sbUrl = new StringBuffer();
        Enumeration<String> en = req.getParameterNames();//请求参数-值  
        sbUrl.append(req.getRequestURI().toString());
        for(int i=0; en.hasMoreElements(); i++){  
            String arg = en.nextElement().toString();  
            if(i==0){  
                sbUrl.append("?");  
            }else{  
                sbUrl.append("&");  
            }  
            sbUrl.append(arg + "=" + req.getParameterValues(arg)[0]);  
        }  
        LOG.error(sbUrl.toString()+" --->\n"+e.getMessage()+"\n"+sb_e.toString());
        AjaxObject ajaxObject=AjaxObject.newError("服务器异常");
        return ajaxObject.toString();  
    }  
}