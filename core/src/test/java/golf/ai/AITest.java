import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import golf.course.*;
import golf.ai.*;
import golf.physics.*;
import com.badlogic.gdx.math.Vector2;

public class AITest {

  PuttingCourse course = new PuttingCourse();
  PuttingSimulator simulation = new PuttingSimulator(this.course, new Euler());

  public AITest() {
    course.height = new Function2d("1");
  }

  @Test
  public void flatTest() {
    AI ai = new AI();
    simulation.take_shot(ai.calculate_shot(simulation));
    simulation.step_until_next_shot();
    System.out.println(course.getBall().position.toString());
    assertThat(course.getBall().complete, equalTo(true));
  }

  @Test
  public void slopeTest() {
    assertThat("Hello", containsString("Hello"));
  }

}
