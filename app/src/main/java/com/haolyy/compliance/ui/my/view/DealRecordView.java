package com.haolyy.compliance.ui.my.view;

import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.ui.my.Bean.DealRecordBean;

/**
 * Created by User on 2017/7/12.
 */

public interface DealRecordView extends BaseView{
    void showData(DealRecordBean dealRecordBean, boolean isRefresh);

}
