package ego.sexy.xyz.service;

import ego.sexy.xyz.model.Desire;
import ego.sexy.xyz.model.Person;
import io.vertx.core.json.JsonObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by foogaro on 04/10/17.
 */
@RunWith(JUnit4.class)
public class MatchServiceTest {

    private MatchService matchService = new MatchService();

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

    @Test
    public void testScalingMatchDesire() {

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
        y.setGive(128 + Desire.BJ + Desire.AFK);

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        int collision = x.getTake() & y.getGive();
        System.out.println("collision = " + collision);
        System.out.println("match = " + (collision > 0));
        Assert.assertTrue(collision > 0);
    }

    @Test
    public void testGetMatches() {
        Person me = new Person(new JsonObject()
                .put("nickname", "Me")
                .put("age", 18)
                .put("geo", new JsonObject())
        );
        me.setTake(Desire.BJ + Desire.AFK);
        me.setGive(Desire.NS);

        Person x = new Person(new JsonObject()
                .put("nickname", "X")
                .put("age", 18)
                .put("geo", new JsonObject())
        );
        x.setTake(Desire.BJ + Desire.HJ);
        x.setGive(Desire.AFK);

        Person y = new Person(new JsonObject()
                .put("nickname", "Y")
                .put("age", 18)
                .put("geo", new JsonObject())
        );
        y.setTake(Desire.FK + Desire.AFK);
        y.setGive(Desire.FK + Desire.AFK);

        Person z = new Person(new JsonObject()
                .put("nickname", "Z")
                .put("age", 18)
                .put("geo", new JsonObject())
        );
        z.setTake(Desire.AFK);
        z.setGive(Desire.NS);

        List<Person> people = new ArrayList<>();
        people.add(x);people.add(y);people.add(z);

        List<Person> matchesr = new ArrayList<>();

        for (Person person : people) {
            if (matchService.match(me.getTake(), person.getGive())) {
                System.out.println("Matcher: " + person);
                matchesr.add(person);
            }
        }
    }

}
