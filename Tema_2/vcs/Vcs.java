package vcs;

import filesystem.FileSystemOperation;
import filesystem.FileSystemSnapshot;
import utils.IDGenerator;
import utils.OutputWriter;
import utils.Visitor;

import java.util.ArrayList;
import java.util.List;

public final class Vcs implements Visitor {
    private final OutputWriter outputWriter;
    private FileSystemSnapshot activeSnapshot;
    private List<String> commandsList;
    private List<Branch> branchList;

    /**
     * Vcs constructor.
     *
     * @param outputWriter the output writer
     */
    public Vcs(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;

    }

    /**
     * Does initialisations.
     */
    public void init() {
        this.activeSnapshot = new FileSystemSnapshot(outputWriter);
        this.commandsList = new ArrayList<>();
        this.branchList = new ArrayList<>();
        this.branchList.add(new Branch("master"));
        //TODO other initialisations
    }

    /**
     * Visits a file system operation.
     *
     * @param fileSystemOperation the file system operation
     * @return the return code
     */
    public int visit(FileSystemOperation fileSystemOperation) {
        return fileSystemOperation.execute(this.activeSnapshot);
    }

    /**
     * Visits a vcs operation.
     *
     * @param vcsOperation the vcs operation
     * @return return code
     */
    @Override
    public int visit(VcsOperation vcsOperation) {
        //TODO
        return vcsOperation.execute(this);
    }

    public List<String> getCommandsList() {
        return commandsList;
    }

    public void setCommandsList(List<String> commandsList) {
        this.commandsList = commandsList;
    }

    public OutputWriter getOutputWriter() {
        return outputWriter;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }


    //TODO methods through which vcs operations interact with this
}
