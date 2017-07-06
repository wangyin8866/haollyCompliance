package com.haolyy.compliance.ui.home.view;

import com.haolyy.compliance.entity.home.Banner;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.entity.home.HomeArticle;
import com.haolyy.compliance.entity.home.HomeProduct;

/**
 * Created by wangyin on 2017/5/17.
 */

public interface HomeLoginView {
    void showBannerData(Banner banner);

    void showHomeActivityData(HomeActivity homeActivity);

    void showHomeArticleData(HomeArticle homeArticle);

    void showHomeProductData(HomeProduct homeProduct);
}
