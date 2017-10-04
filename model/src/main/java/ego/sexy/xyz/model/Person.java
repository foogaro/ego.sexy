package ego.sexy.xyz.model;

import io.vertx.core.json.JsonObject;

import java.io.Serializable;

/**
 * Created by foogaro on 04/10/17.
 */
public class Person implements Serializable {

    private String nickname;
    private int age;
    private int xyz;
    private int give;
    private int take;
    private int level;
    private GeoLocation geo;
    private String attr;

    public Person(JsonObject jsonObject) {
        this.nickname = jsonObject.getString("nickname");
        this.age = jsonObject.getInteger("age");
        this.xyz = jsonObject.getInteger("xyz", Desire.NS);
        this.give = jsonObject.getInteger("give", Desire.NS);
        this.take = jsonObject.getInteger("take", Desire.NS);
        this.level = jsonObject.getInteger("level", Desire.NS);
        this.geo = new GeoLocation(jsonObject.getJsonObject("geo"));
        this.attr = jsonObject.getString("attr");
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getXyz() {
        return xyz;
    }

    public void setXyz(int xyz) {
        this.xyz = xyz;
    }

    public int getGive() {
        return give;
    }

    public void setGive(int give) {
        this.give = give;
    }

    public int getTake() {
        return take;
    }

    public void setTake(int take) {
        this.take = take;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("nickname='").append(nickname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", xyz=").append(xyz);
        sb.append(", give=").append(give);
        sb.append(", take=").append(take);
        sb.append(", level=").append(level);
        sb.append(", attr='").append(attr).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
