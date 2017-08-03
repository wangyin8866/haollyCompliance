package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.config.NetConstantValues;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import rx.Observable;

/**
 * Created by niudeyang on 2017/8/3.
 * 图片上传
 */

public class UpLoadMolel extends BaseModel {
    private GoodsReturnApiService goodsReturnApiService;
    private static UpLoadMolel upLoadMolel;

    public UpLoadMolel() {
        super();
        goodsReturnApiService = retrofit.create(GoodsReturnApiService.class);
    }

    public static UpLoadMolel getInstance() {
        if (upLoadMolel == null) {
            synchronized (UpLoadMolel.class) {
                if (upLoadMolel == null) {
                    upLoadMolel = new UpLoadMolel();
                }
            }
        }
        return upLoadMolel;
    }

    public Observable<BaseBean> beginUpLoad() {
        Map<String, RequestBody> params = new HashMap<>();
        //以下参数是伪代码，参数需要换成自己服务器支持的
        params.put("type", convertToRequestBody("type"));
        params.put("time", convertToRequestBody("time"));

        List<File> fileList = new ArrayList<>();

        fileList.add(new File("Uri uri1"));
        fileList.add(new File("Uri uri2"));
        List<MultipartBody.Part> partList = filesToMultipartBodyParts(fileList);

        return goodsReturnApiService.postGoodsReturnPostEntitys(params, partList);
    }

    /**
     * 将文件（图片）请求头的content-type使用方法filesToMultipartBodyParts()对其赋值"image/png"，并返回MultipartBody.Part集合。
     *
     * @param files
     * @return
     */
    private List<MultipartBody.Part> filesToMultipartBodyParts(List<File> files) {
        List<MultipartBody.Part> parts = new ArrayList<>(files.size());
        for (File file : files) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("multipartFiles", file.getName(), requestBody);
            parts.add(part);
        }
        return parts;
    }

    /**
     * 因为GsonConverterFactory.create()转换器的缘故，会将参数请求头的content-type值默认赋值application/json，如果没有进行这步转换操作，就可以在OKHttp3的日志拦截器中查看到这样的赋值，
     * 这样导致服务器不能正确识别参数，导致上传失败，所以这里需要对参数请求头的content-type设置一个正确的值：text/plain。
     * <p>
     * 8
     */
    private RequestBody convertToRequestBody(String param) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), param);
        return requestBody;
    }

    public interface GoodsReturnApiService {
        @Multipart
        @POST(NetConstantValues.REBIND_PHONE)
            //这里是自己post文件的地址
        Observable<BaseBean> postGoodsReturnPostEntitys(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);
    }

}
