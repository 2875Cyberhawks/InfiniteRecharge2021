// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// // NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// // information, see:
// // https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
// public class Auto extends SequentialCommandGroup {
//   /** Creates a new Auto. */
//   public Auto() {
//     // Add your commands in the addCommands() call, e.g.
//     // addCommands(new FooCommand(), new BarCommand());
//     //.68 and .3 for tight circle
//     addCommands(new AutoSimple((long)3), new AutoCircle((long)7.5,.3,.68),new AutoSimple((long)2), new AutoCircle((long)5.8,.68,.3), new AutoSimple((long)1), new AutoCircle((long)5.8, .68, .3), new AutoSimple((long)5));
//   }
// }
