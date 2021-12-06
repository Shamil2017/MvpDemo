package com.example.mvpdemo;

public interface MainContract {
    interface View {
        void showText(String message);
    }

    interface Presenter {
        void onButtonWasClicked();
        void onDestroy();
    }

    interface Repository {
        String loadMessage();
    }
}
