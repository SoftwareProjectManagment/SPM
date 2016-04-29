package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by Java on 2016/4/20.
 */
public class LogoutAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        Map<String,Object> session = ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }
}
