package entity;

import java.util.List;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: entity
 * @Author: yang
 * @CreateTime: 2019-01-18 14:32
 * @Description: 商品查询
 */
public class ItemsQueryVo {

    //商品信息

    private Items items;
    private ItemsCustom itemsCustom;
    // 批量商品信息
    private List<ItemsCustom> itemsList;


    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }


    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }



    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }



}
