package cn.edu.cqu.letao.mapper;

import cn.edu.cqu.letao.entity.CmdtyDetails;
import cn.edu.cqu.letao.entity.vo.CommodityVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * CMDTY_DETAILS Mapper 接口
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
public interface CmdtyDetailsMapper extends BaseMapper<CmdtyDetails> {

  List<CommodityVO> showCommodity(String cmdty_id);
}
