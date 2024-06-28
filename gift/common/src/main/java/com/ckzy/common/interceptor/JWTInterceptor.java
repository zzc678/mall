package com.ckzy.common.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ckzy.common.constant.MessageValidate;
import com.ckzy.common.utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();

        String token = request.getHeader("token");

        // 无异常则放行
        try {
            JWTUtils.verify(token);
            return true;
        } catch (SignatureVerificationException e){
            e.printStackTrace();
            map.put("msg", MessageValidate.INVALID_SIGNATURE);
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", MessageValidate.TOKEN_EXPIRED);
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", MessageValidate.ALGORITHM_INCONSISTENCY);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", MessageValidate.TOKEN_INVALID);
        }

        map.put("status", false);
        String s = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Method", "*");

        return false;
    }
}
