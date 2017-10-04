package ego.sexy.xyz.service;

import ego.sexy.xyz.model.Desire;
import ego.sexy.xyz.model.Person;
import io.vertx.core.json.JsonObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by foogaro on 04/10/17.
 */
@RunWith(JUnit4.class)
public class MatchServiceTest {

    @Test
    public void testMatchDesire() {

        Person x = new Person(new JsonObject()
                .put("nickname", "X")
                .put("age", 18)
                .put("geo", new JsonObject())
        );
        x.setTake(Desire.BJ + Desire.HJ + Desire.AFK + Desire.FMF) ;

        Person y = new Person(new JsonObject()
                .put("nickname", "Y")
                .put("age", 18)
                .put("geo", new JsonObject())
        );
        y.setGive(Desire.FK + Desire.HJ + Desire.AFK);

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        //int collision = x.getTake() & y.getGive();
        int collision = y.getGive() & x.getTake();
        System.out.println("collision = " + collision);
        System.out.println("match = " + (collision > 0));
        Assert.assertTrue(collision > 0);
    }

    @Test
    public void testNotMatchDesire() {

        Person x = new Person(new JsonObject()
                .put("nickname", "X")
                .put("age", 18)
                .put("geo", new JsonObject())
        );
        x.setTake(Desire.BJ + Desire.HJ);

        Person y = new Person(new JsonObject()
                .put("nickname", "Y")
                .put("age", 18)
                .put("geo", new JsonObject())
        );
        y.setGive(Desire.FK + Desire.AFK);

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        int collision = x.getTake() & y.getGive();
        System.out.println("collision = " + collision);
        System.out.println("match = " + (collision > 0));
        Assert.assertFalse(collision > 0);
    }

    public void testGeo() {

    }

}
