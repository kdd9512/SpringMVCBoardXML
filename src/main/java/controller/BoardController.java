package controller;

import beans.ContentsInfoBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/board")
@Controller
public class BoardController {

    @GetMapping("/main")
    public String boardMain(@RequestParam("board_info_idx") int board_info_idx,
                            Model model){
        // 어느 게시판에서 글을 쓰고 있는지를 알아야 하므로 board_info_idx 를 param 으로 보내 구분할 수 있게 한다.
        model.addAttribute("board_info_idx",board_info_idx);
        return "/board/main";
    }

    @GetMapping("/write")
    public String boardWrite(@ModelAttribute("writeContentBean") ContentsInfoBean writeContentBean){
        return "/board/write";
    }

    @GetMapping("/read")
    public String boardRead(){

        return "/board/read";
    }

    @GetMapping("/modify")
    public String boardModify(){

        return "/board/modify";
    }

    @GetMapping("/remove")
    public String boardRemove(){

        return "/board/remove";
    }


}
