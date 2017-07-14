package com.haolyy.compliance.ui.my.view;

import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.ProductRatioBean;
import com.haolyy.compliance.entity.home.FundStatictisIncomeBean;

/**
 * Created by User on 2017/7/12.
 */

public interface FundStatictisView {


    void showData(FundStatictisIncomeBean fundStatictisIncomeBean);

    void showRatio(ProductRatioBean.ModelBeanX.ModelBean productRatioBean);

}
