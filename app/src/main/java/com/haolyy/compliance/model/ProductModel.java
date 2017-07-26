package com.haolyy.compliance.model;

import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.entity.product.Earnings;
import com.haolyy.compliance.entity.product.Invest;
import com.haolyy.compliance.entity.product.InvestLog;
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
import static com.haolyy.compliance.config.Config.returl;

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
        map.put("productCategoryId", product_category_id);
        map.put("pageIndex", page_index);
        map.put("platform", platform);
        map.put("client", client);
        return productApi.getProductList(map);
    }

    public Observable<ProductBaseDetail> getBaseDetail(String project_no, String juid) {
        map.clear();
        map.put("projectNo", project_no);
        map.put("platform", platform);
        map.put("juid", juid);
        return productApi.getBaseDetail(map);

    }
    public Observable<InvestLog> getInvestmentRecord(String borrowNid, String pageIndex) {
        map.clear();
        map.put("borrowNid", borrowNid);
        map.put("pageIndex", pageIndex);
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
    public Observable<Earnings> getEarnings(String amount,String rate,String timeType,String termTime,String borrowType){
        map.clear();
        map.put("amount",amount);
        map.put("rate", rate);
        map.put("timeType", timeType);
        map.put("termTime", termTime);
        map.put("borrowType", borrowType);
        return productApi.getEarnings(map);
    }
    public Observable<Invest> invest(String projectNo, String userId, String amount, String expectedRevenue, String return_url){
        map.clear();
        map.put("projectNo",projectNo);
        map.put("userId", userId);
        map.put("amount", amount);
        map.put("expectedRevenue", expectedRevenue);
        map.put("return_url", returl);
        map.put("platform", platform);
        map.put("client", client);
        return productApi.invest(map);
    }
}
