package com.github.nesterkin.broadcastreceiverexample;

/**
 * @author Nesterkin Alexander on 15.06.2018
 */
public class MyManager {
    public static final String LOG = MyManager.class.getName();

    private static final MyManager INSTANCE = new MyManager();
    private State mState;

    private MyManager() {
        mState = State.A;
    }

    public static MyManager getInstance() {
        return INSTANCE;
    }

    public String getState() {
        return mState.toString();
    }

    public void changeState() {
        switch (mState) {
            case A: {
                mState = State.B;
                break;
            }
            case B: {
                mState = State.C;
                break;
            }
            case C: {
                mState = State.D;
                break;
            }
            case D: {
                mState = State.E;
                break;
            }
            case E: {
                mState = State.A;
                break;
            }
        }
    }

    enum State {
        A, B, C, D, E;
    }
}