package pa.senac.br.greencoin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.zip.Inflater;

public class FiqueSabendoFragment extends android.support.v4.app.Fragment {

    //public WebView mWebView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View visao = inflater.inflate(R.layout.fragment_fique_sabendo,null);

        String url = "http://www.prohomeimoveis.com.br/prohome-ambiental/cartilha-reciclagem-de-lixo/";
        WebView view = (WebView)visao.findViewById(R.id.fiqueSabendo);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
        view.setWebViewClient(new MyBrowser());

        return visao;


    }

    private class MyBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        View v=Inflater(R.layout.fragment_fique_sabendo, container, false);
//        mWebView = (WebView) v.findViewById(R.id.fiqueSabendo);
//        mWebView.loadUrl("www.prohomeimoveis.com.br");
//
//
//
//        // Enable Javascript
//        WebSettings webSettings = mWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        // Force links and redirects to open in the WebView instead of in a browser
//        mWebView.setWebViewClient(new WebViewClient());
//
//       return v;

//        WebView myWebView = (WebView)  findViewById(R.id.fiqueSabendo);
//        myWebView.loadUrl("http://www.prohomeimoveis.com.br/prohome-ambiental/cartilha-reciclagem-de-lixo/");
//        WebView webView = (WebView) findViewById(R.id.fiqueSabendo);
//        myWebView.setWebViewClient(new WebViewClient());
//        myWebView = (WebView) findViewById(R.id.fiqueSabendo);
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);

        //AQUI ROLA O CODIGO DA DO FRAGMENT (ACTIVITY)

    }
}
