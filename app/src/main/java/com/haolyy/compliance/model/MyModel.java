package com.haolyy.compliance.model;

import com.haolyy.compliance.entity.my.ProductFund;
import com.haolyy.compliance.entity.my.ProductFundList;
import com.haolyy.compliance.service.MyApi;

import rx.Observable;

/**
 * Created by wangyin on 2017/7/15.
 */

public class MyModel extends BaseModel {
    private MyApi myApi;
    private MyModel() {
        super();
        myApi = retrofit.create(MyApi.class);
    }
    private static class SingletonHolder {
        private static final MyModel model=new MyModel();
    }
    public static MyModel getInstance(){
        return SingletonHolder.model;
    }

    public Observable<ProductFund> getProductFunds(String platform,String user_id){
        map.clear();
        map.put("platform", platform);
        map.put("user_id", user_id);
        return myApi.getProductFunds(map);
    }

    public Observable<ProductFundList> assetManagementList(String userId, String platform, String client, String firstCategoryId, String secondCategoryId, String pageIndex, String orderStatus) {
        map.clear();
        map.put("userId", userId);
        map.put("platform", platform);
        map.put("client", client);
        map.put("firstCategoryId", firstCategoryId);
        map.put("secondCategoryId", secondCategoryId);
        map.put("pageIndex", pageIndex);
        map.put("orderStatus", orderStatus);
        return myApi.assetManagementList(map);
    }
}
