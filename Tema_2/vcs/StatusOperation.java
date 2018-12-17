package vcs;

import utils.OperationType;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class StatusOperation extends VcsOperation {
    /**
     * Vcs operation constructor.
     *
     * @param type          type of the operation
     * @param operationArgs the arguments of the operation
     */
    public StatusOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(Vcs vcs) {
        List<String> list = vcs.getCommandsList();
        OutputWriter out =  vcs.getOutputWriter();
        out.write("On branch: master");
        out.write("Staged changes:");
        for(String s:list) {
            out.write(s);
        }
        return 0;
    }
}
