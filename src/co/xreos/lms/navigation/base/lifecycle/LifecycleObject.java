package co.xreos.lms.navigation.base.lifecycle;

public interface LifecycleObject {
    public void activate();
    public void deactivate();
    public void onCreate();
    public void onDestroy();
}
