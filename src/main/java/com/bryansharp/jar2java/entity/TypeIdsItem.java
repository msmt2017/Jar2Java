package com.bryansharp.jar2java.entity;

import com.bryansharp.jar2java.LogUtils;
import com.bryansharp.jar2java.entity.base.DexData;
import com.bryansharp.jar2java.entity.base.DexDataItem;

import java.util.Map;

/**
 * Created by bsp on 17/3/18.
 */
public class TypeIdsItem extends IntRefsItem {
    public TypeIdsItem(String name) {
        super(name);
    }

    @Override
    protected void parse1stRealData(Map<String, DexDataItem> dataItems, byte[] dexData) {
        StringIdsItem dexDataItem = (StringIdsItem) dataItems.get(DexData.STRING_IDS);
        realData = new String[refs.length];
        for (int i = 0; i < realData.length; i++) {
            Integer ref = refs[i];
            realData[i] = dexDataItem.realData[ref];
        }
    }
    @Override
    public void printData() {
        LogUtils.log(name + " : byteSize is " + byteSize + " : count is " + byteSize / 4 + " : data is :");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < refs.length; i++) {
            stringBuilder.append(i).append(",").append(refs[i]).append(",");
            if (realData != null) {
                stringBuilder.append(realData[i]).append("|");
            }
        }
        LogUtils.log(stringBuilder.toString());
    }
}
