// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoBarrel extends SequentialCommandGroup {
  /** Creates a new AutoBarrel. */
  public AutoBarrel() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoSimple((long)3),
    new AutoLoop(0, .3, .68),
    new AutoCircle(0),
    new AutoSimple((long)2), 
    new AutoLoop(70, .68, .3),
    new AutoCircle(70),
    new AutoSimple((long)1.8),
    new AutoLoop(0, .68, .3),
    new AutoCircle(0), 
   new AutoSimple((long)1.5));
  }
}
