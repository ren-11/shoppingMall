package com.xzy.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;


public class FileUpload {
    //...生成上传凭证，然后准备上传
    private static String accessKey = "8YZ3xpPN4hHsdLveXhe83mjzZj-93-9qQXabNs7n";
    private static String secretKey = "pGCUqZ4IM7L5fuvJgMF-q-VjULhmnzhMM3KP3TK3";
    //存储空间名
    private static String bucket = "bshopmall";
    //外链地址
    private static String url = "http://q5fmzgiry.bkt.clouddn.com/";
    /**
     * 上传图片
     * @param file
     * @return
     */
    public static String upload(String file) throws QiniuException{
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        //构造一个带指定 Region 对象的配置类
        Zone z = Zone.autoZone();
        Configuration cfg = new Configuration(z);
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        try {
            Response response = uploadManager.put(file, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return url+ putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    public static String delete(String key) throws QiniuException{
        Configuration cfg = new Configuration(Region.region0());
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
        System.out.println("删除成功");
        return null;
    }
}
