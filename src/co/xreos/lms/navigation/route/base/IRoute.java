package co.xreos.lms.navigation.route.base;

public interface IRoute {
    public void generate();
    public void dispose();
    public boolean isTransient();
}
