package mapper;

import entity.ItemsCustom;
import entity.ItemsQueryVo;

import java.util.List;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: mapper
 * @Author: yang
 * @CreateTime: 2019-01-18 14:26
 * @Description: ${Description}
 */
public interface ItemsMapperCustom {

    // 商品的查询列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws  Exception;
}
