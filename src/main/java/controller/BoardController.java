package controller;

import beans.ContentsInfoBean;
import beans.MemberInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.BoardService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/board")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Resource(name = "loginMemberBean")
    @Lazy
    private MemberInfoBean loginMemberBean;

    @GetMapping("/main")
    public String boardMain(@RequestParam("board_info_idx") int board_info_idx,
                            Model model){
        // 어느 게시판에서 글을 쓰고 있는지를 알아야 하므로 board_info_idx 를 param 으로 보내 구분할 수 있게 한다.
        model.addAttribute("board_info_idx",board_info_idx);

        String boardInfoName = boardService.getBoardInfoName(board_info_idx);
        model.addAttribute("boardInfoName", boardInfoName);

        List<ContentsInfoBean> contentList = boardService.getContentBean(board_info_idx);
        model.addAttribute("contentList", contentList);

        return "/board/main";
    }

    @GetMapping("/write")
    public String boardWrite(@ModelAttribute("writeContentBean") ContentsInfoBean writeContentBean,
                             @RequestParam("board_info_idx") int board_info_idx){
        writeContentBean.setContent_board_idx(board_info_idx);
        return "/board/write";
    }

    @PostMapping("/write_pro")
    public String write_pro(@Valid @ModelAttribute("writeContentBean") ContentsInfoBean writeContentBean,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "/board/write";
        }

        boardService.addContentInfoBean(writeContentBean);

        return "/board/write_success";
    }

    @GetMapping("/read")
    public String boardRead(@RequestParam("board_info_idx") int board_info_idx,
                            @RequestParam("content_idx") int content_idx,
                            Model model){

        model.addAttribute("board_info_idx",board_info_idx);
        model.addAttribute("content_idx",content_idx); // 수정 / 삭제를 위한 글의 번호를 model 에 담는다.

        ContentsInfoBean readContentBean = boardService.getContentInfo(content_idx);
        model.addAttribute("readContentBean",readContentBean); // 게시글의 내용이 담긴 attribute

        // 사용자 정보와 글 작성자 번호를 비교하기 위한 attribute 주입.
        // sql 로 가져온 content_writer_idx 의 값과 비교하게 될 것.
        model.addAttribute("loginMemberBean",loginMemberBean);

        return "/board/read";
    }

    @GetMapping("/modify")
    public String boardModify(){

        return "/board/modify";
    }

    @GetMapping("/not_writer")
    public String not_writer(){

        return "/board/not_writer";
    }

    @GetMapping("/remove")
    public String boardRemove(){

        return "/board/remove";
    }


}
