package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.sxr.com.mainmodule.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class BigImgTestFragment extends Fragment {

    WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.big_img_fragment, container, false);
        try {
            initWebView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void initWebView(View root) throws Exception {
        mWebView = root.findViewById(R.id.img_wv);
        loadImgByHtml();
    }

    private void loadImgByHtml() {
        try {
            StringBuffer htmlBuffer = new StringBuffer();
            InputStream inputStream = getActivity().getAssets().open("test_intro.html");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String s = "";
            while ((s = reader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                htmlBuffer.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            }
            reader.close();

            String html = htmlBuffer.toString();
            html = html.replace("{IMAGE_PLACEHOLDER}", "./tenacy_intro.png");

            mWebView.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "utf-8", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
