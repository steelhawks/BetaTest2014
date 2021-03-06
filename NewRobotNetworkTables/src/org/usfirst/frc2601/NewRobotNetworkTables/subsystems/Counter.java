// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc2601.NewRobotNetworkTables.subsystems;

import org.usfirst.frc2601.NewRobotNetworkTables.RobotMap;
import org.usfirst.frc2601.NewRobotNetworkTables.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;


/**
 *
 */
public class Counter extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    NetworkTable netTab = NetworkTable.getTable("dataTable");

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        //setDefaultCommand(new ResetCounter());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void plusOne() {
        double curCnt = netTab.getNumber("Current Count", 0);                
        netTab.putNumber("Previous Count", curCnt);
        netTab.putNumber("Current Count", curCnt + 1);

        netTab.putBoolean("Direction", true);
        netTab.putString("Trace", netTab.getString("Trace", "").concat("+"));
    }
    
    public void minusOne() {
        double curCnt = netTab.getNumber("Current Count", 0);                
        netTab.putNumber("Previous Count", curCnt);
        netTab.putNumber("Current Count", curCnt - 1);

        netTab.putBoolean("Direction", false);
        netTab.putString("Trace", netTab.getString("Trace", "").concat("-"));
    }
    
    public void reset() {
        netTab.putNumber("Previous Count", 0);
        netTab.putNumber("Current Count", 0);
        
        netTab.putBoolean("Direction", true);
        netTab.putString("Trace", "");

    }
}

