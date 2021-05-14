import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumConstraints

object TrajectoryGen5 {
    // Remember to set these constraints to the same values as your DriveConstants.java file in the quickstart
    private val driveConstraints = DriveConstraints(60.0, 60.0, 0.0, 270.0.toRadians5, 270.0.toRadians5, 0.0)

    // Remember to set your track width to an estimate of your actual bot to get accurate trajectory profile duration!
    private const val trackWidth = 16.0

    private val combinedConstraints = MecanumConstraints(driveConstraints, trackWidth)

    fun createTrajectory(): ArrayList<Trajectory> {
        val list = ArrayList<Trajectory>()

        val builder1 = TrajectoryBuilder(Pose2d(42.0, 58.0, 135.0.toRadians5), 135.0.toRadians5, combinedConstraints)
        builder1.lineToSplineHeading(Pose2d(-18.0, -12.0, 180.0.toRadians5))

        val builder2 = TrajectoryBuilder(Pose2d(-18.0, -12.0, 180.0.toRadians5), 180.0.toRadians5, combinedConstraints)
        builder2.splineTo(Vector2d(-18.0, 6.0), 20.0.toRadians5)
        builder2.splineTo(Vector2d(-1.0, 3.0), 20.0.toRadians5)


        // Small Example Routine
//        builder1
//            .splineTo(Vector2d(10.0, 10.0), 0.0)
//            .splineTo(Vector2d(15.0, 15.0), 90.0);

        list.add(builder1.build())
        list.add(builder2.build())

        return list
    }

    fun drawOffbounds() {
        GraphicsUtil.fillRect(Vector2d(0.0, -63.0), 18.0, 18.0) // robot against the wall
    }
}

val Double.toRadians5 get() = (Math.toRadians(this))
