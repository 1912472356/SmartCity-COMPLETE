package com.cx.smartcity.util;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitUtil {

    private static Context context;
    private static RetrofitService service;

    public static void init(Context context_back){
        context = context_back;
        service = new Retrofit.Builder().baseUrl(SPUtil.get(SPUtil.HTTP)).build().create(RetrofitService.class);
    }

    public interface OnRequest{
        void onRequest(String json);
    }

    public static void get(final String url, final OnRequest onRequest){
        service.get(url, SPUtil.get(SPUtil.TOKEN)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    string = string.replaceAll("/dev-api", "/prod-api");
                    if (url.equals("/prod-api/api/lawyer-consultation/lawyer/list-top10")) {
                        string = string.replaceFirst("data", "rows");
                    }
                    onRequest.onRequest(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                Toast.makeText(context, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static void delete(String url, final OnRequest onRequest){
        service.delete(url, SPUtil.get(SPUtil.TOKEN)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    onRequest.onRequest(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                Toast.makeText(context, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void post(String url, Map map, final OnRequest onRequest){
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), new JSONObject(map).toString());

        service.post(url, SPUtil.get(SPUtil.TOKEN), body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    onRequest.onRequest(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                Toast.makeText(context, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void put(String url, Map map, final OnRequest onRequest){
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), new JSONObject(map).toString());

        service.put(url, SPUtil.get(SPUtil.TOKEN), body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    onRequest.onRequest(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                Toast.makeText(context, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
