/**
 * Company
 * Copyright (C) 2004-2016 All Rights Reserved.
 */
package cn.ylapl.util;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author yangle
 * @version $Id HttpClientByYL.java, v 0.1 2016-11-04 上午11:02 yangle Exp $$
 */
public class HttpClientByYL {
    /**
     * 连接池的最大连接数400
     */
    private static final int  MAX_CONNECTION = 400;
    /**
     * 对于同一个目标机器可以支持的最大路由数300
     */
    private static final int MAX_ROUTE_NUM = 300;

    private static String UTF_8 = "UTF-8";

    private static Logger logger = LoggerFactory.getLogger(HttpClientByYL.class);

    //静态内部类保证单例
    private static final class SignCm {

        private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

        //初始化httpclient路由参数
        static {
            cm = new PoolingHttpClientConnectionManager();
            cm.setMaxTotal(MAX_CONNECTION);// 整个连接池最大连接数
            cm.setDefaultMaxPerRoute(MAX_ROUTE_NUM);// 每路由最大连接数，默认值是2
        }

        private static PoolingHttpClientConnectionManager getCm() {
            return cm;
        }
    }

    /**
     * 通过连接池获取HttpClient
     */
    private static CloseableHttpClient getHttpClient() {
        return HttpClients.custom().setRedirectStrategy(new DefaultRedirectStrategy() {
            public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context) {
                boolean isRedirect = false;
                try {
                    isRedirect = super.isRedirected(request, response, context);
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }
                if (!isRedirect) {
                    int responseCode = response.getStatusLine().getStatusCode();
                    if (responseCode == 301 || responseCode == 302) {
                        return true;
                    }
                }
                return isRedirect;
            }
        }).setConnectionManager(SignCm.getCm()).build();
    }

    /**
     * get方法提交参数
     * @param url url
     * @return 返回结果
     */
    public static String httpGetRequest(String url) {
        HttpGet httpGet = new HttpGet(url);
        return getResult(httpGet);
    }

    /**
     * get方法提交参数，设置参数
     * @param url url
     * @param params 参数
     * @return 返回值
     */
    public static String httpGetRequest(String url, Map<String, String> params) {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);

        HttpGet httpGet;
        try {
            httpGet = new HttpGet(ub.build());
        } catch (URISyntaxException e) {
            logger.error("URL语法错误,url:{},params:{}", url, params);
            return null;
        }
        return getResult(httpGet);
    }

    /**
     * get方法提交参数，设置请求头，设置参数
     * @param url       url
     * @param headers   头部
     * @param params    参数
     * @return          http请求返回值
     */
    public static String httpGetRequest(String url, Map<String, String> headers, Map<String, String> params) {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);

        HttpGet httpGet;
        try {

            httpGet = new HttpGet(ub.build());
        } catch (URISyntaxException e) {
            logger.error("URL语法错误,url:{},params:{},headers:{}", url, params, headers);
            return null;
        }

        for (Map.Entry<String, String> param : headers.entrySet()) {
            httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }

        return getResult(httpGet);
    }

    /**
     * post访问url，无参数
     * @param url   url
     * @return      返回值
     */
    public static String httpPostRequest(String url) {
        HttpPost httpPost = new HttpPost(url);
        return getResult(httpPost);
    }

    /**
     * 用post进行提交参数，不设置请求头
     * @param url       url
     * @param params    参数
     * @return          返回值
     */
    public static String httpPostRequest(String url, Map<String, String> params) {

        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);

        try {

            httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        } catch (UnsupportedEncodingException e) {

            logger.error("url编码错误,url:{},params:", url, params);
            return null;
        }
        return getResult(httpPost);
    }

    /**
     * 使用post方法提交json数据
     * @param url   url
     * @param obj   json数据
     * @return      返回值
     */
    public static String httpPostRequestFromJson(String url, String obj) {
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(obj, "utf-8");
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        return getResult(httpPost);
    }

    /**
     *  进行post方法进行请求，用utf-8进行编码
     * @param url       url
     * @param headers 头部信息
     * @param params  请求参数
     * @return          返回值
     */
    public static String httpPostRequest(String url, Map<String, String> headers, Map<String, String> params) {

        HttpPost httpPost = new HttpPost(url);

        for (Map.Entry<String, String> param : headers.entrySet()) {
            httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        } catch (UnsupportedEncodingException e) {
            logger.error("参数编码错误,url:{},headers:{},params:{}", url, headers, params);
            return null;
        }

        return getResult(httpPost);
    }

    /**
     * 将http请求所需的参数进行url编码
     * @param params 参数
     * @return      编码后的参数list
     */
    private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, String> params) {

        ArrayList<NameValuePair> pairs = new ArrayList<>();

        for (Map.Entry<String, String> param : params.entrySet()) {

            pairs.add(new BasicNameValuePair(param.getKey(), param.getValue()));
        }

        return pairs;
    }

    /**
     * 处理Http请求
     */
    private static String getResult(HttpRequestBase request) {

        HttpEntity entity = null;

        try( CloseableHttpClient httpClient = getHttpClient();
             CloseableHttpResponse response = httpClient.execute(request) ) {

            entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        } catch (IOException e) {

            logger.error("http请求IO错误，");
            return null;

        } finally {

            if(entity != null) {
                try {

                    EntityUtils.consume(entity);
                } catch (IOException e) {

                    logger.error("httpentity关闭失败！");
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

}