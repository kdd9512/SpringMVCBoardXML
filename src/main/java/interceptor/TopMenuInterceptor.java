package interceptor;

import beans.BoardInfoBean;
import beans.MemberInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;
import service.TopMenuService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class TopMenuInterceptor implements HandlerInterceptor {

    // Java 에서는 자동주입이 불가능하나 XML 에서는 가능하다.
    @Autowired
    private TopMenuService topMenuService;

    @Resource(name = "loginMemberBean")
    @Lazy
    private MemberInfoBean loginMemberBean;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
        request.setAttribute("topMenuList", topMenuList);
        request.setAttribute("loginMemberBean", loginMemberBean);

        return true;
    }
}
