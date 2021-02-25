package com.ex.seed.filter;

import com.ex.seed.biz.UserInfoService;
import com.ex.seed.bo.UserInfoBo;
import com.ex.seed.constant.SsoConstant;
import com.ex.seed.utils.SpringUtil;
import com.ex.seed.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

public class SsoLoginFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(SsoLoginFilter.class);

    private String ssoServer;

    private String excludedPaths;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ssoServer = filterConfig.getInitParameter(SsoConstant.SSO_SERVER);
        excludedPaths = filterConfig.getInitParameter(SsoConstant.SSO_EXCLUDED_PATHS);
        logger.info("SsoLoginFilter init.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        // excluded path check
        if (excludedPaths!=null && excludedPaths.trim().length()>0) {
            for (String excludedPath:excludedPaths.split(",")) {
                String uriPattern = excludedPath.trim();
                // 支持ANT表达式
                if (requestURI.contains(uriPattern)) {
                    // excluded path, allow
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }
        }

        // 客户端发起统一登出请求
        String serverLogoutPath = SsoConstant.SERVER_LOGOUT_PATH;
        if (requestURI.contains(serverLogoutPath)) {
            // 重定向服务端，进行统一登出
            response.sendRedirect(ssoServer + serverLogoutPath);
            return;
        }
        UserInfoBo ssoUser = UserUtil.getUserInfo(request);
        if (ssoUser == null){
            StringBuffer requestService = request.getRequestURL();
            String urlEncoderService = URLEncoder.encode(String.valueOf(requestService), "utf-8");
            String redirectUrl = ssoServer + SsoConstant.SERVER_LOGIN_PATH + "?service=" + urlEncoderService;
            response.sendRedirect(redirectUrl);
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }

}
