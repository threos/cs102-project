package co.xreos.lms.navigation.pipeline;

public interface Pipe<I, O> {
    public O process(I input);
    public void dispose();
}
