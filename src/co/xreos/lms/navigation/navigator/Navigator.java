package co.xreos.lms.navigation.navigator;

import co.xreos.lms.navigation.route.base.IRoute;
import co.xreos.lms.navigation.route.base.NamedRoute;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Navigator {
    private static Navigator instance;

    public static void initialize(IRoute root) {
        initialize(root, true);
    }

    public static void initialize(IRoute root, boolean activate) {
        initialize(root, activate, List.of());
    }

    public static void initialize(List<NamedRoute> namedRoutes) {
        if(namedRoutes.isEmpty()) throw new IllegalArgumentException("Named routes cannot be empty when initializing with named route list.");
        initialize(namedRoutes.get(0), true, namedRoutes);
    }

    public static void initialize(IRoute root, boolean activate, List<NamedRoute> namedRoutes) {
        instance = new Navigator();
        instance.push(root);
        for (NamedRoute route : namedRoutes) {
            instance.registerNamedRoute(route);
        }
        if (activate) instance.activate();
    }

    public static Navigator getInstance() {
        if(instance == null) throw new IllegalStateException("Navigator not initialized");
        return instance;
    }

    private final Stack<IRoute> stack = new Stack<>();
    private final HashMap<String, IRoute> routes = new HashMap<>();

    public void registerNamedRoute(NamedRoute route) {
        routes.put(route.getId(), route);
    }

    public void reset() {
        for (IRoute route : stack) {
            route.dispose();
        }
        stack.clear();
    }

    public void push(IRoute route) {
        System.out.println("Pushing route: " + route);
        if(route == null) throw new IllegalArgumentException("Route cannot be null. If you are using pushNamed, make sure you use the correct route id.");
        if (!route.isTransient()) deactivateLast();
        if(!stack.isEmpty() && stack.peek().isTransient()) pop();
        stack.push(route);
        activateLast();
    }

    public void pop() {
        if (stack.isEmpty()) return;
        IRoute popped = stack.pop();
        popped.dispose();
        if(!popped.isTransient()) activateLast();
    }

    public void pushNamed(String id) {
        push(routes.get(id));
    }

    public void popAndPushNamed(String id) {
        pop();
        pushNamed(id);
    }

    private void deactivateLast() {
        if (!stack.isEmpty()) {
            stack.peek().dispose();
        }
    }

    private void activateLast() {
        if (!stack.isEmpty()) {
            stack.peek().generate();
        }
    }

    public void activate() {
        if(stack.isEmpty()) throw new IllegalStateException("No routes to activate");
        stack.peek().generate();
    }
}
