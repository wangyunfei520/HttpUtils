package cn.wyf.httptest;

import android.media.AudioManager;
import android.util.Log;

import net.wyf.library.utils.log.XLogger;

import cn.wyf.httptest.application.App;
import cn.yunzhisheng.tts.offline.TTSPlayerListener;
import cn.yunzhisheng.tts.offline.basic.ITTSControl;
import cn.yunzhisheng.tts.offline.basic.TTSFactory;

/**
 * 离线语音合成
 */
public class SpeekUtilOffline {
    public static final String appKey = "_appKey_";
    public static final String  secret = "_secret_";
    private ITTSControl mTTSPlayer;
    private boolean voicerunning = false;

    public SpeekUtilOffline(){
        init();
    }

    private void init(){
        mTTSPlayer = TTSFactory.createTTSControl(App.getIntstance(), appKey);
        mTTSPlayer.setStreamType(AudioManager.STREAM_MUSIC);//
        //mTTSPlayer.setVoiceVolume(arg0);
        mTTSPlayer.setVoiceSpeed(2.5f);//
        mTTSPlayer.setVoicePitch(1.1f);//
        mTTSPlayer.init();//
        mTTSPlayer.setTTSListener(new TTSPlayerListener() {
            @Override
            public void onPlayEnd() {
                Log.i("msg", "onPlayEnd");
                voicerunning = false;
            }

            @Override
            public void onPlayBegin() {
                Log.i("msg", "onPlayBegin");
                voicerunning = true;
            }

            @Override
            public void onInitFinish() {
                Log.i("msg", "onInitFinish");
            }

            @Override
            public void onError(cn.yunzhisheng.tts.offline.common.USCError arg0) {
                Log.i("msg", "onError："+ arg0.msg);
                voicerunning = false;
            }

            @Override
            public void onCancel() {
                Log.i("msg", "onCancel");
                voicerunning = false;
            }

            @Override
            public void onBuffer() {
                Log.i("msg", "onBuffer");

            }
        });
    }

    public boolean GetReadFlag()
    {
        return voicerunning;
    }

    public void stop(){
        mTTSPlayer.stop();
    }

    /**
     * 语音合成播报
     * @param content
     */
    public void speek(final String content) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                voicerunning = true;
                try {
                    Thread.sleep(800);//等0.8秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                XLogger.v("play:" + content);
                mTTSPlayer.play(content);
            }
        }).start();

    }

    public void release() {
        mTTSPlayer.release();
    }

    private static SpeekUtilOffline speekUtilOffline;

    public static SpeekUtilOffline getInstance() {
        if (speekUtilOffline == null) {
            synchronized (SpeekUtilOffline.class) {
                if (speekUtilOffline == null) {
                    speekUtilOffline = new SpeekUtilOffline();
                }
            }
        }
        return speekUtilOffline;
    }

}
