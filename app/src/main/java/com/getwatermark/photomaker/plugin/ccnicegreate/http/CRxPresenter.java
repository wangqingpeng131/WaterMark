package com.getwatermark.photomaker.plugin.ccnicegreate.http;

import android.view.ViewGroup;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;


/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public class CRxPresenter implements CBasePresenter {

    protected CIActionListener.ViewAction viewAction;
    private CompositeDisposable compositeSubscription;

    public CRxPresenter(CIActionListener.ViewAction view) {
        addView(view);
    }

    public CIActionListener.ViewAction getBaseView() {
        return viewAction;
    }

    @Override
    public void addView(CIActionListener.ViewAction view) {
        this.viewAction = view;
    }

    @Override
    public void removeView() {
        if (viewAction != null && (viewAction instanceof ViewGroup)) {
            ((ViewGroup) viewAction).removeAllViews();
            viewAction = null;
        }
        unSubscriber();
    }

    protected <T> DisposableObserver<T> addSubscriber(DisposableObserver<T> disposableObserver) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeDisposable();
        }
        compositeSubscription.add(disposableObserver);
        return disposableObserver;
    }

    protected void unSubscriber() {
        if (compositeSubscription != null) {
            compositeSubscription.clear();
        }
    }


}