import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumConstraints
import java.util.*
import kotlin.collections.ArrayList

object TrajectoryGen4 {
    // Remember to set these constraints to the same values as your DriveConstants.java file in the quickstart
    private val driveConstraints = DriveConstraints(60.0, 60.0, 0.0, 270.0.toRadians4, 270.0.toRadians4, 0.0)

    // Remember to set your track width to an estimate of your actual bot to get accurate trajectory profile duration!
    private const val trackWidth = 16.0

    private val combinedConstraints = MecanumConstraints(driveConstraints, trackWidth)

    fun createTrajectory(): ArrayList<Trajectory> {
        val list = ArrayList<Trajectory>()

        val builder1 = TrajectoryBuilder(Pose2d(-48.0, 4.0, 0.0.toRadians4), 0.0.toRadians4, combinedConstraints)
        builder1.splineToConstantHeading(Vector2d(7.0,0.0), -15.0.toRadians4)
//            .splineToConstantHeading(Vector2d(7.0, -6.0), 100.0.toRadians4)
            .splineToConstantHeading(Vector2d(0.0, -15.0), 250.0.toRadians4)
            .splineToConstantHeading(Vector2d(-6.0, -24.0), -75.0.toRadians4)
            .splineToConstantHeading(Vector2d(16.0, -47.0), 25.0.toRadians4)
//            .splineToConstantHeading(Vector2d(18.0, 30.0), 50.0.toRadians4)
//            .splineToConstantHeading(Vector2d(18.0, 30.0), 50.0.toRadians4)
//            .splineToConstantHeading(Vector2d(0.0, -15.0), 10.0.toRadians5)
//            .splineToSplineHeading(Pose2d(12.0, -48.0, -130.0.toRadians5), 10.0.toRadians4)
//            .splineToConstantHeading(Vector2d(-6.0, -24.0), -100.0.toRadians5)
//            .splineToSplineHeading(Pose2d(0.0, -45.0, 50.0.toRadians4), -90.0.toRadians4)
//            .splineToConstantHeading(Vector2d(12.0, -48.0), 0.0.toRadians4)
                    // -130.0.toRadians4
//            .splineToSplineHeading(Pose2d(0.0, -42.0, -0.0.toRadians4), 100.0.toRadians4)

        val builder2 = TrajectoryBuilder(Pose2d(16.0, -47.0, 0.0.toRadians4), 0.0.toRadians4, combinedConstraints)
            .lineToSplineHeading(Pose2d(18.0, 30.0, 50.0.toRadians4))

        val builder3 = TrajectoryBuilder(Pose2d(18.0, 30.0, 50.0.toRadians4), 50.0.toRadians4, combinedConstraints)
            .splineToConstantHeading(Vector2d(46.0, 16.0), -60.0.toRadians4)

        val builder4 = TrajectoryBuilder(Pose2d(46.0, 16.0, 50.0.toRadians4), 50.0.toRadians4, combinedConstraints)
        builder4.lineToConstantHeading(Vector2d(46.0, -24.0))
//
        // Small Example Routine
//        builder1
//            .splineTo(Vector2d(10.0, 10.0), 0.0)
//            .splineTo(Vector2d(15.0, 15.0), 90.0);

        list.add(builder1.build())
        list.add(builder2.build())
        list.add(builder3.build())
        list.add(builder4.build())

        return list
    }

    fun drawOffbounds() {
        GraphicsUtil.fillRect(Vector2d(0.0, -63.0), 18.0, 18.0) // robot against the wall
    }
}

val Double.toRadians4 get() = (Math.toRadians(this))
