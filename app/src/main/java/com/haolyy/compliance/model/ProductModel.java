package com.haolyy.compliance.model;

import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.entity.product.ProductList;
import com.haolyy.compliance.entity.product.ProductTitle;
import com.haolyy.compliance.entity.product.RepaymentPlan;
import com.haolyy.compliance.service.ProductApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by LL on 2017/1/7.
 */

public class ProductModel extends BaseModel {
    private ProductApi productApi;
    private static ProductModel userModel;

    public ProductModel() {
        super();
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(NetConstantValues.HOST_URL)
                .build();
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
    public Observable<ProductTitle> getTitle(String platform, String client){
        map.clear();
        map.put("platform", platform);
        map.put("client", client);
        return productApi.getTitleList(map);
    }
    public Observable<ProductList> getProductList(String product_category_id, String status, String return_rate, String date_limit, String page_index, String platform) {
        map.clear();
        map.put("product_category_id", product_category_id);
        map.put("status", status);
        map.put("return_rate", return_rate);
        map.put("date_limit", date_limit);
        map.put("page_index", page_index);
        map.put("platform", platform);
        return productApi.getProductList(map);
    }

    public Observable<ProductBaseDetail> getBaseDetail(String project_no, String juid) {
        map.clear();
        map.put("project_no", project_no);
        map.put("juid", juid);
        return productApi.getBaseDetail(map);

    }
    public Observable<String> getDetail(String id, String juid,String project_type,String product_no) {
        map.clear();
        map.put("project_no", id);
        map.put("juid", juid);
        map.put("project_type", project_type);
        map.put("product_no", product_no);
        return productApi.getDetail(map);

    }
    public Observable<String> getInvestmentRecord(String projectNo, String pageIndex,String platform,String client,String version) {
        map.clear();
        map.put("project_no", projectNo);
        map.put("page_index", pageIndex);
        map.put("platform", platform);
        map.put("client", client);
        map.put("version", version);
        return productApi.getInvestmentRecord(map);

    }
    public Observable<RepaymentPlan> getProductReturnPlan(String projectNo, String pageIndex, String platform, String client) {
        map.clear();
        map.put("project_no", projectNo);
        map.put("page_index", pageIndex);
        map.put("platform", platform);
        map.put("client", client);
        return productApi.getProductReturnPlan(map);

    }
}
