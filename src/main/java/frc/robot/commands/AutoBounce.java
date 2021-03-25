// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoBounce extends SequentialCommandGroup {
  /** Creates a new AutoBounce. */
  public AutoBounce() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoCircle((long)1, .4, .6), new AutoSimple((long)1), new AutoCircle((long)2, -.5,.5), new AutoSimple((long)2), new AutoCircle((long)3, .38, .6),new AutoSimple((long)2), new AutoCircle((long)2, -.5,.5), new AutoSimple((long)2), new AutoCircle((long)2, .38, .6), new AutoSimple((long)1), new AutoCircle((long)2, .38, .6), new AutoSimple((long)1), new AutoCircle((long)2, -.5,.5), new AutoCircle((long)2, .5,.6));
  }
}
