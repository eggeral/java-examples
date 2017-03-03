package egger.software.ae_classes;

public enum Planet {

    venus(100) {
        @Override
        int distanceTo(Planet planet) {
            switch (planet) { case earth: return 1000;case mars: return 2500;} return -1;
        }
    },

    earth(150) {
        @Override
        int distanceTo(Planet planet) {
            switch (planet) { case venus: return 1000;case mars: return 1500;} return -1;
        }
    },

    mars(50) {
        int distanceTo(Planet planet) {
            switch (planet) { case venus: return 2500;case earth: return 1500;} return -1;
        }
    };

    private double mass;

    private Planet(double mass) {
        this.mass = mass;
    }

    abstract int distanceTo( Planet planet);

    @Override
    public String toString() {
        return super.toString() + " - " + mass;
    }
}
