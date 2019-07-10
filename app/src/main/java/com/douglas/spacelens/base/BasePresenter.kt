package com.douglas.spacelens.base

interface BasePresenter<in T> {

    fun attach(view: T)
    fun detach()

}