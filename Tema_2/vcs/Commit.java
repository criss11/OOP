package vcs;

import utils.IDGenerator;

public class Commit {
    private String name;
    private int ID;

    public Commit(String name, String branchName) {
        this.name = name;
        this.ID = IDGenerator.generateFileID();

    }

}
