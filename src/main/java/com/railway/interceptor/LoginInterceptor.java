package com.railway.interceptor;

import com.github.xiaoymin.knife4j.core.util.StrUtil;
import com.railway.Utils.JwtUtil;
import com.railway.Utils.ThreadLocalUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    private String jwt;
    private Claims claims;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取Token
        jwt = request.getHeader("Authorization");
        if (StrUtil.isBlank(jwt)) {
            //Token为空 无权访问页面
            response.setStatus(400);
            System.out.println("Token为空");
            return true;

        }

        //解析Token
        try {
            //检查是否存在过期或者篡改
            claims = JwtUtil.parser(jwt);
            //获取载荷中的用户ID
            String userId = (String) claims.get("userId");
            //将用户ID放入线程数组
            ThreadLocalUtil.saveUser(userId);
        }catch (Exception e){
            //jwt令牌验证失败
            response.setStatus(400);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        //删除线程中的用户ID
        ThreadLocalUtil.removeUser();
    }
}
