package com.haolyy.compliance.ui.product.view;

import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.product.RepaymentPlan;

/**
 * Created by wangyin on 2017/7/1.
 */

public interface RepaymentPlanView extends BaseView{
    void showData(RepaymentPlan repaymentPlan);
    void showGetMoreData(RepaymentPlan repaymentPlan);
}
