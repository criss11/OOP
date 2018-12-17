package vcs;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private List<Commit> commitList;

    public Branch(String name) {
        this.name = name;
        this.commitList = new ArrayList<>();
        this.commitList.add(new Commit("First Commit", "this.name"));
    }
}
