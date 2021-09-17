package cn.edu.cqu.letao.service;

import cn.edu.cqu.letao.entity.Cmdty;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * CMDTY 服务类
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
public interface ICmdtyService extends IService<Cmdty> {
    List<Cmdty> findByType(String cmdty_type);

    List<Cmdty> findByName(String cmdty_name);
    List<Cmdty> showAll();
}
