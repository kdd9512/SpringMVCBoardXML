package dao;

import beans.ContentsInfoBean;
import org.apache.ibatis.session.RowBounds;
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

    public List<ContentsInfoBean> getContentBean(int board_info_idx, RowBounds rowBounds) {
        return sqlSessionTemplate.selectList("board.getContentBean", board_info_idx, rowBounds);
    }

    public ContentsInfoBean getContentInfo(int content_idx) {
        return sqlSessionTemplate.selectOne("board.getContentInfo", content_idx);
    }

    public void modifyContentInfo(ContentsInfoBean modifyContentBean) {
        sqlSessionTemplate.update("board.modifyContentInfo",modifyContentBean);
    }

    public void removeContentInfo(int content_idx) {
        sqlSessionTemplate.delete("board.removeContentInfo", content_idx);
    }

    public int getContentCnt(int content_board_idx) {
        return sqlSessionTemplate.selectOne("board.getContentCnt", content_board_idx);
    }

}
