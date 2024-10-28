package com.artemkot4.infinite_forest.learnings.ui.animation;

import android.graphics.Color;
import com.zhekasmirnov.innercore.api.NativeAPI;
import com.zhekasmirnov.innercore.api.mod.ui.elements.UIElement;
import ru.koshakmine.icstd.ui.Window;
import ru.koshakmine.icstd.ui.elements.ImageElement;
import java.util.Map;

import static java.lang.Thread.sleep;

public class SignAnimation {

    protected static final int FRAME_MAX = 10;
    protected static final double IMAGE_SCALE = 22.5;
    protected static final double HEIGHT_LOCATION = 23.5; //23.5 double
    protected static final int WIDTH_LOCATION = 310;


    protected static final Window UI = new Window();

    protected static void drawSignIcon(String icon) {

        UI.getElements().get("sign_icon").setBinding("bitmap", "sign." + icon);
    }

    protected static void clearSignIcon() {
        UI.getElements().get("sign_icon").setBinding("bitmap", "unknown");
        UI.forceRefresh();
    }

    protected static void changeFrameData(int frame, Number scale, Number x, Number y) {

        if(frame > FRAME_MAX) {
            throw new IllegalArgumentException("SignAnimation: frame can't could be it is number -> " + frame);
        };

        Map<String, UIElement> pull = UI.getElements();

        UIElement current = pull.get("image_background");

        current.setBinding("bitmap","idea_book.book_open_" + frame);
        current.setBinding("x", x);
        current.setBinding("y", y);
        current.setBinding("scale", scale);

    };

    protected static void changeFrameData(int frame, Number scale) {
        UIElement data = UI.getElements().get("image_background");
        changeFrameData(frame, scale, (int)data.getBinding("x"), (int)data.getBinding("y"));
    };

    protected static void changeFrameData(int frame) {
        changeFrameData(frame, (int)IMAGE_SCALE);
    };

    public static void setOffset(Number x, Number y) {

        UIElement data = UI.getElements().get("image_background");
        String texture = (String)data.getBinding("bitmap");
        int scale = (int)data.getBinding("scale");

        changeFrameData(texture.charAt(texture.length() - 1), scale, x, y);

    };

    protected static void open() {
       setOffset(WIDTH_LOCATION, HEIGHT_LOCATION);
       changeFrameData(0);
       UI.open();
    };

    protected static class SignThread implements Runnable {
        protected double x = WIDTH_LOCATION;
        protected double y = HEIGHT_LOCATION;
        protected double scale = (int) IMAGE_SCALE;

        protected int frame = 0;
        protected int timer = 0;
        protected int signIndex = 0;
        protected double alpha = 0;

        protected final int timerMax;
        protected final String[] signList;

        SignThread(String[] signList) {
            this.timerMax = signList.length - 1;
            this.signList = signList;
        }

        ;

        @Override
        public void run() {

            while (y < 1300) {

                try {

                    if (frame < FRAME_MAX && timer <= 0) {
                        frame++;
                        changeFrameData(frame, IMAGE_SCALE);
                        sleep(25);

                    } else {

                        if (timer > timerMax && frame > 0) {

                            clearSignIcon();
                            changeFrameData(frame--, IMAGE_SCALE);
                            sleep(25);
                        }

                        if (timer <= timerMax) {

                            drawSignIcon(signList[signIndex]);

                            if (signIndex < signList.length - 1) {
                                signIndex++;
                            }

                            timer++;
                            sleep(500);

                        } else if (frame <= 0) {

                            if (scale < 15) {

                                if (x < WIDTH_LOCATION * 2.8) {

                                    changeFrameData(0, (scale -= 0.02), (x += 0.98), y);
                                } else {

                                    changeFrameData(0, scale, x, (y += 0.87));
                                    if (y > 250) {

                                        UI.getWindow().layout.setAlpha((float) (alpha -= 0.007));
                                    }
                                }

                            } else {

                                changeFrameData(0, (scale -= 0.3), x, (y += 0.2));
                                sleep(1);
                            }

                            if (y >= 1300) {

                                UI.close();
                                break;
                            }

                            sleep(1);
                        }
                    }

                } catch (Exception error) {

                    NativeAPI.clientMessage("SignThread: error -> " + error);

                    break;
                }
            }
        }

        ;
    }
        public static void init(String[] signList) {
            if (signList != null && !UI.isOpened()) {

                setOffset(WIDTH_LOCATION, HEIGHT_LOCATION);
                changeFrameData(0, IMAGE_SCALE);

                UI.open();

                new Thread(new SignThread(signList)).run();
            }

        }


        public static void init(String signList) {
            init(new String[]{signList});
        }

        public static Window getWindow() {
            return UI;
        }

        static {
            UI.putElement("image_background", new ImageElement(
                    "idea_book.book_open_0",
                    WIDTH_LOCATION,
                    (int) HEIGHT_LOCATION, 100, 100));

            UI.putElement("sign_icon", new ImageElement(
                    "unknown",
                    WIDTH_LOCATION + 25,
                    (int) HEIGHT_LOCATION + 110, 100, 100));


            UI.setBackgroundColor(Color.argb(0, 0, 0, 0));

            UI.setAsGameOverlay(true);
            UI.setTouchable(false);
            UI.setBlockingBackground(true);
        }
};
