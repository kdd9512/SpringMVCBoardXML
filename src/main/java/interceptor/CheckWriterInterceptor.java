package interceptor;

import beans.ContentsInfoBean;
import beans.MemberInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;
import service.BoardService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckWriterInterceptor implements HandlerInterceptor {

    @Resource(name = "loginMemberBean")
    @Lazy
    // 우선 로그인한 회원의 정보가 필요하다. MemberInfoBean
    private MemberInfoBean loginMemberBean;

    @Autowired
    // 위의 로그인정보와 비교할 작성자의 index 번호가 필요하다.
    // 이 부분은 Service 의 getContentInfo 가 가지고 있으므로 이를 호출.
    private BoardService boardService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
                             Object handler) throws Exception {

        String str1 = req.getParameter("content_idx"); // 비교의 조건이 되는 값을 추출.
        int content_idx = Integer.parseInt(str1); // Integer 로 변환.

        ContentsInfoBean currentContentBean = boardService.getContentInfo(content_idx);

        if (currentContentBean.getContent_writer_idx() != loginMemberBean.getUser_idx()) {

            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/board/not_writer");

            return false;
        }

        return true;
    }
}
