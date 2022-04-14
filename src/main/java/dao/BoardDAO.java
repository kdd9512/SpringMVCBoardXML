package dao;

import beans.ContentsInfoBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void addContentInfo(ContentsInfoBean writeContentBean) {
        sqlSessionTemplate.insert("board.addContentInfo", writeContentBean);
    }

    public String getBoardInfoName(int board_info_idx) {
        return sqlSessionTemplate.selectOne("board.getBoardInfoName", board_info_idx);
    }

    public List<ContentsInfoBean> getContentBean(int board_info_idx) {
        return sqlSessionTemplate.selectList("board.getContentBean", board_info_idx);
    }

    public ContentsInfoBean getContentInfo(int content_idx) {
        return sqlSessionTemplate.selectOne("board.getContentInfo", content_idx);
    }

    public void modifyContentInfo(ContentsInfoBean modifyContentBean) {
        sqlSessionTemplate.update("board.modifyContentInfo",modifyContentBean);
    }

}
