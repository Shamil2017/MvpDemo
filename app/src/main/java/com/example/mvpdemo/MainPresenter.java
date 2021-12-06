package com.example.mvpdemo;

import android.util.Log;

public class MainPresenter implements MainContract.Presenter {
    private static final String TAG = "MainPresenter";

    //Компоненты MVP приложения
    private MainContract.View mView;
    private MainContract.Repository mRepository;

    //Сообщение
    private String message;

    //Обрати внимание на аргументы конструктора - мы передаем экземпляр View, а Repository просто создаём конструктором.
    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        this.mRepository = new MainRepository();
        Log.d(TAG, "Constructor");
    }

    //View сообщает, что кнопка была нажата
    @Override
    public void onButtonWasClicked() {
        message = mRepository.loadMessage();
        mView.showText(message);
        Log.d(TAG, "onButtonWasClicked()");
    }

    @Override
    public void onDestroy() {
        /**
         * Если бы мы работали например с RxJava, в этом классе стоило бы отписываться от подписок
         * Кроме того, при работе с другими методами асинхронного андроида,здесь мы боремся с утечкой контекста
         */

        Log.d(TAG, "onDestroy()");
    }

}
