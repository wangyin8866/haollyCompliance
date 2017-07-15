package com.haolyy.compliance.model;

import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.entity.product.ProductList;
import com.haolyy.compliance.entity.product.ProductTitle;
import com.haolyy.compliance.entity.product.RepaymentPlan;
import com.haolyy.compliance.service.ProductApi;
import com.haolyy.compliance.ui.my.Bean.AssetRatioBean;

import rx.Observable;

import static com.haolyy.compliance.base.BaseApplication.version;
import static com.haolyy.compliance.config.Config.client;
import static com.haolyy.compliance.config.Config.platform;

/**
 * Created by LL on 2017/1/7.
 */

public class ProductModel extends BaseModel {
    private ProductApi productApi;
    private static ProductModel userModel;

    public ProductModel() {
        super();
        productApi = retrofit.create(ProductApi.class);
    }


    public static ProductModel getInstance() {
        if (userModel == null) {
            synchronized (ProductModel.class) {
                if (userModel == null) {
                    userModel = new ProductModel();
                }
            }
        }
        return userModel;
    }
    public Observable<ProductTitle> getTitle(){
        map.clear();
        map.put("platform", platform);
        map.put("client", client);
        return productApi.getTitleList(map);
    }
    public Observable<ProductList> getProductList(String product_category_id, String page_index) {
        map.clear();
        map.put("product_category_id", product_category_id);
        map.put("page_index", page_index);
        map.put("platform", platform);
        map.put("client", client);
        return productApi.getProductList(map);
    }

    public Observable<ProductBaseDetail> getBaseDetail(String project_no, String juid) {
        map.clear();
        map.put("project_no", project_no);
        map.put("platform", platform);
        map.put("juid", juid);
        return productApi.getBaseDetail(map);

    }
    public Observable<String> getInvestmentRecord(String projectNo, String pageIndex) {
        map.clear();
        map.put("project_no", projectNo);
        map.put("page_index", pageIndex);
        map.put("platform", platform);
        map.put("client", client);
        map.put("version", version);
        return productApi.getInvestmentRecord(map);

    }
    public Observable<RepaymentPlan> getProductReturnPlan(String projectNo, String pageIndex) {
        map.clear();
        map.put("project_no", projectNo);
        map.put("page_index", pageIndex);
        map.put("platform", platform);
        map.put("client", client);
        return productApi.getProductReturnPlan(map);

    }

    public Observable<AssetRatioBean> getUserProductInfo(String platform, String user_id){
        map.clear();
        map.put("user_id",user_id);
        map.put("platform", platform);
        return productApi.getUserProductInfo(map);
    }
}
