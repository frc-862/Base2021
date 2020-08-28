package frc.lightning.testing;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.lightning.fault.FaultCode;

abstract public class SystemTest extends CommandBase implements Comparable<SystemTest> {
    public static void register(SystemTest test) {
        SystemTestCommand.register(test);
    }

    public enum Priority {
        HIGH, MED, LOW, DONT_CARE
    }

    private FaultCode.Codes code;
    private Priority priority;

    public SystemTest(FaultCode.Codes code) {
        this(code, Priority.DONT_CARE);
    }

    public SystemTest(FaultCode.Codes code, Priority priority) {
        this.code = code;
        this.priority = priority;
    }

    // private double startedAt;

    public Priority getPriority() {
        return priority;
    }

    abstract public boolean didPass();

    public FaultCode.Codes getCode() {
        return code;
    }

    @Override
    public int compareTo(SystemTest other) {
        return priority.compareTo(other.priority);
    }
}