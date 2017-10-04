package ego.sexy.xyz.service;

/**
 * Created by foogaro on 04/10/17.
 */
public class MatchService {

    public boolean match(int take, int give) {
        return (take & give) > 0;
    }
}
