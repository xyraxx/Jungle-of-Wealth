package dev.fs.mad.game12.libs;

import android.content.Context;

public interface IWebView {
    Context getContext();

    void loadUrl(String url);
}
