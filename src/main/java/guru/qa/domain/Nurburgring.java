package guru.qa.domain;

public class Nurburgring extends Track {
    @Override
    public int laps() {
        return 30;
    }

    @Override
    public int lapDistance() {
        return 5148;
    }
}
