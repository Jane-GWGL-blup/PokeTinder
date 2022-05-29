package com.caceres.poketinder.ui.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.caceres.poketinder.databinding.FragmentInfoBinding
import com.caceres.poketinder.ui.viewmodel.InfoViewModel

class InfoFragment:BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {
    private lateinit var viewModel: InfoViewModel
    private lateinit var webview: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = "https://pokemongolive.com/es/"
        webview =binding.wvMain
        webview!!.settings.javaScriptEnabled=true
        webview!!.webViewClient = PokemonWebClient()
        webview!!.loadUrl(url)
    }
    inner class PokemonWebClient: WebViewClient(){
        override fun onPageFinished(view: WebView?, url: String?) {
            webview!!.loadUrl("javascript:(function(){"+
                    "document.getElementsByClassName('navbar top')[0].style.display='none';})()");
        }
    }

   override fun onPause() {
        super.onPause()
        webview!!.settings.javaScriptEnabled=false
        webview!!.onPause()
       // webview.pauseTimers()
    }

    override fun onResume() {
        super.onResume()
        webview!!.onResume()
    }
}