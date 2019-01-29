package serviceImpl;

import entity.Items;
import entity.ItemsCustom;
import entity.ItemsQueryVo;
import exception.CustomException;
import mapper.ItemsMapper;
import mapper.ItemsMapperCustom;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import service.ItemsService;

import java.util.List;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: serviceImpl
 * @Author: yang
 * @CreateTime: 2019-01-18 14:52
 * @Description: ${Description}
 */
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items=itemsMapper.selectByPrimaryKey(id);
        if(items ==null){
            throw new CustomException("修改商品信息不存在");
        }
        // 中间对商品进行业务处理
        //
        //返回ItemsCustom
        ItemsCustom itemsCustom=new ItemsCustom();
        if(items !=null) {
            itemsCustom = new ItemsCustom();

            //将items的属性值拷贝到itemsCustom
            BeanUtils.copyProperties(items, itemsCustom);
        }
        return itemsCustom;
    }

    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        // 提那家业务校验，通常在service接口对关键字参数进行校验
        // 校验id是否为空，如果为空抛出异常

        //更新商品信息 使用updateByExampleWithBLOBs根据id更新items表中所有字段，包括打文本类型，
        //updateByExampleWithBLOBs要求必须传入id
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }

    public void deleteItems(Integer[] items_id) throws Exception {

        for (Integer item_id :items_id){
            itemsMapper.deleteByPrimaryKey(item_id);
        }

    }


}
