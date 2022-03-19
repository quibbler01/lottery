package cn.quibbler.lottery.utils;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import android.widget.TextView;

import java.util.List;

public class TextSwitcherAnimation {
    private static final int DURATION = 1000;

    private TextSwitcher textSwitcher;
    private List<String> texts;
    private int marker;
    private AnimationSet InAnimationSet;
    private AnimationSet OutAnimationSet;

    private int delayTime = 2000;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable task = new Runnable() {
        @Override
        public void run() {
            nextView();
            handler.postDelayed(task, delayTime * 2);
        }
    };

    public TextSwitcherAnimation(TextSwitcher textSwitcher, List<String> texts) {
        this.textSwitcher = textSwitcher;
        this.texts = texts;
    }

    public void start() {
        stop();
        handler.postDelayed(task, delayTime);
    }

    public void stop() {
        handler.removeCallbacks(task);
    }

    public int getMarker() {
        return marker;
    }

    public TextSwitcherAnimation setTexts(List<String> texts) {
        this.texts = texts;
        return this;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    public void create() {
        marker = 0;
        if (texts == null) {
            Log.w("TextSwitcherAnimation", "texts is null");
            return;
        }
        if (textSwitcher == null) {
            Log.w("TextSwitcherAnimation", "textSwitcher is null");
            return;
        }
        textSwitcher.setText(texts.get(0));
        createAnimation();
        textSwitcher.setInAnimation(InAnimationSet);
        textSwitcher.setOutAnimation(OutAnimationSet);
        start();
    }

    private void createAnimation() {
        AlphaAnimation alphaAnimation;
        TranslateAnimation translateAnimation;

        int h = textSwitcher.getHeight();
        if (h <= 0) {
            textSwitcher.measure(0, 0);
            h = textSwitcher.getMeasuredHeight();
        }

        InAnimationSet = new AnimationSet(true);
        OutAnimationSet = new AnimationSet(true);

        alphaAnimation = new AlphaAnimation(0, 1);
        translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, h, Animation.ABSOLUTE, 0);
        InAnimationSet.addAnimation(alphaAnimation);
        InAnimationSet.addAnimation(translateAnimation);
        InAnimationSet.setDuration(DURATION);

        alphaAnimation = new AlphaAnimation(1, 0);
        translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -h);
        OutAnimationSet.addAnimation(alphaAnimation);
        OutAnimationSet.addAnimation(translateAnimation);
        OutAnimationSet.setDuration(DURATION);
    }

    private void nextView() {
        marker = ++marker % texts.size();
        TextView textView = (TextView) textSwitcher.getNextView();
        textView.setTextColor(marker % 2 == 0 ? Color.RED : Color.BLACK);
        textSwitcher.setText(texts.get(marker));
    }

}