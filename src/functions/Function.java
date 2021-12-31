package src.functions;

import src.builders.Complexe;

public abstract class Function<E> {
    private final E argument;

    public Function(){
        argument = requestArg();
    }

    public E getArgument() {
        return argument;
    }

    public abstract E requestArg();

    public abstract Complexe calculate(Complexe z);
}
