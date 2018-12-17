package vcs;

import utils.OperationType;

import java.util.ArrayList;

public class CommitOperation extends VcsOperation {
    /**
     * Vcs operation constructor.
     *
     * @param type          type of the operation
     * @param operationArgs the arguments of the operation
     */
    public CommitOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(Vcs vcs) {
        return 0;
    }
}
