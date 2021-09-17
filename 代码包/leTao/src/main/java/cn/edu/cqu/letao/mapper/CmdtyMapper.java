package cn.edu.cqu.letao.mapper;

import cn.edu.cqu.letao.entity.Cmdty;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * CMDTY Mapper 接口
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
public interface CmdtyMapper extends BaseMapper<Cmdty> {
    List<Cmdty> findByType(String cmdty_type);

    List<Cmdty> findByName(String cmdty_name);
    List<Cmdty> showAll();
}
