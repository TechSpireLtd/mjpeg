package com.techspire.mjpeglibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by romanborisenko on 29.12.16.
 */

public class MjpegView extends WebView {

    public enum VerticalAlign {
        ALIGN_TOP("top"),
        ALIGN_CENTER("middle"),
        ALIGN_BOTTOM("bottom");

        private String stringValue;

        VerticalAlign(String stringValue) {
            this.stringValue = stringValue;
        }
    }

    private static final String BLACK_BACKGROUND = "black";
    private static final String WIDTH = "width";
    private static final String HEIGHT = "height";

    private VerticalAlign verticalAlign = VerticalAlign.ALIGN_CENTER;
    private String backgroundColor;
    private String url;

    public MjpegView(Context context) {
        super(context);
        initWebView();
    }

    public MjpegView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWebView();
    }

    public MjpegView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initWebView();
    }

    public void setVerticalAlign(VerticalAlign verticalAlign) {
        this.verticalAlign = verticalAlign;
        load();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        backgroundColor = BLACK_BACKGROUND;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSaveFormData(true);
    }

    public void setOverlayColor(String colorString) {
        backgroundColor = colorString;
        load();
    }

    public void loadMjpeg(String url) {
        this.url = url;
        load();
    }

    public void stopLoading() {
        url = "";
        load();
    }

    private void load() {
        String adjustScreen;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            adjustScreen = WIDTH;
        } else {
            adjustScreen = HEIGHT;
        }
        String html = "<html><body style=\"width:100vw;height:100vh;display:table-cell;text-align:center;vertical-align:"
                + verticalAlign.stringValue + "; background:" + backgroundColor + "\"><img src=\"" + url + "\" " + adjustScreen + "=\"100%\" ></body></html>";
        loadData(html, "text/html", null);
    }

}
