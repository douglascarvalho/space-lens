package com.douglas.spacelens.discovery

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.douglas.spacelens.R
import com.douglas.spacelens.injection.injector

class DiscoveryActivity : AppCompatActivity(), DiscoveryContract.View {

    private lateinit var presenter: DiscoveryContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discovery)

        presenter = injector.getDiscoveryPresenter()

        presenter.attach(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.loadImages()
    }

    override fun showImages() {
        Toast.makeText(this, "Nasa API was Called!", Toast.LENGTH_LONG).show()
    }

}
