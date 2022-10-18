package com.deliveryou.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

// singleton
public class ConditionalChain {
    private static ConditionalChain instance;
    private static List<BooleanSupplier> callBacks = new ArrayList<>();
    private static List<BooleanSupplier> redoables = new ArrayList<>();
    private static String chainName;

    private ConditionalChain() {
    }

    public static ConditionalChain begin() {
        return begin("(No-name)");
    }

    public static ConditionalChain begin(String chain_name) {
        clear();
        chainName = "(" + chain_name + ")";
        if (instance == null)
            instance = new ConditionalChain();
        return instance;
    }

    public ConditionalChain then(BooleanSupplier callback) {
        return this.then(callback, () -> true);
    }

    public ConditionalChain then(BooleanSupplier callback, BooleanSupplier redoable) {
        callBacks.add(callback);
        redoables.add(redoable);
        return this;
    }

    private void redo(int index) {
        if (index < 0)
            return;

        System.out.println("[PERFORMING REDO] Chain " + chainName);
        for (int i = index; i >= 0; i--)
            if (!redoables.get(i).getAsBoolean())
                System.out.println("[REDO ERROR] Chain " + chainName + ": Failed to redo at step " + i);
    }

    public boolean finish() {
        for (int i = 0; i < callBacks.size(); i++)
            if (!callBacks.get(i).getAsBoolean()) {
                System.err.println("[ERROR] Chain " + chainName + " stopped at step " + i);
                redo(i - 1);
                return false;
            }
        clear();
        return true;
    }

    public static void clear() {
        callBacks.clear();
        chainName = "(No-name)";
    }
}
