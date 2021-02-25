package com.ex.seed.constant;

public interface SsoConstant {


    /**
     * SSO排除的路径
     */
    String SSO_EXCLUDED_PATHS = "sso_excluded_paths";

    /**
     * sso服务地址
     */
    String SSO_SERVER = "sso_server";

    /**
     * 单点登录地址
     */
    String SERVER_LOGIN_PATH = "/sso/login";

    /**
     * 单点登出地址
     */
    String SERVER_LOGOUT_PATH = "/sso/logout";

    /**
     * session ticket
     */
    String SESSION_TICKET = "ticket";


}
