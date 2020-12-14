package frc.robot.systemtests.drivetrain;

import frc.lightning.fault.FaultCode;
import frc.lightning.subsystems.LightningDrivetrain;
import frc.lightning.testing.AbstractTimedSystemTest;

public class LeftSideMoves extends AbstractTimedSystemTest {
    private static final double testLength = 1.0;
    private final LightningDrivetrain drivetrain;
    private double startPosition;

    public LeftSideMoves(LightningDrivetrain drivetrain) {
       super("LeftSideDrivetrain", testLength, FaultCode.Codes.LEFT_DRIVE_FAILURE);
       this.drivetrain = drivetrain;
       addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        super.initialize();
        drivetrain.initMotorDirections();
        startPosition = drivetrain.getLeftDistance();
    }

    @Override
    public void execute() {
        super.execute();
        drivetrain.setPower(0.2, 0.0);
    }

    @Override
    public boolean didPass() {
        return startPosition < drivetrain.getLeftDistance();
    }


    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}