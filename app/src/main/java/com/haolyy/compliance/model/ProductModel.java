package com.haolyy.compliance.model;

import com.haolyy.compliance.entity.ProductList;
import com.haolyy.compliance.service.ProductApi;

import rx.Observable;

/**
 * Created by LL on 2017/1/7.
 */

public class ProductModel extends BaseModel {
    private ProductApi productApi;
    private static ProductModel userModel;

    public ProductModel() {
        super();
        //手动创建一个OkHttpClient并设置超时时间
//        retrofit = new Retrofit.Builder()
//                .client(httpClientBuilder.build())
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .baseUrl(NetConstantValues.HOST_URL)
//                .build();
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

    public Observable<ProductList> getProductList(String product_category_id, String status, String return_rate, String date_limit, String page_index, String platform) {
        map.put("product_category_id", product_category_id);
        map.put("status", status);
        map.put("return_rate", return_rate);
        map.put("date_limit", date_limit);
        map.put("page_index", page_index);
        map.put("platform", platform);
        return productApi.getProductList(map);
    }

    public Observable<String> getBaseDetail(String id, String juid) {
        map.put("id", id);
        map.put("juid", juid);
        return productApi.getBaseDetail(map);

    }
    public Observable<String> getDetail(String id, String juid,String project_type,String product_no) {
        map.put("id", id);
        map.put("juid", juid);
        map.put("project_type", project_type);
        map.put("product_no", product_no);
        return productApi.getDetail(map);

    }
}
