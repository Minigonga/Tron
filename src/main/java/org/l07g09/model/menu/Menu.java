package org.l07g09.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int entry = 0;

    public Menu() {
        this.entries = Arrays.asList("Start", "Instructions", "Exit");
    }

    public void nextEntry() {
        entry++;
        if (entry > this.entries.size() - 1)
            entry = 0;
    }

    public void previousEntry() {
        entry--;
        if (entry < 0)
            entry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return entry == i;
    }

    public boolean isExit() {
        return isSelected(2);
    }
    public boolean isInstructions() {return isSelected(1);}
    public boolean isStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
