package com.zxl.dailypractice.project.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhaoxl
 * @date: 2022/12/5
 * @desc:
 **/
public class IpUtil {
    /**
     * 获取请求IP:
     * 用户的真实IP不能使用request.getRemoteAddr()
     * 这是因为可能会使用一些代理软件，这样ip获取就不准确了
     * 此外我们如果使用了多级（LVS/Nginx）反向代理的话，ip需要从X-Forwarded-For中获得第一个非unknown的IP才是用户的有效ip。
     *
     * @param request 请求
     * @return String
     */
    public static String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
