import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumConstraints

object TrajectoryGen3 {
    // Remember to set these constraints to the same values as your DriveConstants.java file in the quickstart
    private val driveConstraints = DriveConstraints(60.0, 60.0, 0.0, 270.0.toRadians1, 270.0.toRadians1, 0.0)

    // Remember to set your track width to an estimate of your actual bot to get accurate trajectory profile duration!
    private const val trackWidth = 16.0

    private val combinedConstraints = MecanumConstraints(driveConstraints, trackWidth)

    private val startPose = Pose2d(-15.0, 3.0, -50.0.toRadians3)

    fun createTrajectory(): ArrayList<Trajectory> {
        val list = ArrayList<Trajectory>()

        val builder = TrajectoryBuilder(startPose, startPose.heading, combinedConstraints)
        builder.splineToSplineHeading(Pose2d(24.0, -33.0, 0.0.toRadians3), -30.0.toRadians3)
//            .splineToSplineHeading(Pose2d(36.0, 0.0, 90.0.toRadians3), 90.0.toRadians3)
            .splineToSplineHeading(Pose2d(39.0, 24.0, -90.0.toRadians3), 90.0.toRadians3)
            .splineToSplineHeading(Pose2d(33.0, 54.0, 90.0.toRadians3), 90.0.toRadians3)

//        val builder1 = TrajectoryBuilder(Pose2d(39.0, 30.0, -90.0.toRadians3), -90.0.toRadians3, combinedConstraints)
//        builder1.lineTo(Vector2d(33.0,54.0))

        // Small Example Routine
//        builder1
//            .splineTo(Vector2d(10.0, 10.0), 0.0)
//            .splineTo(Vector2d(15.0, 15.0), 90.0);

        list.add(builder.build())

        return list
    }

    fun drawOffbounds() {
        GraphicsUtil.fillRect(Vector2d(0.0, -63.0), 18.0, 18.0) // robot against the wall
    }
}

val Double.toRadians3 get() = (Math.toRadians(this))
