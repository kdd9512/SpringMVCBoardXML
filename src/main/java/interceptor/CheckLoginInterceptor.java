package interceptor;

import beans.MemberInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginInterceptor implements HandlerInterceptor {

    @Resource(name = "loginMemberBean")
    @Lazy
    private MemberInfoBean loginMemberBean;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        if (!loginMemberBean.isMemberLogin()) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/member/not_login");
            return false;
        }
        return true;
    }
}
