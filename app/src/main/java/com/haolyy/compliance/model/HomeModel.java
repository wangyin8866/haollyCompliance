package com.haolyy.compliance.model;

import com.haolyy.compliance.entity.home.Banner;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.entity.home.HomeArticle;
import com.haolyy.compliance.entity.home.HomeProduct;
import com.haolyy.compliance.service.HomeAPi;

import rx.Observable;

import static com.haolyy.compliance.config.Config.platform;

/**
 * Created by wangyin on 2017/6/29.
 */

public class HomeModel extends BaseModel {
    private HomeAPi homeAPi;

    private HomeModel() {
        super();
        homeAPi = retrofit.create(HomeAPi.class);
    }

    private static class SingletonHolder {
        private static final HomeModel homeModel = new HomeModel();
    }

    public static HomeModel getInstance() {
        return SingletonHolder.homeModel;
    }

    public Observable<Banner> getBanner(String type) {
        map.clear();
        map.put("type", type);
        map.put("platform", platform);
        return homeAPi.getBanner(map);
    }
    public Observable<HomeProduct> getHomeProduct() {
        return homeAPi.getProduct();
    }
    public Observable<HomeArticle> getHomeArticle() {

        return homeAPi.getArticle(platform);
    }
    public Observable<HomeActivity> getRecommend(String userId) {
        map.clear();
        map.put("userId", userId);
        map.put("client", "1");
        return homeAPi.getRecommend(map);
    }
}
