package kr.ac.todayis.kr.ac.todayis.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import kr.ac.todayis.R;

public class NetworkModel {

    public static String SERVER_URL = "http://52.69.80.18:888";
    private static String LOG_TAG = "NetworkModel_LOG";

    AsyncHttpClient client;

    private static NetworkModel instance;

    public static NetworkModel getInstance() {
        if (instance == null) {
            instance = new NetworkModel();
        }

        return instance;
    }

    private NetworkModel() {
        client = new AsyncHttpClient();
    }

    public interface OnNetworkResultListener<String> {
        public void onResult(String result);

        public void onFail(int code);
    }

    /*
    * add user
    * personal uid send to server
    *@params : uid
    * return ok;
     */
    public void addUser(String uid, final OnNetworkResultListener<String> listener) {
        String url = SERVER_URL + "/adduser";
        RequestParams param = new RequestParams();
        param.put("uid", uid);

        client.post(url, param, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                //use no gson
                String result = new String(responseBody);
                if (result.equals("ok")) {
                    result = "ok";
                }
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {

            }
        });
    }

    /*
    * add num
    * 5 numbers send to server
    * @params : uid, type, value
    * rule : 00~99
    *       type; num1, num2, num3, num4, num5
    *       value; 01~15
    *
    *       return ok1;
     */

    public void addNum(String uid, final OnNetworkResultListener<String> listener) {
        String url = SERVER_URL + "/addnum";
        RequestParams param = new RequestParams();
        param.put("uid", uid);

        client.post(url, param, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                //use no gson
                String result = new String(responseBody);
                if (result.equals("ok1")) {
                    result = "ok";
                }

                Log.i(LOG_TAG, result);
                listener.onResult(result);

                /*
                //mainActivity
                NetworkModel.OnNetworkResultListener<String>() {

            @Override
            public void onResult(String result) {
                Toast.makeText(MainActivity.this, result,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(int code) {

            }
        });
        */
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {

            }
        });
    }

    /*
    * getnum
    * server send to client
    * @params : uid
    * return json(gson)
    * [{
    "idx": 3,
    "uid": "abcc",
    "num1": null,
    "num2": null,
    "num3": 8,
    "num4": null,
    "num5": 7
                   }]

     */
    public void getnum(String uid, final OnNetworkResultListener<IsSucceed> listener) {
        String url = SERVER_URL + "/getnum";
        RequestParams param = new RequestParams();
        param.put("uid", uid);

        client.get(url, param, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //use gson
                Gson gson = new Gson();
                String result = new String(responseBody);
                Log.i(LOG_TAG, result);
                IsSucceed success = gson.fromJson(result, IsSucceed.class);
                listener.onResult(success);

            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {

            }
        });
    }

}
