package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.entity.my.MessageBean;
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
    public Observable<MessageBean> getMessage(String page_index){
        map.clear();
        map.put("platform", Config.platform);
        map.put("user_id", BaseApplication.userId+"");
        map.put("page_index", page_index);
        map.put("mobile", BaseApplication.mUserName);
        return myApi.getMessage(map);
    }
    public Observable<BaseBean> modificationStatus(int id, int status){
        map.clear();
        map.put("id", id+"");
        map.put("status", status+"");
        return myApi.modificationStatus(map);
    }
}
