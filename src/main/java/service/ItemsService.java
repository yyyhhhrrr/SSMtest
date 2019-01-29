package service;

import entity.Items;
import entity.ItemsCustom;
import entity.ItemsQueryVo;

import java.util.List;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: service
 * @Author: yang
 * @CreateTime: 2019-01-18 14:50
 * @Description: ${Description}
 */
public interface ItemsService {

    // 商品的查询列表

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    // 根据Id查询商品信息
    public ItemsCustom findItemsById(Integer id) throws Exception;

    //更改商品信息
    public void updateItems(Integer id, ItemsCustom itemsCustom)throws Exception;

   //批量删除
    public void deleteItems(Integer[] items_id) throws Exception;
}
