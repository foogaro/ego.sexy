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
        boolean match = (y.getGive() & x.getTake()) > 0;
        System.out.println("match = " + match);
        Assert.assertTrue(match);
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
        boolean match = (x.getTake() & y.getGive()) > 0;
        System.out.println("match = " + match);
        Assert.assertFalse(match);
    }

    public void testGeo() {

    }

}
